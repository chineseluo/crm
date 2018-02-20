package org.jb.crm.sale.dto;

import java.util.Date;

import org.jb.common.dto.BaseDTO;


public class SalPlanDTO extends BaseDTO {
	private	String plaToDo;
    private String plaResult;
    private Date plaDate;
    private SalChanceDTO salChanceDTO;
    
    
	public Date getPlaDate() {
		return plaDate;
	}
	public void setPlaDate(Date plaDate) {
		this.plaDate = plaDate;
	}
	public String getPlaToDo() {
		return plaToDo;
	}
	public void setPlaToDo(String plaToDo) {
		this.plaToDo = plaToDo;
	}
	public String getPlaResult() {
		return plaResult;
	}
	public void setPlaResult(String plaResult) {
		this.plaResult = plaResult;
	}
	public SalChanceDTO getSalChanceDTO() {
		return salChanceDTO;
	}
	public void setSalChanceDTO(SalChanceDTO salChanceDTO) {
		this.salChanceDTO = salChanceDTO;
	}

}
