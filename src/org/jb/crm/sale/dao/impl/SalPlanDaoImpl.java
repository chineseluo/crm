package org.jb.crm.sale.dao.impl;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.common.dao.impl.BaseDAOImpl;
import org.jb.crm.sale.dao.ISalPlanDao;
import org.jb.crm.sale.domain.SalPlan;
import org.jb.crm.sale.dto.SalChanceQueryDTO;
import org.springframework.orm.hibernate3.HibernateCallback;

public class SalPlanDaoImpl extends BaseDAOImpl<Long, SalPlan> implements ISalPlanDao {

	@Override
	public List<SalPlan> loadSalPlanBySalChanceId(final SalChanceQueryDTO salChanceQueryDto) {
		@SuppressWarnings("unchecked")
		List<SalPlan> listPlan= this.getHibernateTemplate().executeFind(new HibernateCallback<List<SalPlan>>() {
			@Override
			public List<SalPlan> doInHibernate(Session session)throws HibernateException, SQLException {
				StringBuffer sb = new StringBuffer();
				sb.append("select salPlan from SalPlan salPlan");
				sb.append(" where salPlan.salChance.id = :salChanceId");//salChanceQueryDto.id	
				sb.append(" ORDER BY salChance.lastOperatorTime DESC");			
				Query query =session.createQuery(sb.toString());
				query.setParameter("salChanceId", salChanceQueryDto.getId());
				return query.list();
			}
		});
		return listPlan;
	}

	

}
