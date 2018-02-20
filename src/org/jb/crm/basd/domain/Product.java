/**
 * @author cai
 * */



package org.jb.crm.basd.domain;

import org.jb.common.domain.BaseDomain;

public class Product extends  BaseDomain{
	/*
	 *商品表 
	 */
	
	private String prodName;
	private String prodType;
	private String prodBatch;
	private String prodUnit;
	private Double prodPrice;
	private String prodMemo;
	private Storage storage;
	
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
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
