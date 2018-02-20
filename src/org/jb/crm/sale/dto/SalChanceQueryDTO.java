package org.jb.crm.sale.dto;

public class SalChanceQueryDTO {
	
	private Integer pageNum =1;
	private Integer pageSize =10;
	private String  chcLinkMan;
	private String chcCustName;
	private String chcTitle;
	private String chcStatus="1";
	private String  chcCreateBy;
	private Long id;
	private String optionType ="nodispatch";
	private String anotherOptionType;
	
	
	
	

	public String getAnotherOptionType() {
		return anotherOptionType;
	}
	public void setAnotherOptionType(String anotherOptionType) {
		this.anotherOptionType = anotherOptionType;
	}
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChcCreateBy() {
		return chcCreateBy;
	}
	public void setChcCreateBy(String chcCreateBy) {
		this.chcCreateBy = chcCreateBy;
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
	public String getChcLinkMan() {
		return chcLinkMan;
	}
	public void setChcLinkMan(String chcLinkMan) {
		this.chcLinkMan = chcLinkMan;
	}
	public String getChcCustName() {
		return chcCustName;
	}
	public void setChcCustName(String chcCustName) {
		this.chcCustName = chcCustName;
	}
	public String getChcTitle() {
		return chcTitle;
	}
	public void setChcTitle(String chcTitle) {
		this.chcTitle = chcTitle;
	}
	public String getChcStatus() {
		return chcStatus;
	}
	public void setChcStatus(String chcStatus) {
		this.chcStatus = chcStatus;
	}
	

}
