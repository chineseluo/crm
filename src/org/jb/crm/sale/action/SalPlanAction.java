package org.jb.crm.sale.action;

import java.util.List;

import org.jb.common.action.BaseAction;
import org.jb.crm.cus.service.ICstCustomerService;
import org.jb.crm.sale.dto.SalChanceDTO;
import org.jb.crm.sale.dto.SalChanceQueryDTO;
import org.jb.crm.sale.dto.SalPlanDTO;
import org.jb.crm.sale.dto.SalPlanQueryDTO;
import org.jb.crm.sale.service.ISalChanceService;
import org.jb.crm.sale.service.ISalPlanService;

public class SalPlanAction extends BaseAction {
	private ISalPlanService salPlanService;
	private ISalChanceService salChanceService;
	private ICstCustomerService cstCustomerService;
	private SalChanceQueryDTO salChanceQueryDto = new SalChanceQueryDTO();
	private SalChanceDTO salChanceDto = new SalChanceDTO();
	private SalPlanDTO salPlanDto =new SalPlanDTO();
	private SalPlanQueryDTO salPlanQueryDto = new SalPlanQueryDTO();
	
	
    public  String findDispatchSalChanceAndSalPlanById(){
		
		try {
			SalChanceDTO salChanceDto = this.salChanceService.loadSalChanceById(salChanceQueryDto);
			List<SalPlanDTO> salPlanDtoList = this.salPlanService.loadSalPlanBySalChanceId(salChanceQueryDto);
			this.getRequest().put("salChanceDto", salChanceDto);
			this.getRequest().put("salPlanDtoList", salPlanDtoList);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String savePlan(){
		try {
			this.salPlanService.savePlan(salPlanDto);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
    
	
	public String updateSalPlan(){
		try {		
			//要进行中文转码
			String planTodo = new String(salPlanQueryDto.getPlaToDo().getBytes("iso8859-1"),"UTF-8");
			salPlanQueryDto.setPlaToDo(planTodo);
			this.salPlanService.updateSalPlan(salPlanQueryDto);	
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
    
	public String deleteSalPlan(){
		try {			
			this.salPlanService.delateSalPlan(salPlanQueryDto);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	
	
	public String saveExecutePlanResult(){
		try {
			String result = new String(salPlanQueryDto.getPlaResult().getBytes("iso8859-1"),"UTF-8");
			salPlanQueryDto.setPlaResult(result);
			this.salPlanService.saveExecutePlanResult(salPlanQueryDto);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	
	public String developmentSuccess(){
		
		try {
			this.salChanceService.developmentSuccess(salChanceQueryDto);
			salChanceDto = this.salChanceService.loadSalChanceById(salChanceQueryDto);
			this.cstCustomerService.addCstCustomer(salChanceDto);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	
	public void setSalPlanService(ISalPlanService salPlanService) {
		this.salPlanService = salPlanService;
	}


	public void setSalChanceService(ISalChanceService salChanceService) {
		this.salChanceService = salChanceService;
	}


	public SalChanceQueryDTO getSalChanceQueryDto() {
		return salChanceQueryDto;
	}


	public void setSalChanceQueryDto(SalChanceQueryDTO salChanceQueryDto) {
		this.salChanceQueryDto = salChanceQueryDto;
	}


	public SalChanceDTO getSalChanceDto() {
		return salChanceDto;
	}


	public void setSalChanceDto(SalChanceDTO salChanceDto) {
		this.salChanceDto = salChanceDto;
	}


	public SalPlanDTO getSalPlanDto() {
		return salPlanDto;
	}


	public void setSalPlanDto(SalPlanDTO salPlanDto) {
		this.salPlanDto = salPlanDto;
	}
	public SalPlanQueryDTO getSalPlanQueryDto() {
		return salPlanQueryDto;
	}
	public void setSalPlanQueryDto(SalPlanQueryDTO salPlanQueryDto) {
		this.salPlanQueryDto = salPlanQueryDto;
	}
	public void setCstCustomerService(ICstCustomerService cstCustomerService) {
		this.cstCustomerService = cstCustomerService;
	}


}
