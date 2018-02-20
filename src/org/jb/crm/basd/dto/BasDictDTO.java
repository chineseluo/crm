package org.jb.crm.basd.dto;

import org.jb.common.dto.BaseDTO;

public class BasDictDTO extends BaseDTO{
	private String dictType;
	private String dictItem;
	private String dictValue;
	private int dictIsEditable;
	
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
	public int getDictIsEditable() {
		return dictIsEditable;
	}
	public void setDictIsEditable(int dictIsEditable) {
		this.dictIsEditable = dictIsEditable;
	}
}
