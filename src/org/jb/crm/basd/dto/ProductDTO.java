/**
 * @author cai
 * */



package org.jb.crm.basd.dto;
import org.jb.common.dto.BaseDTO;

public class ProductDTO extends  BaseDTO{
	/*
	 *商品表 
	 */
	
	private String prodName;
	private String prodType;
	private String prodBatch;
	private String prodUnit;
	private Double prodPrice;
	private String prodMemo;
	private StorageDTO storage;
	
	public StorageDTO getStorage() {
		return storage;
	}
	public void setStorage(StorageDTO storage) {
		this.storage = storage;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public void setProdBatch(String prodBatch) {
		this.prodBatch = prodBatch;
	}
	public void setProdUnit(String prodUnit) {
		this.prodUnit = prodUnit;
	}
	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public void setProdMemo(String prodMemo) {
		this.prodMemo = prodMemo;
	}
	public String getProdName() {
		return prodName;
	}
	public String getProdType() {
		return prodType;
	}
	public String getProdBatch() {
		return prodBatch;
	}
	public String getProdUnit() {
		return prodUnit;
	}
	public Double getProdPrice() {
		return prodPrice;
	}
	public String getProdMemo() {
		return prodMemo;
	}

	
	
	
	
}
