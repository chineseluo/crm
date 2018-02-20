package org.jb.crm.basd.domain;

import org.jb.common.domain.BaseDomain;


public class OrdersLine extends BaseDomain {

	private Integer oddCount;
	private String oddUnit;
	private Double oddPrice;
	private Orders orders;
	private Product product;
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	/**
	 * @return the oddCount
	 */
	public Integer getOddCount() {
		return oddCount;
	}
	/**
	 * @param oddCount the oddCount to set
	 */
	public void setOddCount(Integer oddCount) {
		this.oddCount = oddCount;
	}
	/**
	 * @return the oddUnit
	 */
	public String getOddUnit() {
		return oddUnit;
	}
	/**
	 * @param oddUnit the oddUnit to set
	 */
	public void setOddUnit(String oddUnit) {
		this.oddUnit = oddUnit;
	}
	/**
	 * @return the oddPrice
	 */
	public Double getOddPrice() {
		return oddPrice;
	}
	public void setOddPrice(Double oddPrice) {
		this.oddPrice = oddPrice;
	}

    
	

}
