package org.jb.crm.sys.service;

import java.util.List;

import org.jb.common.bean.Page;
import org.jb.crm.sys.dto.SysUserDTO;
import org.jb.crm.sys.dto.SysUserQueryDTO;

public interface ISysUserService {

	/**
	 * �����û�
	 * @param sysUserDTO
	 */
	public void saveUser(SysUserDTO sysUserDTO);

	public SysUserDTO login(SysUserQueryDTO sysUserQueryDTO);

	public Page<SysUserDTO> loadAllUsersByPagging(SysUserQueryDTO sysUserQueryDTO);

	public SysUserDTO loadUserById(SysUserQueryDTO sysUserQueryDTO);

	public void modifyUser(SysUserDTO sysUserDTO);

	public void deleteUser(SysUserDTO sysUserDTO);

	public List<SysUserDTO> findManager();

}
