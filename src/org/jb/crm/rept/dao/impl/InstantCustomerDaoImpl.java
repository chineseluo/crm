package org.jb.crm.rept.dao.impl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.crm.rept.dao.IInstantCustomerDao;
import org.jb.crm.rept.dto.CustCons;
import org.jb.crm.rept.dto.InstantCustomer;
import org.jb.crm.rept.dto.InstantCustomerQueryDTO;
import org.jb.crm.rept.dto.InstantCustomerService;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class InstantCustomerDaoImpl extends HibernateDaoSupport  implements IInstantCustomerDao {
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InstantCustomer> loadAllInstantCustomer(
			final InstantCustomerQueryDTO instantCustomerQueryDTO) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<InstantCustomer>>() {

			@Override
			public List<InstantCustomer> doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer sb = new StringBuffer();
				sb.append("select new org.jb.crm.rept.dto.InstantCustomer(orders.odrCustomer,SUM(ordersLine.oddCount*ordersLine.oddPrice)) from OrdersLine ordersLine inner join ordersLine.orders orders ");
				sb.append(" where( :custName is null or orders.odrCustomer like :custName)");
				sb.append(" and (:begin is null or orders.odrDate >= :begin)");
				sb.append(" and (:end is null or orders.odrDate <= :end)");
				sb.append(" and (orders.odrStatus = '6')");
				sb.append(" group by orders.odrCustomer");
				Date beginDate = null;
				Date endDate = null;
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if(instantCustomerQueryDTO.getYear()!= null&&!instantCustomerQueryDTO.getYear().trim().equals("")){
					try {
						beginDate = df.parse(instantCustomerQueryDTO.getYear()+"-01-01 00:00:00");
						endDate = df.parse(instantCustomerQueryDTO.getYear()+"-12-31 23:59:59");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				Query query = session.createQuery(sb.toString());
				query.setParameter("custName", instantCustomerQueryDTO.getName()==null||instantCustomerQueryDTO.getName().trim().equals("")? null:"%"+instantCustomerQueryDTO.getName()+"%");
				query.setParameter("begin", beginDate);
				query.setParameter("end", endDate);
				return query.list();
			}
		});
		 
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<InstantCustomerService> loadAllInstantCustomerServiceByYear(final String year) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<InstantCustomerService>>() {

			@Override
			public List<InstantCustomerService> doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer sb = new StringBuffer();
				sb.append("SELECT new org.jb.crm.rept.dto.InstantCustomerService(svrType.dictItem,COUNT(DISTINCT cstService.id)) FROM CstService cstService JOIN cstService.svrType svrType");
				sb.append(" WHERE svrType.dictType = '服务类型' AND cstService.svrStatus ='已归档'");
				sb.append(" AND (:beginDate IS NULL OR cstService.svrCreateDate >=:beginDate)");
				sb.append(" AND (:endDate IS NULL OR cstService.svrCreateDate <=:endDate)");
				sb.append(" GROUP BY svrType.dictItem");
				
				
				Date beginDate = null;
				Date endDate = null;
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if(year!=null && !year.trim().equals("")){
					try {
						beginDate = df.parse(year+"-01-01 00:00:00");
						endDate = df.parse(year+"-12-31 23:59:59");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				Query query = session.createQuery(sb.toString());
				query.setParameter("beginDate",beginDate);
				query.setParameter("endDate",endDate);
				return query.list();
			}
		});
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CustCons> loadAllCustCons(final String optionType) {
		
		return  this.getHibernateTemplate().executeFind(new HibernateCallback<List<CustCons>>() {

			@Override
			public List<CustCons> doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer sb = new StringBuffer();
				if(optionType.equals("custLevel")){
					sb.append("select new org.jb.crm.rept.dto.CustCons(custLevel.dictItem,count(cstCustomer.id)) from CstCustomer cstCustomer right join cstCustomer.custLevel custLevel");
					sb.append(" where custLevel.dictType = '企业客户等级'");
					sb.append(" and(cstCustomer.custStatus = '1')");
					sb.append(" group by custLevel.dictItem");
				}
				if(optionType.equals("satisfy")){
					sb.append("select new org.jb.crm.rept.dto.CustCons(cstCustomer.custSatisfy,count(cstCustomer.id)) from CstCustomer cstCustomer");
					sb.append(" where (cstCustomer.custStatus = '1')");
					sb.append(" group by cstCustomer.custSatisfy order by cstCustomer.custSatisfy ASC");
					
				}
				if(optionType.equals("credit")){
					sb.append("select new org.jb.crm.rept.dto.CustCons(cstCustomer.custCredit,count(cstCustomer.id)) from CstCustomer cstCustomer");
					sb.append(" where (cstCustomer.custStatus = '1')");
					sb.append(" group by cstCustomer.custCredit order by cstCustomer.custCredit ASC");
				}
				Query query = session.createQuery(sb.toString());
				return query.list();
			}
		});
	}


}
