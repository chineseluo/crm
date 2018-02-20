package org.jb.crm.basd.dao.impl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.common.bean.Page;
import org.jb.common.dao.impl.BaseDAOImpl;
import org.jb.crm.basd.dao.IOrdersDao;
import org.jb.crm.basd.domain.Orders;
import org.jb.crm.basd.dto.OrdersQueryDTO;
import org.jb.crm.rept.dto.InstantCustomer;
import org.jb.crm.rept.dto.InstantCustomerQueryDTO;
import org.springframework.orm.hibernate3.HibernateCallback;

public class OrdersDaoImpl extends BaseDAOImpl<Long, Orders> implements IOrdersDao{

	@SuppressWarnings("unchecked")
	@Override
	public Page<Orders> getByCondition(final OrdersQueryDTO ordersQueryDTO) {
		Long recTotal = this.getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT COUNT(orders.id) FROM Orders orders ");
				sb.append(" WHERE (:odrCustomer IS NULL OR orders.odrCustomer = :odrCustomer)");
				Query query = session.createQuery(sb.toString());
				
				query.setParameter("odrCustomer", ordersQueryDTO.getOdrCustomer() == null||ordersQueryDTO.getOdrCustomer().trim().equals("") ? null :ordersQueryDTO.getOdrCustomer());
				
				return (Long) query.uniqueResult();
				
			}
		});

		List<Orders> resultList = this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<Orders>>() {

					@Override
					public List<Orders> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuilder sb = new StringBuilder();
						sb.append("SELECT orders FROM Orders orders ");
						sb.append(" WHERE (:odrCustomer IS NULL OR orders.odrCustomer = :odrCustomer)");
						sb.append(" ORDER BY orders.lastOperatorTime DESC");
						Query query = session.createQuery(sb.toString());
						
						Integer firstResult = (ordersQueryDTO.getCurrentPage()-1)*ordersQueryDTO.getPageSize();
						query.setFirstResult(firstResult);
						query.setMaxResults(ordersQueryDTO.getPageSize());//10
						
						query.setParameter("odrCustomer", ordersQueryDTO.getOdrCustomer() == null ? null :ordersQueryDTO.getOdrCustomer());
						
						return query.list();
					}
				});

		return new Page<Orders>(ordersQueryDTO.getCurrentPage(),ordersQueryDTO.getPageSize(), resultList, recTotal);
	}

	
	
}
