package org.jb.crm.sys.dao;

import java.util.List;

import org.jb.common.dao.IBaseDAO;
import org.jb.crm.sys.domain.SysRight;
import org.jb.crm.sys.dto.SysRightQueryDTO;

/**
 * 权限dao接口
 * @author william
 *
 */
public interface ISysRightDao extends IBaseDAO<Long, SysRight> {

	/**
	 * 根据父类ID,加载权限树
	 * @param sysRightQueryDTO
	 * @return
	 */
	public List<SysRight> getRights(SysRightQueryDTO sysRightQueryDTO);
	
}
