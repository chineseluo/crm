package org.jb.crm.sys.domain;

import java.util.HashSet;
import java.util.Set;

import org.jb.common.domain.BaseDomain;

/**
 * ��ɫʵ��
 * @author william
 *
 */
public class SysRole extends BaseDomain {

	private String roleName;
	private String roleDesc;
	//��Զ�ĵ������
	private Set<SysRight> sysRights = new HashSet<SysRight>();

	/**
	 * 0:��ɾ�� 1:����
	 */
	private Integer roleFlag = 1;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getRoleFlag() {
		return roleFlag;
	}

	public void setRoleFlag(Integer roleFlag) {
		this.roleFlag = roleFlag;
	}

	public Set<SysRight> getSysRights() {
		return sysRights;
	}

	public void setSysRights(Set<SysRight> sysRights) {
		this.sysRights = sysRights;
	}

}
