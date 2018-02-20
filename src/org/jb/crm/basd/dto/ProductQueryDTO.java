package org.jb.crm.basd.dto;

public class ProductQueryDTO {
	private Integer pageNum =1;
	private Integer pageSize =10;
	private String prodName;
	private String prodType;
	private String prodBatch;
	private String stkWarehouse;
	
	
	public String getStkWarehouse() {
		return stkWarehouse;
	}
	public void setStkWarehouse(String stkWarehouse) {
		this.stkWarehouse = stkWarehouse;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getProdBatch() {
		return prodBatch;
	}
	public void setProdBatch(String prodBatch) {
		this.prodBatch = prodBatch;
	}

}
