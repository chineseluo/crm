package org.jb.crm.rept.dto;

public class InstantCustomerService {
	
	public InstantCustomerService(String svrType, Long svrCount) {
		this.svrType = svrType;
		this.svrCount = svrCount;
	}
	private String svrType;
	private Long svrCount;
	public void setSvrType(String svrType) {
		this.svrType = svrType;
	}
	public void setSvrCount(Long svrCount) {
		this.svrCount = svrCount;
	}
	public String getSvrType() {
		return svrType;
	}
	public Long getSvrCount() {
		return svrCount;
	}
	
	

}
