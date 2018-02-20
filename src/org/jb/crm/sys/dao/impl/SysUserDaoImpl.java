package org.jb.crm.sys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.common.bean.Page;
import org.jb.common.dao.impl.BaseDAOImpl;
import org.jb.crm.sys.dao.ISysUserDao;
import org.jb.crm.sys.domain.SysUser;
import org.jb.crm.sys.dto.SysUserQueryDTO;
import org.springframework.orm.hibernate3.HibernateCallback;

public class SysUserDaoImpl extends BaseDAOImpl<Long, SysUser> implements
		ISysUserDao {

	@Override
	public Page<SysUser> getByCondition(final SysUserQueryDTO sysUserQueryDTO) {

		Long recTotal = this.getHibernateTemplate().execute(
				new HibernateCallback<Long>() {
					@Override
					public Long doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuilder sb = new StringBuilder();
						sb.append("SELECT count(sysUser.id) FROM SysUser sysUser ");
						sb.append("WHERE (:usrName IS NULL OR sysUser.usrName like :usrName)");
						sb.append(" AND (:usrPassword IS NULL OR sysUser.usrPassword = :usrPassword)");
						sb.append(" AND (:usrFlag IS NULL OR sysUser.usrFlag = :usrFlag)");

						Query query = session.createQuery(sb.toString());

						if ("login".equals(sysUserQueryDTO.getOpeartorType())) {
							// ��¼
							query.setParameter("usrName", sysUserQueryDTO
									.getUsrName() == null ? null
									: sysUserQueryDTO.getUsrName());
						} else {
							// ��ѯ
							query.setParameter("usrName", sysUserQueryDTO
									.getUsrName() == null ? null : "%"
									+ sysUserQueryDTO.getUsrName() + "%");
						}
						query.setParameter("usrPassword", sysUserQueryDTO
								.getUsrPassword() == null ? null
								: sysUserQueryDTO.getUsrPassword());
						query.setParameter("usrFlag",
								sysUserQueryDTO.getUsrFlag() == null ? null
										: sysUserQueryDTO.getUsrFlag());

						return (Long) query.uniqueResult();

					}

				});

		@SuppressWarnings("unchecked")
		List<SysUser> resultList = this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<SysUser>>() {
					@Override
					public List<SysUser> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuilder sb = new StringBuilder();
						sb.append("SELECT sysUser FROM SysUser sysUser ");
						sb.append("WHERE (:usrName IS NULL OR sysUser.usrName like :usrName)");
						sb.append(" AND (:usrPassword IS NULL OR sysUser.usrPassword = :usrPassword)");
						sb.append(" AND (:usrFlag IS NULL OR sysUser.usrFlag = :usrFlag)");
						sb.append(" ORDER BY sysUser.lastOperatorTime DESC");
						Query query = session.createQuery(sb.toString());
						if ("login".equals(sysUserQueryDTO.getOpeartorType())) {
							// ��¼
							query.setParameter("usrName", sysUserQueryDTO
									.getUsrName() == null ? null
									: sysUserQueryDTO.getUsrName());
						} else {
							// ��ѯ
							query.setParameter("usrName", sysUserQueryDTO
									.getUsrName() == null ? null : "%"
									+ sysUserQueryDTO.getUsrName() + "%");
						}
						query.setParameter("usrPassword", sysUserQueryDTO
								.getUsrPassword() == null ? null
								: sysUserQueryDTO.getUsrPassword());
						query.setParameter("usrFlag",
								sysUserQueryDTO.getUsrFlag() == null ? null
										: sysUserQueryDTO.getUsrFlag());

						// ��ҳ
						Integer firstResult = (sysUserQueryDTO.getCurrentPage() - 1)
								* sysUserQueryDTO.getPageSize();
						query.setFirstResult(firstResult);
						query.setMaxResults(sysUserQueryDTO.getPageSize());

						return query.list();
					}
				});

		return new Page<SysUser>(sysUserQueryDTO.getCurrentPage(),
				sysUserQueryDTO.getPageSize(), resultList, recTotal);
	}

	@Override
	public List<SysUser> findManager() {
		@SuppressWarnings("unchecked")
		List<SysUser> resultList = this.getHibernateTemplate().executeFind(new HibernateCallback<List<SysUser>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<SysUser> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "select sysUser from SysUser sysUser where sysUser.sysRole.roleName = '客户经理' AND sysUser.usrFlag ='1'";
				Query query =session.createQuery(sql);
				
				return query.list();
			}
		});
		return resultList;
	}

}
