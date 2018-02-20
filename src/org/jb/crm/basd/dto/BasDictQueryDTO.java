package org.jb.crm.basd.dto;

public class BasDictQueryDTO {
	private Long id;
	private String dictType;
	private String dictItem ;
	private String dictValue ;
	private Integer dictIsEditable;
	private Integer currentPage=1 ;
	private Integer pageSizes=10 ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDictType() {
		return dictType;
	}
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}
	public String getDictItem() {
		return dictItem;
	}
	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}
	public String getDictValue() {
		return dictValue;
	}
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	public Integer getDictIsEditable() {
		return dictIsEditable;
	}
	public void setDictIsEditable(Integer dictIsEditable) {
		this.dictIsEditable = dictIsEditable;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSizes() {
		return pageSizes;
	}
	public void setPageSizes(Integer pageSizes) {
		this.pageSizes = pageSizes;
	}
	
	
}
