package org.jb.crm.sys.dto;

/**
 * ��ɫ��ѯDTO ��ѯDTO��������ԣ���Դ��ǰ̨�Ĳ�ѯ����
 * 
 * @author william
 * 
 */
public class SysRoleQueryDTO {

	private Long id;

	private String roleName;
	private Integer roleFlag;
	private Integer currentPage = 1;
	private Integer pageSize = 10;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleFlag() {
		return roleFlag;
	}

	public void setRoleFlag(Integer roleFlag) {
		this.roleFlag = roleFlag;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
