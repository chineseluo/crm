package org.jb.crm.sale.dto;

import java.util.Date;

import org.jb.common.dto.BaseDTO;
import org.jb.crm.sys.dto.SysUserDTO;

public class SalChanceDTO extends BaseDTO {
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
	private String chcStatus = "1";
	private SysUserDTO createUserDTO;
	private SysUserDTO dueUserDTO;
	
	
	
	

	public SysUserDTO getCreateUserDTO() {
		return createUserDTO;
	}
	public void setCreateUserDTO(SysUserDTO createUserDTO) {
		this.createUserDTO = createUserDTO;
	}
	public SysUserDTO getDueUserDTO() {
		return dueUserDTO;
	}
	public void setDueUserDTO(SysUserDTO dueUserDTO) {
		this.dueUserDTO = dueUserDTO;
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
