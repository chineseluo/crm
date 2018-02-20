package org.jb.crm.cus.dto;



public class CstLinkmanQueryDTO {
	private String lkmName;
	private Integer currentPage = 1;
	private Integer pageSize = 10;
	private Long lkmCustomerId;
	


	public Long getLkmCustomerId() {
		return lkmCustomerId;
	}

	public void setLkmCustomerId(Long lkmCustomerId) {
		this.lkmCustomerId = lkmCustomerId;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}


	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}

	public String getLkmName() {
		return lkmName;
	}


	public String getLkmMemo() {
		return lkmMemo;
	}

	private String lkmMemo;
}
