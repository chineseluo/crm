package org.jb.crm.sys.dao;

import java.util.List;

import org.jb.common.dao.IBaseDAO;
import org.jb.crm.sys.domain.SysRight;
import org.jb.crm.sys.dto.SysRightQueryDTO;

/**
 * Ȩ��dao�ӿ�
 * @author william
 *
 */
public interface ISysRightDao extends IBaseDAO<Long, SysRight> {

	/**
	 * ���ݸ���ID,����Ȩ����
	 * @param sysRightQueryDTO
	 * @return
	 */
	public List<SysRight> getRights(SysRightQueryDTO sysRightQueryDTO);
	
}
