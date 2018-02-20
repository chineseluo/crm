package org.jb.crm.basd.dto;

public class OrdersQueryDTO {
	private String odrCustomer;
	private Long id;
	private Integer currentPage=1;
	private Integer pageSize=10;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String getOdrCustomer() {
		return odrCustomer;
	}

	public void setOdrCustomer(String odrCustomer) {
		this.odrCustomer = odrCustomer;
	}
}
