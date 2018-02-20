package org.jb.crm.rept.dto;

public class InstantCustomer {
	private String name;
	private Double allMoney;
	
	public InstantCustomer(String name,Double allMoney){		
		this.name = name;
		this.allMoney = allMoney;		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(Double allMoney) {
		this.allMoney = allMoney;
	}
	

}
