package org.jb.crm.cus.domain;

import java.util.Date;

import org.jb.common.domain.BaseDomain;

public class CstActivity extends  BaseDomain{
	
	
	private String atvCustName;
	private Date atvDate;
	private String atvPlace;
	private String atvTitle;
	private String atvDesc;
	private CstCustomer cstCustomer;
	public CstCustomer getCstCustomer() {
		return cstCustomer;
	}
	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
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
