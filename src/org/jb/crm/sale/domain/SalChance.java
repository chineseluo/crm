package org.jb.crm.sale.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.jb.common.domain.BaseDomain;
import org.jb.crm.sys.domain.SysUser;

public class SalChance extends BaseDomain {
	private String chcSource;
	private String chcCustName;
	private String chcTitle;
	private Integer chcRate;
	private String  chcLinkMan;
	private String  chcTel;
	private String  chcDesc;
	private String  chcCreateBy;
	private Date  chcCreateDate;
	private String chcDueTo;
	private Date  chcDueDate;
	private String chcStatus;
	private SysUser createUser;
	private SysUser dueUser;

	
	public SysUser getCreateUser() {
		return createUser;
	}
	public void setCreateUser(SysUser createUser) {
		this.createUser = createUser;
	}
	public SysUser getDueUser() {
		return dueUser;
	}
	public void setDueUser(SysUser dueUser) {
		this.dueUser = dueUser;
	}
	public String getChcSource() {
		return chcSource;
	}
	public void setChcSource(String chcSource) {
		this.chcSource = chcSource;
	}
	public String getChcCustName() {
		return chcCustName;
	}
	public void setChcCustName(String chcCustName) {
		this.chcCustName = chcCustName;
	}
	public String getChcTitle() {
		return chcTitle;
	}
	public void setChcTitle(String chcTitle) {
		this.chcTitle = chcTitle;
	}
	public Integer getChcRate() {
		return chcRate;
	}
	public void setChcRate(Integer chcRate) {
		this.chcRate = chcRate;
	}
	public String getChcLinkMan() {
		return chcLinkMan;
	}
	public void setChcLinkMan(String chcLinkMan) {
		this.chcLinkMan = chcLinkMan;
	}

	public String getChcTel() {
		return chcTel;
	}
	public void setChcTel(String chcTel) {
		this.chcTel = chcTel;
	}
	public String getChcDesc() {
		return chcDesc;
	}
	public void setChcDesc(String chcDesc) {
		this.chcDesc = chcDesc;
	}
	public String getChcCreateBy() {
		return chcCreateBy;
	}
	public void setChcCreateBy(String chcCreateBy) {
		this.chcCreateBy = chcCreateBy;
	}
	public Date getChcCreateDate() {
		return chcCreateDate;
	}
	public void setChcCreateDate(Date chcCreateDate) {
		this.chcCreateDate = chcCreateDate;
	}
	public String getChcDueTo() {
		return chcDueTo;
	}
	public void setChcDueTo(String chcDueTo) {
		this.chcDueTo = chcDueTo;
	}
	public Date getChcDueDate() {
		return chcDueDate;
	}
	public void setChcDueDate(Date chcDueDate) {
		this.chcDueDate = chcDueDate;
	}
	public String getChcStatus() {
		return chcStatus;
	}
	public void setChcStatus(String chcStatus) {
		this.chcStatus = chcStatus;
	}

	
	

}
