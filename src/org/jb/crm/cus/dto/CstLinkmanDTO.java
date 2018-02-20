package org.jb.crm.cus.dto;


import org.jb.common.dto.BaseDTO;

public class CstLinkmanDTO extends BaseDTO {
	private String lkmCustName;
	private String lkmName;
	private String lkmSex;
	private String lkmPostion;
	private String lkmTel;
	private String lkmMobile;
	private CstCustomerDTO cstCustomerDTO;
	

	public CstCustomerDTO getCstCustomerDTO() {
		return cstCustomerDTO;
	}

	public void setCstCustomerDTO(CstCustomerDTO cstCustomerDTO) {
		this.cstCustomerDTO = cstCustomerDTO;
	}

	public void setLkmCustName(String lkmCustName) {
		this.lkmCustName = lkmCustName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	public void setLkmSex(String lkmSex) {
		this.lkmSex = lkmSex;
	}

	public void setLkmPostion(String lkmPostion) {
		this.lkmPostion = lkmPostion;
	}

	public void setLkmTel(String lkmTel) {
		this.lkmTel = lkmTel;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}

	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}

	

	public String getLkmCustName() {
		return lkmCustName;
	}

	public String getLkmName() {
		return lkmName;
	}

	public String getLkmSex() {
		return lkmSex;
	}

	public String getLkmPostion() {
		return lkmPostion;
	}

	public String getLkmTel() {
		return lkmTel;
	}

	public String getLkmMobile() {
		return lkmMobile;
	}

	public String getLkmMemo() {
		return lkmMemo;
	}



	private String lkmMemo;

}
