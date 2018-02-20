package org.jb.crm.cus.domain;

import java.util.Set;

import org.jb.common.domain.BaseDomain;
import org.jb.crm.basd.domain.BasDict;
import org.jb.crm.sys.domain.SysUser;

public class CstCustomer extends  BaseDomain{
	
	
	private String custNo;
	private String custName;
	private BasDict custRegion;
	private SysUser custManager;
	private String custManagerName;
	private BasDict custLevel;
	private String custLevelLabel;
	private Integer custSatisfy;
	private Integer custCredit;
	private String custAddr;
	private String custZip;
	private String custTel;
	private String custFax;
	private String custWebsite;
	private String custLicenceNo;
	private String custChieftain;
	private Long custBankroll;
	private Long custTurnover;
	private String custBank;
	private String custBankAccount;
	private String custLocalTaxNo;
	private String custNationalTaxNo;
	private String custStatus;
	private Set<CstLinkman> cstLinkmans;
	private Set<CstLost> cstLosts;
	public Set<CstLost> getCstLosts() {
		return cstLosts;
	}
	public void setCstLosts(Set<CstLost> cstLosts) {
		this.cstLosts = cstLosts;
	}
	public Set<CstLinkman> getCstLinkmans() {
		return cstLinkmans;
	}
	public void setCstLinkmans(Set<CstLinkman> cstLinkmans) {
		this.cstLinkmans = cstLinkmans;
	}
	public SysUser getCustManager() {
		return custManager;
	}
	public void setCustManager(SysUser custManager) {
		this.custManager = custManager;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public void setCustRegion(BasDict custRegion) {
		this.custRegion = custRegion;
	}
	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName;
	}
	public void setCustLevel(BasDict custLevel) {
		this.custLevel = custLevel;
	}
	public void setCustLevelLabel(String custLevelLabel) {
		this.custLevelLabel = custLevelLabel;
	}
	public void setCustSatisfy(Integer custSatisfy) {
		this.custSatisfy = custSatisfy;
	}
	public void setCustCredit(Integer custCredit) {
		this.custCredit = custCredit;
	}
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}
	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}
	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}
	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}
	public void setCustLicenceNo(String custLicenceNo) {
		this.custLicenceNo = custLicenceNo;
	}
	public void setCustChieftain(String custChieftain) {
		this.custChieftain = custChieftain;
	}
	public void setCustBankroll(Long custBankroll) {
		this.custBankroll = custBankroll;
	}
	public void setCustTurnover(Long custTurnover) {
		this.custTurnover = custTurnover;
	}
	public void setCustBank(String custBank) {
		this.custBank = custBank;
	}
	public void setCustBankAccount(String custBankAccount) {
		this.custBankAccount = custBankAccount;
	}
	public void setCustLocalTaxNo(String custLocalTaxNo) {
		this.custLocalTaxNo = custLocalTaxNo;
	}
	public void setCustNationalTaxNo(String custNationalTaxNo) {
		this.custNationalTaxNo = custNationalTaxNo;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	public String getCustName() {
		return custName;
	}
	public BasDict getCustRegion() {
		return custRegion;
	}
	public String getCustManagerName() {
		return custManagerName;
	}
	public BasDict getCustLevel() {
		return custLevel;
	}
	public String getCustLevelLabel() {
		return custLevelLabel;
	}
	public Integer getCustSatisfy() {
		return custSatisfy;
	}
	public Integer getCustCredit() {
		return custCredit;
	}
	public String getCustAddr() {
		return custAddr;
	}
	public String getCustZip() {
		return custZip;
	}
	public String getCustTel() {
		return custTel;
	}
	public String getCustFax() {
		return custFax;
	}
	public String getCustWebsite() {
		return custWebsite;
	}
	public String getCustLicenceNo() {
		return custLicenceNo;
	}
	public String getCustChieftain() {
		return custChieftain;
	}
	public Long getCustBankroll() {
		return custBankroll;
	}
	public Long getCustTurnover() {
		return custTurnover;
	}
	public String getCustBank() {
		return custBank;
	}
	public String getCustBankAccount() {
		return custBankAccount;
	}
	public String getCustLocalTaxNo() {
		return custLocalTaxNo;
	}
	public String getCustNationalTaxNo() {
		return custNationalTaxNo;
	}
	public String getCustStatus() {
		return custStatus;
	}

}
