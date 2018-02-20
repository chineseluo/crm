package org.jb.crm.sys.dto;

import java.util.HashSet;
import java.util.Set;

import org.jb.common.domain.BaseDomain;
import org.jb.common.dto.BaseDTO;

/**
 * ��ɫʵ��
 * @author william
 *
 */
public class SysRoleDTO extends BaseDTO {

	private String roleName;
	private String roleDesc;
	//��Զ�ĵ������
	private Set<SysRightDTO> sysRights = new HashSet<SysRightDTO>();

	/**
	 * 0:��ɾ�� 1:����
	 */
	private Integer roleFlag;

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

	public Set<SysRightDTO> getSysRights() {
		return sysRights;
	}

	public void setSysRights(Set<SysRightDTO> sysRights) {
		this.sysRights = sysRights;
	}

}
