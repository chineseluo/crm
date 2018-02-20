package org.jb.crm.sale.action;

import java.util.List;

import org.jb.common.action.BaseAction;
import org.jb.common.bean.Page;
import org.jb.crm.sale.dto.SalChanceDTO;
import org.jb.crm.sale.dto.SalChanceQueryDTO;
import org.jb.crm.sale.service.ISalChanceService;
import org.jb.crm.sys.dto.SysUserDTO;
import org.jb.crm.sys.service.ISysUserService;

public class SalChanceAction extends BaseAction {
	private ISalChanceService salChanceService;
	private ISysUserService sysUserService;
	private SalChanceDTO salChanceDto = new SalChanceDTO();
	private SalChanceQueryDTO salChanceQueryDto = new SalChanceQueryDTO();
	private Integer pageNum=1;
	private Integer pageSize=10;


	public String addSalChance(){
		try {
			SysUserDTO userDto = (SysUserDTO) this.getSession().get("userDto");
			salChanceDto.setCreateUserDTO(userDto);
			salChanceDto.setDueUserDTO(null);
			salChanceDto.setChcDueTo(null);
			salChanceDto.setChcDueDate(null);
			this.salChanceService.saveSalChance(salChanceDto);
			return SUCCESS;	
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}
	
	public String loadAllSalChance(){
		
		try {
			if(salChanceQueryDto.getOptionType().equals("dispatched")){
				salChanceQueryDto.setOptionType("nodispatch");
			}
			Page<SalChanceDTO> pageResult = salChanceService.findSalChanceByPage(salChanceQueryDto);
			this.getRequest().put("pageResult", pageResult);
			this.getRequest().put("queryCondition", salChanceQueryDto);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}		
	}
	public String loadAllDispatcheSalChance(){
		
		try {
			if(salChanceQueryDto.getOptionType().equals("nodispatch")){
				salChanceQueryDto.setOptionType("dispatched");
			}
			Page<SalChanceDTO> pageResult = salChanceService.findSalChanceByPage(salChanceQueryDto);
			this.getRequest().put("pageResult", pageResult);
			this.getRequest().put("queryCondition", salChanceQueryDto);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	
	
	
	
	
	public String deleteSalChance(){
		
		try {
			SalChanceDTO dto = this.salChanceService.loadSalChanceById(salChanceQueryDto);
			if(dto.getChcStatus().equals("1")){
				salChanceService.deleteSalChance(salChanceQueryDto);
				return SUCCESS;
			}else
				return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String loadSalChanceById(){
		try {			
				SalChanceDTO salChanceDto = this.salChanceService.loadSalChanceById(salChanceQueryDto);
				
				if(salChanceQueryDto.getAnotherOptionType().equals("dispatch")){
					this.getRequest().put("salChanceDto", salChanceDto);
					//还要找到所有客户经理的集合，然后把它放到request里
					List<SysUserDTO> dtoResult = sysUserService.findManager();
					this.getRequest().put("dtoResult", dtoResult);
				}
				if(salChanceQueryDto.getAnotherOptionType().equals("edit")){
					
					this.getRequest().put("salChanceDto", salChanceDto);
				}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}		
	
	public String updateSalChance(){
		try {
			
			this.salChanceService.updateSalChance(salChanceDto);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}		
	}
	
	public String saveDispatchSalChance(){
		try {
			List<SysUserDTO> dto = sysUserService.findManager();;
			for (int i = 0; i < dto.size(); i++) {
				if(salChanceDto.getDueUserDTO().getId().equals(dto.get(i).getId())){
					salChanceDto.setChcDueTo(dto.get(i).getUsrName());
				}
			}
			
			this.salChanceService.saveDispatchSalChance(salChanceDto);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	public String stopSalPlan(){
		try {
			this.salChanceService.stopSalPlan(salChanceQueryDto);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	
	
	
	public ISalChanceService getSalChanceService() {
		return salChanceService;
	}
	public void setSalChanceService(ISalChanceService salChanceService) {
		this.salChanceService = salChanceService;
	}
	public SalChanceDTO getSalChanceDto() {
		return salChanceDto;
	}
	public void setSalChanceDto(SalChanceDTO salChanceDto) {
		this.salChanceDto = salChanceDto;
	}
	public SalChanceQueryDTO getSalChanceQueryDto() {
		return salChanceQueryDto;
	}

	public void setSalChanceQueryDto(SalChanceQueryDTO salChanceQueryDto) {
		this.salChanceQueryDto = salChanceQueryDto;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

}
