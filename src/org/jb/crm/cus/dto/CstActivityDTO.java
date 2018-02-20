package org.jb.crm.cus.dto;

import java.util.Date;

import org.jb.common.dto.BaseDTO;

public class CstActivityDTO extends BaseDTO {
	private String atvCustName;
	private Date atvDate;
	private String atvPlace;
	private String atvTitle;
	private String atvDesc;
	private CstCustomerDTO cstCustomerDTO;
	public CstCustomerDTO getCstCustomerDTO() {
		return cstCustomerDTO;
	}
	public void setCstCustomerDTO(CstCustomerDTO cstCustomerDTO) {
		this.cstCustomerDTO = cstCustomerDTO;
	}
	public void setAtvCustName(String atvCustName) {
		this.atvCustName = atvCustName;
	}
	public void setAtvDate(Date atvDate) {
		this.atvDate = atvDate;
	}
	public void setAtvPlace(String atvPlace) {
		this.atvPlace = atvPlace;
	}
	public void setAtvTitle(String atvTitle) {
		this.atvTitle = atvTitle;
	}
	public void setAtvDesc(String atvDesc) {
		this.atvDesc = atvDesc;
	}
	public String getAtvCustName() {
		return atvCustName;
	}
	public Date getAtvDate() {
		return atvDate;
	}
	public String getAtvPlace() {
		return atvPlace;
	}
	public String getAtvTitle() {
		return atvTitle;
	}
	public String getAtvDesc() {
		return atvDesc;
	}
}
