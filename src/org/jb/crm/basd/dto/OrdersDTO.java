package org.jb.crm.basd.dto;

import java.util.Date;
import java.util.Set;

import org.jb.common.dto.BaseDTO;

public class OrdersDTO extends BaseDTO {
	/**
	 * 订单表
	 */
	
	private String odrCustomer;
	private Date odrDate;
	private String odrAddr;
	private String odrStatus;
	private Set<OrdersLineDTO> ordersLineDTOs;
	
	public Set<OrdersLineDTO> getOrdersLineDTOs() {
		return ordersLineDTOs;
	}
	public void setOrdersLineDTOs(Set<OrdersLineDTO> ordersLineDTOs) {
		this.ordersLineDTOs = ordersLineDTOs;
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
