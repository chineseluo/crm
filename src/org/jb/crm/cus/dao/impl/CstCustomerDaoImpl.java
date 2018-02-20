package org.jb.crm.cus.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.common.bean.Page;
import org.jb.common.dao.impl.BaseDAOImpl;
import org.jb.crm.cus.dao.ICstCustomerDao;
import org.jb.crm.cus.domain.CstCustomer;
import org.jb.crm.cus.dto.CstCustomerQueryDTO;
import org.springframework.orm.hibernate3.HibernateCallback;

public class CstCustomerDaoImpl  extends BaseDAOImpl<Long, CstCustomer> implements ICstCustomerDao {

	@Override
	public Page<CstCustomer> getByCondition(final CstCustomerQueryDTO cstCustomerQueryDTO) {
		Long recTotal = this.getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT COUNT(cstCustomer.id) FROM CstCustomer cstCustomer ");
				sb.append("WHERE (:custNo IS NULL OR cstCustomer.custNo like :custNo)");
				sb.append(" AND (:custName IS NULL OR cstCustomer.custName like :custName)");
				sb.append(" AND (:custRegion IS NULL OR cstCustomer.custRegion = :custRegion)");
				sb.append(" AND (:custManagerName IS NULL OR cstCustomer.custManagerName like :custManagerName)");
				sb.append(" AND (:custLevelLabel IS NULL OR cstCustomer.custLevelLabel = :custLevelLabel)");
				sb.append(" AND (:custManagerId IS NULL OR cstCustomer.custManager.id = :custManagerId)");
				sb.append(" AND (:custStatus IS NULL OR cstCustomer.custStatus = :custStatus)");
				Query query = session.createQuery(sb.toString());
				
				query.setParameter("custNo", cstCustomerQueryDTO.getCustNo() == null||cstCustomerQueryDTO.getCustNo().trim().equals("") ? null : "%" + cstCustomerQueryDTO.getCustNo() + "%");
				query.setParameter("custName", cstCustomerQueryDTO.getCustName() == null||cstCustomerQueryDTO.getCustName().trim().equals("") ? null :"%"+ cstCustomerQueryDTO.getCustName()+ "%");
				query.setParameter("custRegion", cstCustomerQueryDTO.getCustRegion() == null? null :cstCustomerQueryDTO.getCustRegion());
				query.setParameter("custManagerName", cstCustomerQueryDTO.getCustManagerName() == null||cstCustomerQueryDTO.getCustManagerName().trim().equals("") ? null :"%"+ cstCustomerQueryDTO.getCustManagerName()+ "%");
				query.setParameter("custLevelLabel", cstCustomerQueryDTO.getCustLevelLabel() == null||cstCustomerQueryDTO.getCustLevelLabel().trim().equals("") ? null :cstCustomerQueryDTO.getCustLevelLabel());
				query.setParameter("custStatus", cstCustomerQueryDTO.getCustStatus() == null? null :cstCustomerQueryDTO.getCustStatus());
				query.setParameter("custManagerId", cstCustomerQueryDTO.getCustManagerId() == null ? null :cstCustomerQueryDTO.getCustManagerId());
				return (Long) query.uniqueResult();
				
			}
		});

		@SuppressWarnings("unchecked")
		List<CstCustomer> resultList = this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<CstCustomer>>() {

					@Override
					public List<CstCustomer> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuilder sb = new StringBuilder();
						sb.append("SELECT cstCustomer FROM CstCustomer cstCustomer ");
						sb.append(" WHERE (:custNo IS NULL OR cstCustomer.custNo like :custNo)");
						sb.append(" AND (:custName IS NULL OR cstCustomer.custName like :custName)");
						sb.append(" AND (:custRegion IS NULL OR cstCustomer.custRegion = :custRegion)");
						sb.append(" AND (:custManagerName IS NULL OR cstCustomer.custManagerName like :custManagerName)");
						sb.append(" AND (:custLevelLabel IS NULL OR cstCustomer.custLevelLabel = :custLevelLabel)");
						sb.append(" AND (:custManagerId IS NULL OR cstCustomer.custManager.id = :custManagerId)");
						sb.append(" AND (:custStatus IS NULL OR cstCustomer.custStatus = :custStatus)");
						sb.append(" ORDER BY cstCustomer.lastOperatorTime DESC");
						Query query = session.createQuery(sb.toString());
						
						Integer firstResult = (cstCustomerQueryDTO.getCurrentPage()-1)*cstCustomerQueryDTO.getPageSize();
						query.setFirstResult(firstResult);
						query.setMaxResults(cstCustomerQueryDTO.getPageSize());//10
						
						query.setParameter("custNo", cstCustomerQueryDTO.getCustNo() == null||cstCustomerQueryDTO.getCustNo().trim().equals("") ? null : "%" + cstCustomerQueryDTO.getCustNo() + "%");
						query.setParameter("custName", cstCustomerQueryDTO.getCustName() == null||cstCustomerQueryDTO.getCustName().trim().equals("") ? null :"%"+ cstCustomerQueryDTO.getCustName()+ "%");
						query.setParameter("custRegion", cstCustomerQueryDTO.getCustRegion() == null? null :cstCustomerQueryDTO.getCustRegion());
						query.setParameter("custManagerName", cstCustomerQueryDTO.getCustManagerName() == null||cstCustomerQueryDTO.getCustManagerName().trim().equals("") ? null :"%"+ cstCustomerQueryDTO.getCustManagerName()+ "%");
						query.setParameter("custLevelLabel", cstCustomerQueryDTO.getCustLevelLabel() == null||cstCustomerQueryDTO.getCustLevelLabel().trim().equals("") ? null :cstCustomerQueryDTO.getCustLevelLabel());
						query.setParameter("custManagerId", cstCustomerQueryDTO.getCustManagerId() == null ? null :cstCustomerQueryDTO.getCustManagerId());
						query.setParameter("custStatus", cstCustomerQueryDTO.getCustStatus() == null? null :cstCustomerQueryDTO.getCustStatus());
						
						return query.list();
					}
				});

		return new Page<CstCustomer>(cstCustomerQueryDTO.getCurrentPage(),cstCustomerQueryDTO.getPageSize(), resultList, recTotal);
	}
	
	@Override
	public List<CstCustomer> getAllByCondition(final CstCustomerQueryDTO cstCustomerQueryDTO) {
		@SuppressWarnings("unchecked")
		List<CstCustomer> resultList = this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<CstCustomer>>() {

					@Override
					public List<CstCustomer> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuilder sb = new StringBuilder();
						sb.append("SELECT cstCustomer FROM CstCustomer cstCustomer ");
						sb.append(" WHERE (:custNo IS NULL OR cstCustomer.custNo like :custNo)");
						sb.append(" AND (:custName IS NULL OR cstCustomer.custName like :custName)");
						sb.append(" AND (:custRegion IS NULL OR cstCustomer.custRegion = :custRegion)");
						sb.append(" AND (:custManagerName IS NULL OR cstCustomer.custManagerName like :custManagerName)");
						sb.append(" AND (:custLevelLabel IS NULL OR cstCustomer.custLevelLabel = :custLevelLabel)");
						sb.append(" AND (:custManagerId IS NULL OR cstCustomer.custManager.id = :custManagerId)");
						sb.append(" AND (:custStatus IS NULL OR cstCustomer.custStatus = :custStatus)");
						sb.append(" ORDER BY cstCustomer.lastOperatorTime DESC");
						Query query = session.createQuery(sb.toString());
						
						query.setParameter("custNo", cstCustomerQueryDTO.getCustNo() == null||cstCustomerQueryDTO.getCustNo().trim().equals("") ? null : "%" + cstCustomerQueryDTO.getCustNo() + "%");
						query.setParameter("custName", cstCustomerQueryDTO.getCustName() == null||cstCustomerQueryDTO.getCustName().trim().equals("") ? null :"%"+ cstCustomerQueryDTO.getCustName()+ "%");
						query.setParameter("custRegion", cstCustomerQueryDTO.getCustRegion() == null? null :cstCustomerQueryDTO.getCustRegion());
						query.setParameter("custManagerName", cstCustomerQueryDTO.getCustManagerName() == null||cstCustomerQueryDTO.getCustManagerName().trim().equals("") ? null :"%"+ cstCustomerQueryDTO.getCustManagerName()+ "%");
						query.setParameter("custLevelLabel", cstCustomerQueryDTO.getCustLevelLabel() == null||cstCustomerQueryDTO.getCustLevelLabel().trim().equals("") ? null :cstCustomerQueryDTO.getCustLevelLabel());
						query.setParameter("custManagerId", cstCustomerQueryDTO.getCustManagerId() == null ? null :cstCustomerQueryDTO.getCustManagerId());
						query.setParameter("custStatus", cstCustomerQueryDTO.getCustStatus() == null? null :cstCustomerQueryDTO.getCustStatus());
						
						return query.list();
					}
				});

		return resultList;
	}

	@Override
	public List<CstCustomer> getNotOrderCustomers(final Date beginDate, final Date endDate) {
		@SuppressWarnings("unchecked")
		List<CstCustomer> resultList = this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<CstCustomer>>() {

					@Override
					public List<CstCustomer> doInHibernate(Session session)
							throws HibernateException, SQLException {
						
						StringBuilder sb = new StringBuilder();
						sb.append("SELECT DISTINCT cstCustomer FROM CstCustomer cstCustomer,Orders orders");
						sb.append(" WHERE cstCustomer.custName = orders.odrCustomer AND cstCustomer.custStatus='1'");
						sb.append(" AND :beginDate IS NOT NULL AND ");
						sb.append(" (SELECT MAX(o.odrDate) FROM Orders o WHERE cstCustomer.custName = o.odrCustomer) < :beginDate");
						sb.append(" OR :endDate IS NOT NULL AND");
						sb.append(" (SELECT MIN(o.odrDate) FROM Orders o WHERE cstCustomer.custName = o.odrCustomer) > :endDate)");
						sb.append(" ORDER BY cstCustomer.lastOperatorTime DESC");
						
						Query query = session.createQuery(sb.toString());
						query.setParameter("beginDate", beginDate == null ? null :beginDate);
						query.setParameter("endDate", endDate == null ? null :endDate);
						
						return query.list();
					}
				});
		return resultList;
	}
	
	@Override
	public Date getLastestOrderDateById(final Long id) {
		Date lastestDate = this.getHibernateTemplate().execute(new HibernateCallback<Date>() {

			@Override
			public Date doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT MAX(orders.odrDate) FROM CstCustomer cstCustomer, Orders orders");
				sb.append(" WHERE (orders.odrCustomer = cstCustomer.custName)");
				sb.append(" AND (:id IS NULL OR cstCustomer.id = :id)");
				Query query = session.createQuery(sb.toString());
				query.setParameter("id", id == null	? null : id);
				try{
					return (Date) query.uniqueResult();
				}
				catch(HibernateException exception){
					return null;
				}
				
			}
		});
		return lastestDate;
	}
	
	
	
	
	
	
	

}
