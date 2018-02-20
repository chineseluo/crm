package org.jb.crm.basd.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.common.bean.Page;
import org.jb.common.dao.impl.BaseDAOImpl;
import org.jb.crm.basd.dao.IBasDictDao;
import org.jb.crm.basd.domain.BasDict;
import org.jb.crm.basd.dto.BasDictQueryDTO;
import org.springframework.orm.hibernate3.HibernateCallback;

public class BasDictDaoImpl extends BaseDAOImpl<Long, BasDict> implements IBasDictDao {

	@SuppressWarnings("unchecked")
	@Override
	public Page<BasDict> getByCondition(final BasDictQueryDTO basDictQueryDTO) {

		Long recTotal = this.getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT count(basDict.id) FROM BasDict basDict ");
				sb.append("WHERE (:dictType IS NULL OR basDict.dictType like :dictType)");
				sb.append(" AND (:dictItem IS NULL OR basDict.dictItem like :dictItem)");
				sb.append(" AND (:dictValue IS NULL OR basDict.dictValue like :dictValue)");
				sb.append(" AND (:dictIsEditable IS NULL OR basDict.dictIsEditable = :dictIsEditable)");
				Query query = session.createQuery(sb.toString());

				query.setParameter("dictType", basDictQueryDTO.getDictType() == null ? null : "%" + basDictQueryDTO.getDictType() + "%");
				query.setParameter("dictItem", basDictQueryDTO.getDictItem() == null ? null : "%" + basDictQueryDTO.getDictItem() + "%");
				query.setParameter("dictValue", basDictQueryDTO.getDictValue() == null ? null : "%" + basDictQueryDTO.getDictValue() + "%");
				query.setParameter("dictIsEditable", basDictQueryDTO.getDictIsEditable() == null ? null : basDictQueryDTO.getDictIsEditable());

				return (Long) query.uniqueResult();
			}
		});

		List<BasDict> resultList = this.getHibernateTemplate().executeFind(new HibernateCallback<List<BasDict>>() {

			@Override
			public List<BasDict> doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT basDict FROM BasDict basDict ");
				sb.append("WHERE (:dictType IS NULL OR basDict.dictType like :dictType)");
				sb.append(" AND (:dictItem IS NULL OR basDict.dictItem like :dictItem)");
				sb.append(" AND (:dictValue IS NULL OR basDict.dictValue like :dictValue)");
				sb.append(" AND (:dictIsEditable IS NULL OR basDict.dictIsEditable = :dictIsEditable)");
				Query query = session.createQuery(sb.toString());

				Integer firstResult = (basDictQueryDTO.getCurrentPage() - 1) * basDictQueryDTO.getPageSizes();
				query.setFirstResult(firstResult);
				query.setMaxResults(basDictQueryDTO.getPageSizes());

				query.setParameter("dictType", basDictQueryDTO.getDictType() == null ? null : "%" + basDictQueryDTO.getDictType() + "%");
				query.setParameter("dictItem", basDictQueryDTO.getDictItem() == null ? null : "%" + basDictQueryDTO.getDictItem() + "%");
				query.setParameter("dictValue", basDictQueryDTO.getDictValue() == null ? null : "%" + basDictQueryDTO.getDictValue() + "%");
				query.setParameter("dictIsEditable", basDictQueryDTO.getDictIsEditable() == null ? null : basDictQueryDTO.getDictIsEditable());

				return query.list();
			}
		});
		return new Page<BasDict>(basDictQueryDTO.getCurrentPage(), basDictQueryDTO.getPageSizes(), resultList, recTotal);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BasDict> getByDictType(final String dictType){
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<BasDict>>() {

			@Override
			public List<BasDict> doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT basDict FROM BasDict basDict ");
				sb.append("WHERE (:dictType IS NULL OR basDict.dictType = :dictType)");
				Query query = session.createQuery(sb.toString());
				query.setParameter("dictType", dictType == null || dictType.trim().equals("") ? null : dictType);
				return query.list();
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDictTypeByTip(final String dictType){
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<String>>() {

			@Override
			public List<String> doInHibernate(Session session) throws HibernateException, SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT DISTINCT basDict.dictType FROM BasDict basDict ");
				sb.append("WHERE (:dictType IS NULL OR basDict.dictType like :dictType)");
				Query query = session.createQuery(sb.toString());
				query.setParameter("dictType", dictType == null || dictType.trim().equals("") ? null : "%"+dictType+"%");
				return query.list();
			}
		});
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<String> loadCustLevelType() {
		return this.getHibernateTemplate().executeFind(new HibernateCallback<List<String>>() {

			@Override
			public List<String> doInHibernate(Session session) throws HibernateException, SQLException {
				
				String hql = "select distinct basDict.dictItem from BasDict basDict where basDict.dictType= '企业客户等级'";
				Query query = session.createQuery(hql);
				
				return query.list();
			}
		});
	}


}
