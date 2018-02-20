package org.jb.crm.cus.dao.impl;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.common.bean.Page;
import org.jb.common.dao.impl.BaseDAOImpl;
import org.jb.crm.cus.dao.ICstLostDao;
import org.jb.crm.cus.domain.CstLost;
import org.jb.crm.cus.dto.CstLostQueryDTO;
import org.springframework.orm.hibernate3.HibernateCallback;

public class CstLostDaoImpl extends BaseDAOImpl<Long, CstLost> implements ICstLostDao {

	@SuppressWarnings("unchecked")
	@Override
	public Page<CstLost> getByCondition(final CstLostQueryDTO cstLostQueryDTO) {
		Long recTotal = this.getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT COUNT(cstLost.id) FROM CstLost cstLost");
				sb.append(" WHERE (:lstCustName IS NULL OR cstLost.lstCustName like :lstCustName)");
				sb.append(" AND (:lstCustManagerName IS NULL OR cstLost.lstCustManagerName like :lstCustManagerName)");
				sb.append(" AND (:lstStatus IS NULL OR cstLost.lstStatus = :lstStatus)");
				sb.append(" AND (:lstCustManagerId IS NULL OR cstLost.lstCustManager.id = :lstCustManagerId)");
				Query query = session.createQuery(sb.toString());
				
				query.setParameter("lstCustName", cstLostQueryDTO.getLstCustName() == null||cstLostQueryDTO.getLstCustName().trim().equals("") ? null :"%"+ cstLostQueryDTO.getLstCustName()+ "%");
				query.setParameter("lstCustManagerName", cstLostQueryDTO.getLstCustManagerName() == null||cstLostQueryDTO.getLstCustManagerName().trim().equals("") ? null :"%"+ cstLostQueryDTO.getLstCustManagerName()+ "%");
				query.setParameter("lstStatus", cstLostQueryDTO.getLstStatus() == null||cstLostQueryDTO.getLstStatus().trim().equals("") ? null : cstLostQueryDTO.getLstStatus());
				query.setParameter("lstCustManagerId", cstLostQueryDTO.getLstCustManagerId() == null? null :cstLostQueryDTO.getLstCustManagerId());
				
				return (Long) query.uniqueResult();
				
			}
		});

		List<CstLost> resultList = this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<CstLost>>() {

					@Override
					public List<CstLost> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuilder sb = new StringBuilder();
						sb.append("SELECT cstLost FROM CstLost cstLost ");
						sb.append(" WHERE (:lstCustName IS NULL OR cstLost.lstCustName like :lstCustName)");
						sb.append(" AND (:lstCustManagerName IS NULL OR cstLost.lstCustManagerName like :lstCustManagerName)");
						sb.append(" AND (:lstStatus IS NULL OR cstLost.lstStatus = :lstStatus)");
						sb.append(" AND (:lstCustManagerId IS NULL OR cstLost.lstCustManager.id = :lstCustManagerId)");
						sb.append(" ORDER BY cstLost.lastOperatorTime DESC");
						Query query = session.createQuery(sb.toString());
						
						Integer firstResult = (cstLostQueryDTO.getCurrentPage()-1)*cstLostQueryDTO.getPageSize();
						query.setFirstResult(firstResult);
						query.setMaxResults(cstLostQueryDTO.getPageSize());//10
						
						query.setParameter("lstCustName", cstLostQueryDTO.getLstCustName() == null||cstLostQueryDTO.getLstCustName().trim().equals("") ? null :"%"+ cstLostQueryDTO.getLstCustName()+ "%");
						query.setParameter("lstCustManagerName", cstLostQueryDTO.getLstCustManagerName() == null||cstLostQueryDTO.getLstCustManagerName().trim().equals("") ? null :"%"+ cstLostQueryDTO.getLstCustManagerName()+ "%");
						query.setParameter("lstStatus", cstLostQueryDTO.getLstStatus() == null||cstLostQueryDTO.getLstStatus().trim().equals("") ? null : cstLostQueryDTO.getLstStatus());
						query.setParameter("lstCustManagerId", cstLostQueryDTO.getLstCustManagerId() == null? null :cstLostQueryDTO.getLstCustManagerId());
						
						return query.list();
					}
				});

		return new Page<CstLost>(cstLostQueryDTO.getCurrentPage(),cstLostQueryDTO.getPageSize(), resultList, recTotal);
	}

	
//	@Override
//	public void deleteExtras(final Date beginDate, final Date endDate) {
//		@SuppressWarnings("unchecked")
//		List<CstLost> resultList = this.getHibernateTemplate().executeFind(
//				new HibernateCallback<List<CstLost>>() {
//
//					@Override
//					public List<CstLost> doInHibernate(Session session)
//							throws HibernateException, SQLException {
//						StringBuilder sb = new StringBuilder();
//						sb.append("SELECT DISTINCT cstLost FROM CstLost cstLost, Orders orders");
//						sb.append(" WHERE orders.odrCustomer = cstLost.lstCustName");
//						sb.append(" AND cstLost.lstStatus = '1'");
//						sb.append(" AND (:beginDate IS NULL OR orders.odrDate >= :beginDate)");
//						sb.append(" AND (:endDate IS NULL OR orders.odrDate <= :endDate) ");
//						sb.append(" ORDER BY cstLost.lastOperatorTime DESC");
//						Query query = session.createQuery(sb.toString());
//												
//						query.setParameter("beginDate", beginDate == null ? null :beginDate);
//						query.setParameter("endDate", endDate == null ? null :endDate);
//						
//						return query.list();
//					}
//				});
//		
//		if(resultList!=null){
//			for(CstLost cstLost:resultList)
//				this.delete(cstLost);
//		}
//	}

}
