package org.jb.crm.sys.service;

import java.util.List;

import org.jb.crm.sys.dto.SysRightDTO;
import org.jb.crm.sys.dto.SysRightQueryDTO;

/**
 * 权限业务层接口
 * 
 * @author william
 * 
 */
public interface ISysRightService {

	/**
	 * 加载权限
	 * 
	 * @return
	 */
	public List<SysRightDTO> loadRights(SysRightQueryDTO sysRightQueryDTO);
	
	/**
	 * 根据角色ID加载权限
	 */
	public List<SysRightDTO> loadRightsByRole(SysRightQueryDTO sysRightQueryDTO);
	
}




