package org.jb.crm.cus.dto;




public class CstCustomerQueryDTO {
	private Long id;
	
	private Integer pageSize=10;
	private Integer currentPage=1;
	private String custNo;
	private String custName;
	private Integer custRegion;
	private String custManagerName;
	private String custLevelLabel;
	private String custStatus;
	private Long custManagerId;
	
	public String getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public String getCustNo() {
		return custNo;
	}
	public String getCustName() {
		return custName;
	}
	public Integer getCustRegion() {
		return custRegion;
	}
	public String getCustManagerName() {
		return custManagerName;
	}
	public String getCustLevelLabel() {
		return custLevelLabel;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public void setCustRegion(Integer custRegion) {
		this.custRegion = custRegion;
	}
	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName;
	}
	public void setCustLevelLabel(String custLevelLabel) {
		this.custLevelLabel = custLevelLabel;
	}
	public Long getCustManagerId() {
		return custManagerId;
	}
	public void setCustManagerId(Long custManagerId) {
		this.custManagerId = custManagerId;
	}
}
