package org.jb.crm.basd.dto;

import org.jb.common.dto.BaseDTO;
import org.jb.crm.basd.domain.Orders;

public class OrdersLineDTO extends BaseDTO{
	private Integer oddCount;
	private String oddUnit;
	private Double oddPrice;
	private Orders orders;
	private ProductDTO productDTO;
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
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
