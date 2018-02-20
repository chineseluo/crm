package org.jb.crm.sys.dao;

import org.jb.common.bean.Page;
import org.jb.common.dao.IBaseDAO;
import org.jb.crm.sys.domain.SysRole;
import org.jb.crm.sys.dto.SysRoleQueryDTO;

public interface ISysRoleDao extends IBaseDAO<Long, SysRole> {

	public Page<SysRole> getByCondition(SysRoleQueryDTO sysRoleQueryDTO);
}
