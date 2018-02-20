package org.jb.crm.basd.domain;

import java.util.Date;
import java.util.Set;

import org.jb.common.domain.BaseDomain;

public class Orders extends  BaseDomain{
	/**
	 * 订单表
	 */
	
	private String odrCustomer;
	private Date odrDate;
	private String odrAddr;
	private String odrStatus;
	private Set<OrdersLine> ordersLines;
	public Set<OrdersLine> getOrdersLines() {
		return ordersLines;
	}
	public void setOrdersLines(Set<OrdersLine> ordersLines) {
		this.ordersLines = ordersLines;
	}
	//set
	public void setOdrCustomer(String odrCustomer) {
		this.odrCustomer = odrCustomer;
	}
	public void setOdrDate(Date odrDate) {
		this.odrDate = odrDate;
	}
	public void setOdrAddr(String odrAddr) {
		this.odrAddr = odrAddr;
	}
	public void setOdrStatus(String odrStatus) {
		this.odrStatus = odrStatus;
	}
	//get
	
	public String getOdrCustomer() {
		return odrCustomer;
	}
	public Date getOdrDate() {
		return odrDate;
	}
	public String getOdrAddr() {
		return odrAddr;
	}
	public String getOdrStatus() {
		return odrStatus;
	}
	

	
}
