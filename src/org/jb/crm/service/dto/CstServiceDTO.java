package org.jb.crm.service.dto;

import java.util.Date;

import org.jb.common.dto.BaseDTO;
import org.jb.crm.basd.dto.BasDictDTO;
import org.jb.crm.cus.dto.CstCustomerDTO;
import org.jb.crm.sys.dto.SysUserDTO;

public class CstServiceDTO extends BaseDTO{
	private BasDictDTO svrTypeDTO;
	private String svrTitle;
	private CstCustomerDTO svrCustomerDTO ;
	private String svrCustName;
	private String svrStatus;
	private String svrRequest;
	private SysUserDTO svrCreatorDTO;
	private String svrCreateBy;
	private Date svrCreateDate;
	private SysUserDTO svrDueDTO;
	private String svrDueTo;
	private Date svrDueDate;
	private String svrDeal;
	private SysUserDTO svrDealerDTO;
	private String svrDealBy;
	private Date svrDealDate;
	private String svrResult;
	private Integer svrSatisfy;
	public void setSvrTypeDTO(BasDictDTO svrTypeDTO) {
		this.svrTypeDTO = svrTypeDTO;
	}
	public void setSvrTitle(String svrTitle) {
		this.svrTitle = svrTitle;
	}
	public void setSvrCustomerDTO(CstCustomerDTO svrCustomerDTO) {
		this.svrCustomerDTO = svrCustomerDTO;
	}
	public void setSvrCustName(String svrCustName) {
		this.svrCustName = svrCustName;
	}
	public void setSvrStatus(String svrStatus) {
		this.svrStatus = svrStatus;
	}
	public void setSvrRequest(String svrRequest) {
		this.svrRequest = svrRequest;
	}
	public void setSvrCreatorDTO(SysUserDTO svrCreatorDTO) {
		this.svrCreatorDTO = svrCreatorDTO;
	}
	public void setSvrCreateBy(String svrCreateBy) {
		this.svrCreateBy = svrCreateBy;
	}
	public void setSvrCreateDate(Date svrCreateDate) {
		this.svrCreateDate = svrCreateDate;
	}
	public void setSvrDueDTO(SysUserDTO svrDueDTO) {
		this.svrDueDTO = svrDueDTO;
	}
	public void setSvrDueTo(String svrDueTo) {
		this.svrDueTo = svrDueTo;
	}
	public void setSvrDueDate(Date svrDueDate) {
		this.svrDueDate = svrDueDate;
	}
	public void setSvrDeal(String svrDeal) {
		this.svrDeal = svrDeal;
	}
	public void setSvrDealerDTO(SysUserDTO svrDealerDTO) {
		this.svrDealerDTO = svrDealerDTO;
	}
	public void setSvrDealBy(String svrDealBy) {
		this.svrDealBy = svrDealBy;
	}
	public void setSvrDealDate(Date svrDealDate) {
		this.svrDealDate = svrDealDate;
	}
	public void setSvrResult(String svrResult) {
		this.svrResult = svrResult;
	}
	public void setSvrSatisfy(Integer svrSatisfy) {
		this.svrSatisfy = svrSatisfy;
	}
	public BasDictDTO getSvrTypeDTO() {
		return svrTypeDTO;
	}
	public String getSvrTitle() {
		return svrTitle;
	}
	public CstCustomerDTO getSvrCustomerDTO() {
		return svrCustomerDTO;
	}
	public String getSvrCustName() {
		return svrCustName;
	}
	public String getSvrStatus() {
		return svrStatus;
	}
	public String getSvrRequest() {
		return svrRequest;
	}
	public SysUserDTO getSvrCreatorDTO() {
		return svrCreatorDTO;
	}
	public String getSvrCreateBy() {
		return svrCreateBy;
	}
	public Date getSvrCreateDate() {
		return svrCreateDate;
	}
	public SysUserDTO getSvrDueDTO() {
		return svrDueDTO;
	}
	public String getSvrDueTo() {
		return svrDueTo;
	}
	public Date getSvrDueDate() {
		return svrDueDate;
	}
	public String getSvrDeal() {
		return svrDeal;
	}
	public SysUserDTO getSvrDealerDTO() {
		return svrDealerDTO;
	}
	public String getSvrDealBy() {
		return svrDealBy;
	}
	public Date getSvrDealDate() {
		return svrDealDate;
	}
	public String getSvrResult() {
		return svrResult;
	}
	public Integer getSvrSatisfy() {
		return svrSatisfy;
	}
	
	
	
}
