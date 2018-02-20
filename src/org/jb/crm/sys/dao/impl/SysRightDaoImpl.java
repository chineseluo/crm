package org.jb.crm.sys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.common.dao.impl.BaseDAOImpl;
import org.jb.crm.sys.dao.ISysRightDao;
import org.jb.crm.sys.domain.SysRight;
import org.jb.crm.sys.dto.SysRightQueryDTO;
import org.springframework.orm.hibernate3.HibernateCallback;

public class SysRightDaoImpl extends BaseDAOImpl<Long, SysRight> implements
		ISysRightDao {

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SysRight> getRights(final SysRightQueryDTO sysRightQueryDTO) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<SysRight>>() {
			@Override
			public List<SysRight> doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT sysRight FROM SysRight sysRight");
				if(null != sysRightQueryDTO.getParentId()){
					sb.append(" WHERE sysRight.parent.id = :parentId");
				}else{
					sb.append(" WHERE sysRight.parent IS NULL");
				}
				sb.append(" ORDER BY sysRight.lastOperatorTime DESC");
				Query query = session.createQuery(sb.toString());
				if(null != sysRightQueryDTO.getParentId()){
					query.setParameter("parentId", sysRightQueryDTO.getParentId());
				}
			
				return query.list();
			}
		});
	}

}
