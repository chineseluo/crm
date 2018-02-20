package org.jb.crm.service.domain;

import java.util.Date;

import org.jb.common.domain.BaseDomain;
import org.jb.crm.basd.domain.BasDict;
import org.jb.crm.cus.domain.CstCustomer;
import org.jb.crm.sys.domain.SysUser;

public class CstService extends BaseDomain{
	
	private BasDict svrType;
	private String svrTitle;
	private CstCustomer svrCustomer ;
	private String svrCustName;
	private String svrStatus;
	private String svrRequest;
	private SysUser svrCreator;
	private String svrCreateBy;
	private Date svrCreateDate;
	private SysUser svrDue;
	private String svrDueTo;
	private Date svrDueDate;
	private String svrDeal;
	private SysUser svrDealer;
	private String svrDealBy;
	private Date svrDealDate;
	private String svrResult;
	private Integer svrSatisfy;
	public void setSvrType(BasDict svrType) {
		this.svrType = svrType;
	}
	public void setSvrTitle(String svrTitle) {
		this.svrTitle = svrTitle;
	}
	public void setSvrCustomer(CstCustomer svrCustomer) {
		this.svrCustomer = svrCustomer;
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
	public void setSvrCreator(SysUser svrCreator) {
		this.svrCreator = svrCreator;
	}
	public void setSvrCreateBy(String svrCreateBy) {
		this.svrCreateBy = svrCreateBy;
	}
	public void setSvrCreateDate(Date svrCreateDate) {
		this.svrCreateDate = svrCreateDate;
	}
	public void setSvrDue(SysUser svrDue) {
		this.svrDue = svrDue;
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
	public void setSvrDealer(SysUser svrDealer) {
		this.svrDealer = svrDealer;
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
	public BasDict getSvrType() {
		return svrType;
	}
	public String getSvrTitle() {
		return svrTitle;
	}
	public CstCustomer getSvrCustomer() {
		return svrCustomer;
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
	public SysUser getSvrCreator() {
		return svrCreator;
	}
	public String getSvrCreateBy() {
		return svrCreateBy;
	}
	public Date getSvrCreateDate() {
		return svrCreateDate;
	}
	public SysUser getSvrDue() {
		return svrDue;
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
	public SysUser getSvrDealer() {
		return svrDealer;
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
