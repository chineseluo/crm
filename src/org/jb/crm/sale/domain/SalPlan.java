package org.jb.crm.sale.domain;

import java.util.Date;

import org.jb.common.domain.BaseDomain;


public class SalPlan extends BaseDomain{
    private	String plaToDo;
    private String plaResult;
    private Date plaDate;
    private SalChance salChance;
    
    
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
	public SalChance getSalChance() {
		return salChance;
	}
	public void setSalChance(SalChance salChance) {
		this.salChance = salChance;
	}
}
