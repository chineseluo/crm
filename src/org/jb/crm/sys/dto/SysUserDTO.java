package org.jb.crm.sys.dto;

import org.jb.common.dto.BaseDTO;

/**
 * �û�ʵ��
 * 
 * @author william
 * 
 */
public class SysUserDTO extends BaseDTO {

	private String usrName;
	private String usrPassword;
	private Integer usrFlag;
	private SysRoleDTO sysRole;

	public SysRoleDTO getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRoleDTO sysRole) {
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
