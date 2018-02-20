package org.jb.crm.sys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.common.bean.Page;
import org.jb.common.dao.impl.BaseDAOImpl;
import org.jb.crm.sys.dao.ISysRoleDao;
import org.jb.crm.sys.domain.SysRole;
import org.jb.crm.sys.dto.SysRoleQueryDTO;
import org.springframework.orm.hibernate3.HibernateCallback;

public class SysRoleDaoImpl extends BaseDAOImpl<Long, SysRole> implements
		ISysRoleDao {

	@SuppressWarnings("unchecked")
	@Override
	public Page<SysRole> getByCondition(final SysRoleQueryDTO sysRoleQueryDTO) {
		// 总记录数(单一结果集)
		Long recTotal = this.getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT COUNT(sysRole.id) FROM SysRole sysRole ");
				sb.append("WHERE (:roleName IS NULL OR sysRole.roleName like :roleName)");
				sb.append(" AND (:roleFlag IS NULL OR sysRole.roleFlag = :roleFlag)");
				Query query = session.createQuery(sb.toString());
				
				//给命名参数设置
				query.setParameter("roleName", sysRoleQueryDTO.getRoleName() == null ? null : "%" + sysRoleQueryDTO.getRoleName() + "%");
				query.setParameter("roleFlag", sysRoleQueryDTO.getRoleFlag() == null ? null : sysRoleQueryDTO.getRoleFlag());
				
				return (Long) query.uniqueResult();
				
			}
		});

		// 实际记录结果(集合)
		List<SysRole> resultList = this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<SysRole>>() {

					@Override
					public List<SysRole> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuilder sb = new StringBuilder();
						sb.append("SELECT sysRole FROM SysRole sysRole ");
						sb.append("WHERE (:roleName IS NULL OR sysRole.roleName like :roleName)");
						sb.append(" AND (:roleFlag IS NULL OR sysRole.roleFlag = :roleFlag)");
						sb.append(" ORDER BY sysRole.lastOperatorTime DESC");
						Query query = session.createQuery(sb.toString());
						
						Integer firstResult = (sysRoleQueryDTO.getCurrentPage()-1)*sysRoleQueryDTO.getPageSize();
						query.setFirstResult(firstResult);
						query.setMaxResults(sysRoleQueryDTO.getPageSize());//10
						
						//给命名参数设置
						query.setParameter("roleName", sysRoleQueryDTO.getRoleName() == null ? null : "%" + sysRoleQueryDTO.getRoleName() + "%");
						query.setParameter("roleFlag", sysRoleQueryDTO.getRoleFlag() == null ? null : sysRoleQueryDTO.getRoleFlag());
						
						
						return query.list();
					}
				});

		return new Page<SysRole>(sysRoleQueryDTO.getCurrentPage(),
				sysRoleQueryDTO.getPageSize(), resultList, recTotal);
	}

}
