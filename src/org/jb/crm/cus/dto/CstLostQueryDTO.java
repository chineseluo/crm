package org.jb.crm.cus.dto;

public class CstLostQueryDTO {
	private Long id;
	private Integer currentPage=1;
	private Integer pageSize=10;
	private Long lstCustManagerId;
	private String lstCustManagerName;
	private String lstCustName;
	private String lstStatus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public Long getLstCustManagerId() {
		return lstCustManagerId;
	}
	public String getLstCustManagerName() {
		return lstCustManagerName;
	}
	public String getLstCustName() {
		return lstCustName;
	}
	public String getLstStatus() {
		return lstStatus;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setLstCustManagerId(Long lstCustManagerId) {
		this.lstCustManagerId = lstCustManagerId;
	}
	public void setLstCustManagerName(String lstCustManagerName) {
		this.lstCustManagerName = lstCustManagerName;
	}
	public void setLstCustName(String lstCustName) {
		this.lstCustName = lstCustName;
	}
	public void setLstStatus(String lstStatus) {
		this.lstStatus = lstStatus;
	}
	
}
