package org.jb.crm.sys.dao;

import java.util.List;

import org.jb.common.bean.Page;
import org.jb.common.dao.IBaseDAO;
import org.jb.crm.sys.domain.SysUser;
import org.jb.crm.sys.dto.SysUserQueryDTO;

public interface ISysUserDao extends IBaseDAO<Long, SysUser> {

	public Page<SysUser> getByCondition(SysUserQueryDTO sysUserQueryDTO);

	public List<SysUser> findManager();

}
