package org.jb.crm.cus.action;

import java.util.List;

import org.jb.common.action.BaseAction;
import org.jb.common.bean.Page;
import org.jb.crm.basd.dto.BasDictDTO;
import org.jb.crm.basd.dto.BasDictQueryDTO;
import org.jb.crm.basd.service.IBasDictService;
import org.jb.crm.cus.dto.CstCustomerDTO;
import org.jb.crm.cus.dto.CstCustomerQueryDTO;
import org.jb.crm.cus.service.ICstCustomerService;
import org.jb.crm.sys.dto.SysUserDTO;
import org.jb.crm.sys.dto.SysUserQueryDTO;
import org.jb.crm.sys.service.ISysUserService;

import com.opensymphony.xwork2.ModelDriven;

public class CstCustomerAction extends BaseAction implements ModelDriven<CstCustomerDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ICstCustomerService cstCustomerService;

	public void setCstCustomerService(ICstCustomerService cstCustomerService) {
		this.cstCustomerService = cstCustomerService;
	}

	private CstCustomerQueryDTO cstCustomerQueryDTO=new CstCustomerQueryDTO();

	public CstCustomerQueryDTO getCstCustomerQueryDTO() {
		return cstCustomerQueryDTO;
	}

	private CstCustomerDTO cstCustomerDTO=new CstCustomerDTO();

	private Page<CstCustomerDTO> pageResult;

	public Page<CstCustomerDTO> getPageResult() {
		return pageResult;
	}

	private List<BasDictDTO> customerLevels;
	
	public List<BasDictDTO> getCustomerLevels() {
		return customerLevels;
	}
	
	private List<BasDictDTO> customerRegions;
	
	public List<BasDictDTO> getCustomerRegions() {
		return customerRegions;
	}

	private IBasDictService basDictService;

	public void setBasDictService(IBasDictService basDictService) {
		this.basDictService = basDictService;
	}



	public String loadAllCstCustomers() {
		try {
			pageResult = cstCustomerService.getByPaging(cstCustomerQueryDTO);
			this.getRequest().put("queryCondition", cstCustomerQueryDTO);
			customerLevels=basDictService.loadAllDictsByType("企业客户等级");
			customerRegions=basDictService.loadAllDictsByType("地区");
			this.getRequest().put("queryCondition", cstCustomerQueryDTO);
			return "toListCstCustomerPage";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	

	public String loadCstCustomersByManager() {
		try {
			SysUserDTO sysUserDTO=(SysUserDTO) this.getSession().get("userDto");
			cstCustomerQueryDTO.setCustManagerId(sysUserDTO.getId());
			pageResult = cstCustomerService.getByPaging(cstCustomerQueryDTO);
			customerLevels=basDictService.loadAllDictsByType("企业客户等级");
			customerRegions=basDictService.loadAllDictsByType("地区");
			this.getRequest().put("queryCondition", cstCustomerQueryDTO);
			return "toListCstCustomerPage";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	
	public String deleteCstCustomer(){
		try {
			SysUserDTO sysUserDTO=(SysUserDTO) this.getSession().get("userDto");
			cstCustomerDTO.setCustStatus("3");
			cstCustomerService.deleteCstCustomer(cstCustomerDTO,sysUserDTO);
			return "loadCstCustomersByManager";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}
	private ISysUserService sysUserService;
	
	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}



	public String toModifyCstCustomerPage(){
		try {
			List<SysUserDTO> cstCustomerManagers=sysUserService.findManager();
			cstCustomerDTO=cstCustomerService.getById(cstCustomerQueryDTO.getId());
			customerLevels=basDictService.loadAllDictsByType("企业客户等级");
			customerRegions=basDictService.loadAllDictsByType("地区");
			this.getRequest().put("cstCustomerManagers", cstCustomerManagers);
			return "toModifyCstCustomerPage";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	public String modifyCstCustomer(){
		try {
			SysUserQueryDTO sysUserQueryDTO=new SysUserQueryDTO();
			sysUserQueryDTO.setId(cstCustomerDTO.getCustManager().getId());
			cstCustomerDTO.setCustManagerName(sysUserService.loadUserById(sysUserQueryDTO).getUsrName());
			BasDictQueryDTO basDictQueryDTO=new BasDictQueryDTO();
			basDictQueryDTO.setId(cstCustomerDTO.getCustLevel().getId());
			cstCustomerDTO.setCustLevelLabel(basDictService.loadBasDictById(basDictQueryDTO).getDictItem());
			cstCustomerService.updateCstCustomer(cstCustomerDTO);
			return "loadCstCustomersByManager";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}

	@Override
	public CstCustomerDTO getModel() {
		return cstCustomerDTO;
	}

}
