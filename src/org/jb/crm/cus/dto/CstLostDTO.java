package org.jb.crm.cus.dto;

import java.util.Date;

import org.jb.common.dto.BaseDTO;
import org.jb.crm.sys.dto.SysUserDTO;

public class CstLostDTO extends BaseDTO{
	private CstCustomerDTO lstCustomerDTO ;///////外键
	private SysUserDTO lstCustManagerDTO;
	private String lstCustName;
	private String lstCustManagerName;
	private Date lstLastOrderDate;
	private Date lstLostDate;
	private String lstDelay;
	private String lstReason;
	private String lstStatus;
	public CstCustomerDTO getLstCustomerDTO() {
		return lstCustomerDTO;
	}
	public SysUserDTO getLstCustManagerDTO() {
		return lstCustManagerDTO;
	}
	public String getLstCustName() {
		return lstCustName;
	}
	public String getLstCustManagerName() {
		return lstCustManagerName;
	}
	public Date getLstLastOrderDate() {
		return lstLastOrderDate;
	}
	public Date getLstLostDate() {
		return lstLostDate;
	}
	public String getLstDelay() {
		return lstDelay;
	}
	public String getLstReason() {
		return lstReason;
	}
	public String getLstStatus() {
		return lstStatus;
	}
	public void setLstCustomerDTO(CstCustomerDTO lstCustomerDTO) {
		this.lstCustomerDTO = lstCustomerDTO;
	}
	public void setLstCustManagerDTO(SysUserDTO lstCustManagerDTO) {
		this.lstCustManagerDTO = lstCustManagerDTO;
	}
	public void setLstCustName(String lstCustName) {
		this.lstCustName = lstCustName;
	}
	public void setLstCustManagerName(String lstCustManagerName) {
		this.lstCustManagerName = lstCustManagerName;
	}
	public void setLstLastOrderDate(Date lstLastOrderDate) {
		this.lstLastOrderDate = lstLastOrderDate;
	}
	public void setLstLostDate(Date lstLostDate) {
		this.lstLostDate = lstLostDate;
	}
	public void setLstDelay(String lstDelay) {
		this.lstDelay = lstDelay;
	}
	public void setLstReason(String lstReason) {
		this.lstReason = lstReason;
	}
	public void setLstStatus(String lstStatus) {
		this.lstStatus = lstStatus;
	}
	
	
	
}
