package org.jb.crm.cus.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.common.dao.impl.BaseDAOImpl;
import org.jb.crm.cus.dao.ICstActivityDao;
import org.jb.crm.cus.domain.CstActivity;
import org.springframework.orm.hibernate3.HibernateCallback;

public class CstActivityDaoImpl extends BaseDAOImpl<Long, CstActivity> implements ICstActivityDao {

	@Override
	public List<CstActivity> getByCustomer(final Long id) {
		@SuppressWarnings("unchecked")
		List<CstActivity> resultList = this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<CstActivity>>() {

					@Override
					public List<CstActivity> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuilder sb = new StringBuilder();
						sb.append("SELECT cstActivity FROM CstActivity cstActivity ");
						sb.append(" WHERE (:cstCustomerId IS NULL OR cstActivity.cstCustomer.id = :cstCustomerId)");
						sb.append(" ORDER BY cstActivity.lastOperatorTime DESC");
						Query query = session.createQuery(sb.toString());
						
						
						query.setParameter("cstCustomerId",id);
						
						return query.list();
					}
				});

		return resultList;
	}


}
