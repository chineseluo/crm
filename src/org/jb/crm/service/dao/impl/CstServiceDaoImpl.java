package org.jb.crm.service.dao.impl;



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
import org.jb.crm.rept.dto.InstantCustomerService;
import org.jb.crm.service.dao.ICstServiceDao;
import org.jb.crm.service.domain.CstService;
import org.jb.crm.service.dto.CstServiceQueryDTO;
import org.springframework.orm.hibernate3.HibernateCallback;

public class CstServiceDaoImpl extends BaseDAOImpl<Long, CstService> implements ICstServiceDao {

	@SuppressWarnings("unchecked")
	@Override
	public Page<CstService> getByCondition(final CstServiceQueryDTO cstServiceQueryDTO) {
		Long recTotal = this.getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT COUNT(cstService.id) FROM CstService cstService ");
				sb.append(" WHERE (:svrCustName IS NULL OR cstService.svrCustName like :svrCustName)");
				sb.append(" AND (:svrTitle IS NULL OR cstService.svrTitle like :svrTitle)");
				sb.append(" AND (:svrTypeId IS NULL OR cstService.svrType.id = :svrTypeId)");
				sb.append(" AND (:svrCreateDateFrom IS NULL OR cstService.svrCreateDate >= :svrCreateDateFrom)");
				sb.append(" AND (:svrCreateDateTo IS NULL OR cstService.svrCreateDate <= :svrCreateDateTo)");
				sb.append(" AND (:svrStatus IS NULL OR cstService.svrStatus = :svrStatus)");
				sb.append(" AND (:svrDueId IS NULL OR cstService.svrDue.id = :svrDueId)");
				Query query = session.createQuery(sb.toString());
				
				query.setParameter("svrCustName", cstServiceQueryDTO.getSvrCustName() == null || cstServiceQueryDTO.getSvrCustName().trim().equals("") ? null :"%"+ cstServiceQueryDTO.getSvrCustName()+ "%");
				query.setParameter("svrTitle", cstServiceQueryDTO.getSvrTitle() == null || cstServiceQueryDTO.getSvrTitle().trim().equals("") ? null :"%"+cstServiceQueryDTO.getSvrTitle()+"%");
				query.setParameter("svrTypeId", cstServiceQueryDTO.getSvrTypeId() == null ? null :cstServiceQueryDTO.getSvrTypeId());
				query.setParameter("svrCreateDateFrom", cstServiceQueryDTO.getSvrCreateDateFrom() == null ? null :cstServiceQueryDTO.getSvrCreateDateFrom());
				query.setParameter("svrCreateDateTo", cstServiceQueryDTO.getSvrCreateDateTo() == null ? null :cstServiceQueryDTO.getSvrCreateDateTo());
				query.setParameter("svrStatus", cstServiceQueryDTO.getSvrStatus() == null ? null :cstServiceQueryDTO.getSvrStatus());
				query.setParameter("svrDueId", cstServiceQueryDTO.getSvrDueId() == null ? null :cstServiceQueryDTO.getSvrDueId());
				return (Long) query.uniqueResult();
				
			}
		});

		List<CstService> resultList = this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<CstService>>() {

					@Override
					public List<CstService> doInHibernate(Session session)
							throws HibernateException, SQLException {
						StringBuilder sb = new StringBuilder();
						sb.append("SELECT cstService FROM CstService cstService ");
						sb.append(" WHERE (:svrCustName IS NULL OR cstService.svrCustName like :svrCustName)");
						sb.append(" AND (:svrTitle IS NULL OR cstService.svrTitle like :svrTitle)");
						sb.append(" AND (:svrTypeId IS NULL OR cstService.svrType.id = :svrTypeId)");
						sb.append(" AND (:svrCreateDateFrom IS NULL OR cstService.svrCreateDate >= :svrCreateDateFrom)");
						sb.append(" AND (:svrCreateDateTo IS NULL OR cstService.svrCreateDate <= :svrCreateDateTo)");
						sb.append(" AND (:svrStatus IS NULL OR cstService.svrStatus = :svrStatus)");
						sb.append(" AND (:svrDueId IS NULL OR cstService.svrDue.id = :svrDueId)");
						sb.append(" ORDER BY cstService.lastOperatorTime DESC");
						Query query = session.createQuery(sb.toString());
						
						Integer firstResult = (cstServiceQueryDTO.getCurrentPage()-1)*cstServiceQueryDTO.getPageSize();
						query.setFirstResult(firstResult);
						query.setMaxResults(cstServiceQueryDTO.getPageSize());//10
						
						query.setParameter("svrCustName", cstServiceQueryDTO.getSvrCustName() == null || cstServiceQueryDTO.getSvrCustName().trim().equals("") ? null :"%"+ cstServiceQueryDTO.getSvrCustName()+ "%");
						query.setParameter("svrTitle", cstServiceQueryDTO.getSvrTitle() == null || cstServiceQueryDTO.getSvrTitle().trim().equals("") ? null :"%"+cstServiceQueryDTO.getSvrTitle()+"%");
						query.setParameter("svrTypeId", cstServiceQueryDTO.getSvrTypeId() == null ? null :cstServiceQueryDTO.getSvrTypeId());
						query.setParameter("svrCreateDateFrom", cstServiceQueryDTO.getSvrCreateDateFrom() == null ? null :cstServiceQueryDTO.getSvrCreateDateFrom());
						query.setParameter("svrCreateDateTo", cstServiceQueryDTO.getSvrCreateDateTo() == null ? null :cstServiceQueryDTO.getSvrCreateDateTo());
						query.setParameter("svrStatus", cstServiceQueryDTO.getSvrStatus() == null ? null :cstServiceQueryDTO.getSvrStatus());
						query.setParameter("svrDueId", cstServiceQueryDTO.getSvrDueId() == null ? null :cstServiceQueryDTO.getSvrDueId());
						return query.list();
					}
				});

		return new Page<CstService>(cstServiceQueryDTO.getCurrentPage(),cstServiceQueryDTO.getPageSize(), resultList, recTotal);
	}
	
	
}
