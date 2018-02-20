package org.jb.crm.cus.domain;

import java.util.Date;

import org.jb.common.domain.BaseDomain;
import org.jb.crm.sys.domain.SysUser;
public class CstLost extends BaseDomain{
	private CstCustomer lstCustomer ;///////外键
	private SysUser lstCustManager;
	private String lstCustName;
	private String lstCustManagerName;
	private Date lstLastOrderDate;
	private Date lstLostDate;
	private String lstDelay;
	private String lstReason;
	private String lstStatus;
	public CstCustomer getLstCustomer() {
		return lstCustomer;
	}
	public SysUser getLstCustManager() {
		return lstCustManager;
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
	public void setLstCustomer(CstCustomer lstCustomer) {
		this.lstCustomer = lstCustomer;
	}
	public void setLstCustManager(SysUser lstCustManager) {
		this.lstCustManager = lstCustManager;
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
