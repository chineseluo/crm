package org.jb.crm.sys.dto;

public class SysUserQueryDTO {

	private Long id;
	
	private String usrName;
	private String usrPassword;
	
	private Integer usrFlag;
	private Integer currentPage =  1;
	private Integer pageSize = 10;
	
	private Long roleId;
	
	private String opeartorType ;//²Ù×÷ÀàÐÍ
	
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getUsrPassword() {
		return usrPassword;
	}
	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}
	public Integer getUsrFlag() {
		return usrFlag;
	}
	public void setUsrFlag(Integer usrFlag) {
		this.usrFlag = usrFlag;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getOpeartorType() {
		return opeartorType;
	}
	public void setOpeartorType(String opeartorType) {
		this.opeartorType = opeartorType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
	
}
