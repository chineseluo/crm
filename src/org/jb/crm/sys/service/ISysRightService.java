package org.jb.crm.sys.service;

import java.util.List;

import org.jb.crm.sys.dto.SysRightDTO;
import org.jb.crm.sys.dto.SysRightQueryDTO;

/**
 * Ȩ��ҵ���ӿ�
 * 
 * @author william
 * 
 */
public interface ISysRightService {

	/**
	 * ����Ȩ��
	 * 
	 * @return
	 */
	public List<SysRightDTO> loadRights(SysRightQueryDTO sysRightQueryDTO);
	
	/**
	 * ���ݽ�ɫID����Ȩ��
	 */
	public List<SysRightDTO> loadRightsByRole(SysRightQueryDTO sysRightQueryDTO);
	
}




