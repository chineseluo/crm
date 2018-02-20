package org.jb.crm.sys.service;

import java.util.List;

import org.jb.common.bean.Page;
import org.jb.crm.sys.dto.SysRoleDTO;
import org.jb.crm.sys.dto.SysRoleQueryDTO;

public interface ISysRoleService {

	public void addRole(SysRoleDTO sysRoleDTO);

	/**
	 * 根据查询条件，进行分页查询
	 * 
	 * @param sysRoleQueryDTO
	 * @return
	 */
	public Page<SysRoleDTO> loadAllRolesByPagging(
			SysRoleQueryDTO sysRoleQueryDTO);

	public SysRoleDTO loadRoleById(SysRoleQueryDTO sysRoleQueryDTO);
	
	public void mofidyRole(SysRoleDTO sysRoleDTO);

	public void deleteRole(SysRoleDTO sysRoleDTO);
	
	public List<SysRoleDTO> loadAllNormalRoles(SysRoleQueryDTO sysRoleQueryDTO);
	
	
}
