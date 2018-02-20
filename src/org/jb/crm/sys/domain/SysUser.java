package org.jb.crm.sys.domain;

import org.jb.common.domain.BaseDomain;

/**
 * 用户实体
 * @author william
 *
 */
public class SysUser extends BaseDomain{

	private String usrName;
	private String usrPassword;
	private Integer usrFlag = 1;
	//单向多对一关联
	private SysRole sysRole;
	
	public SysRole getSysRole() {
		return sysRole;
	}
	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}
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
	
	
}
