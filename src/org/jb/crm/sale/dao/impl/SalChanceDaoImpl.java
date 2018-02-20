package org.jb.crm.sale.dao.impl;



import java.sql.SQLException;





import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.common.bean.Page;
import org.jb.common.dao.impl.BaseDAOImpl;
import org.jb.crm.sale.dao.ISalChanceDao;
import org.jb.crm.sale.domain.SalChance;
import org.jb.crm.sale.dto.SalChanceQueryDTO;
import org.springframework.orm.hibernate3.HibernateCallback;

public class SalChanceDaoImpl extends BaseDAOImpl<Long, SalChance> implements
		ISalChanceDao {

	@Override
	public Page<SalChance> findSalChanceByPage(final SalChanceQueryDTO salChanceQueryDto) {
		Long recTotal = this.getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer sb = new StringBuffer();
				sb.append("SELECT count(salChance.id) FROM SalChance salChance ");
				sb.append(" WHERE (:chcCustName IS NULL OR salChance.chcCustName like :chcCustName)");
				sb.append(" AND (:chcLinkMan IS NULL OR salChance.chcLinkMan like :chcLinkMan)");
				sb.append(" AND (:chcTitle IS NULL OR salChance.chcTitle like :chcTitle)");
				if(salChanceQueryDto.getOptionType().equals("dispatched")){
					
					sb.append(" AND (salChance.chcStatus = '2' OR salChance.chcStatus = '3')");
				}else{
					sb.append(" AND (salChance.chcStatus = '1')");
				}
			    Query query = session.createQuery(sb.toString());
				query.setParameter("chcCustName", salChanceQueryDto.getChcCustName()== null||salChanceQueryDto.getChcCustName().trim().equals("") ? null
						: "%"+salChanceQueryDto.getChcCustName()+"%");
				query.setParameter("chcLinkMan", salChanceQueryDto.getChcLinkMan()== null||salChanceQueryDto.getChcLinkMan().trim().equals("") ? null
						: "%"+salChanceQueryDto.getChcLinkMan()+"%");
				query.setParameter("chcTitle", salChanceQueryDto.getChcTitle()== null||salChanceQueryDto.getChcTitle().trim().equals("") ? null
						: "%"+salChanceQueryDto.getChcTitle()+"%");				    
				return (Long) query.uniqueResult();
			}
		});
		@SuppressWarnings("unchecked")
		List<SalChance> resultList = this.getHibernateTemplate().executeFind(new HibernateCallback<List<SalChance>>() {

			@Override
			   public List<SalChance> doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer sb = new StringBuffer();
				sb.append("select salChance from SalChance salChance");
				sb.append(" WHERE (:chcCustName IS NULL OR salChance.chcCustName like :chcCustName)");
				sb.append(" AND (:chcLinkMan IS NULL OR salChance.chcLinkMan like :chcLinkMan)");
				sb.append(" AND (:chcTitle IS NULL OR salChance.chcTitle like :chcTitle)");
				if(salChanceQueryDto.getOptionType().equals("dispatched")){					
					sb.append(" AND (salChance.chcStatus = '2' OR salChance.chcStatus = '3')");
				}else{
					sb.append(" AND (salChance.chcStatus = '1')");
				}
				sb.append(" ORDER BY salChance.lastOperatorTime DESC");
			    Query query = session.createQuery(sb.toString());
				query.setParameter("chcCustName", salChanceQueryDto.getChcCustName()== null||salChanceQueryDto.getChcCustName().trim().equals("") ? null
						: "%"+salChanceQueryDto.getChcCustName()+"%");
				query.setParameter("chcLinkMan", salChanceQueryDto.getChcLinkMan()== null||salChanceQueryDto.getChcLinkMan().trim().equals("") ? null
						: "%"+salChanceQueryDto.getChcLinkMan()+"%");
				query.setParameter("chcTitle", salChanceQueryDto.getChcTitle()== null||salChanceQueryDto.getChcTitle().trim().equals("") ? null
						: "%"+salChanceQueryDto.getChcTitle()+"%");	
				Integer firstResult = (salChanceQueryDto.getPageNum()-1)*salChanceQueryDto.getPageSize();
				query.setFirstResult(firstResult);
				query.setMaxResults(salChanceQueryDto.getPageSize());
				return query.list();
			}
		});
		return new Page<SalChance>(salChanceQueryDto.getPageNum(),salChanceQueryDto.getPageSize(),resultList,recTotal);
	}

}
