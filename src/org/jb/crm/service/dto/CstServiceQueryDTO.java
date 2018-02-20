package org.jb.crm.service.dto;

import java.util.Date;

public class CstServiceQueryDTO {
	private Long id;
	private String svrCustName;
	private String svrTitle;
	private Long svrTypeId;
	private Date svrCreateDateFrom;
	private Date svrCreateDateTo;
	private String svrStatus;
	private Long svrDueId;
	
	private Integer currentPage=1;
	private Integer pageSize=10;
	
	
	public Long getSvrDueId() {
		return svrDueId;
	}
	public void setSvrDueId(Long svrDueId) {
		this.svrDueId = svrDueId;
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
	public void setId(Long id) {
		this.id = id;
	}
	public void setSvrCustName(String svrCustName) {
		this.svrCustName = svrCustName;
	}
	public void setSvrTitle(String svrTitle) {
		this.svrTitle = svrTitle;
	}
	public void setSvrTypeId(Long svrTypeId) {
		this.svrTypeId = svrTypeId;
	}
	public void setSvrCreateDateFrom(Date svrCreateDateFrom) {
		this.svrCreateDateFrom = svrCreateDateFrom;
	}
	public void setSvrCreateDateTo(Date svrCreateDateTo) {
		this.svrCreateDateTo = svrCreateDateTo;
	}
	public void setSvrStatus(String svrStatus) {
		this.svrStatus = svrStatus;
	}
	public Long getId() {
		return id;
	}
	public String getSvrCustName() {
		return svrCustName;
	}
	public String getSvrTitle() {
		return svrTitle;
	}
	public Long getSvrTypeId() {
		return svrTypeId;
	}
	public Date getSvrCreateDateFrom() {
		return svrCreateDateFrom;
	}
	public Date getSvrCreateDateTo() {
		return svrCreateDateTo;
	}
	public String getSvrStatus() {
		return svrStatus;
	}
}
