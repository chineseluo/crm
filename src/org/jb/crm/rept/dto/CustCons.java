package org.jb.crm.rept.dto;

public class CustCons {
	private String custLevel;
	private Integer sasifyOrCredit;
	private Long custCount;
	
	public CustCons(String custLevel,Long custCount){
		this.custLevel = custLevel;
		this.custCount = custCount;
	}
	public CustCons(Integer sasifyOrCredit,Long custCount){
		this.sasifyOrCredit = sasifyOrCredit;
		this.custCount = custCount;
	}
	
	
	
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public Integer getSasifyOrCredit() {
		return sasifyOrCredit;
	}
	public void setSasifyOrCredit(Integer sasifyOrCredit) {
		this.sasifyOrCredit = sasifyOrCredit;
	}
	public Long getCustCount() {
		return custCount;
	}
	public void setCustCount(Long custCount) {
		this.custCount = custCount;
	}

}
