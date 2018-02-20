package org.jb.crm.cus.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.common.bean.Page;
import org.jb.common.dao.impl.BaseDAOImpl;
import org.jb.crm.cus.dao.ICstLinkmanDao;
import org.jb.crm.cus.domain.CstLinkman;
import org.jb.crm.cus.dto.CstLinkmanQueryDTO;
import org.springframework.orm.hibernate3.HibernateCallback;

public class CstLinkmanDaoImpl extends BaseDAOImpl<Long, CstLinkman> implements ICstLinkmanDao{

	@SuppressWarnings("unchecked")
	@Override
	public Page<CstLinkman> getByCondition(final CstLinkmanQueryDTO cstLinkmanQueryDTO) {
		Long recTotal = this.getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT COUNT(cstLinkman.id) FROM CstLinkman cstLinkman ");
				sb.append(" WHERE (:lkmName IS NULL OR cstLinkman.lkmName like :lkmName)");
				sb.append(" AND (:lkmCustomerId IS NULL OR cstLinkman.cstCustomer.id = :lkmCustomerId)");
				Query query = session.createQuery(sb.toString());
				
				query.setParameter("lkmName", cstLinkmanQueryDTO.getLkmName() == null||cstLinkmanQueryDTO.getLkmName().trim().equals("") ? null :"%"+ cstLinkmanQueryDTO.getLkmName()+ "%");
				query.setParameter("lkmCustomerId", cstLinkmanQueryDTO.getLkmCustomerId() == null ? null :cstLinkmanQueryDTO.getLkmCustomerId());
				
				return (Long) query.uniqueResult();
				
			}
		});

		List<CstLinkman> resultList = this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<CstLinkman>>() {

					@Override
					public List<CstLinkman> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuilder sb = new StringBuilder();
						sb.append("SELECT cstLinkman FROM CstLinkman cstLinkman ");
						sb.append(" WHERE (:lkmName IS NULL OR cstLinkman.lkmName like :lkmName)");
						sb.append(" AND (:lkmCustomerId IS NULL OR cstLinkman.cstCustomer.id = :lkmCustomerId)");
						sb.append(" ORDER BY cstLinkman.lastOperatorTime DESC");
						Query query = session.createQuery(sb.toString());
						
						Integer firstResult = (cstLinkmanQueryDTO.getCurrentPage()-1)*cstLinkmanQueryDTO.getPageSize();
						query.setFirstResult(firstResult);
						query.setMaxResults(cstLinkmanQueryDTO.getPageSize());//10
						
						query.setParameter("lkmName", cstLinkmanQueryDTO.getLkmName() == null||cstLinkmanQueryDTO.getLkmName().trim().equals("") ? null :"%"+ cstLinkmanQueryDTO.getLkmName()+ "%");
						query.setParameter("lkmCustomerId", cstLinkmanQueryDTO.getLkmCustomerId() == null ? null :cstLinkmanQueryDTO.getLkmCustomerId());
						
						return query.list();
					}
				});

		return new Page<CstLinkman>(cstLinkmanQueryDTO.getCurrentPage(),cstLinkmanQueryDTO.getPageSize(), resultList, recTotal);
	}
	
}
