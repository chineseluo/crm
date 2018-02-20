package org.jb.crm.basd.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jb.common.bean.Page;
import org.jb.common.dao.impl.BaseDAOImpl;
import org.jb.crm.basd.dao.IProductDao;
import org.jb.crm.basd.domain.Product;
import org.jb.crm.basd.dto.ProductQueryDTO;
import org.springframework.orm.hibernate3.HibernateCallback;


public class ProductDaoImpl extends BaseDAOImpl<Long, Product> implements IProductDao{

	@SuppressWarnings("unchecked")
	@Override
	public Page<Product> loadAllProductByPage(final ProductQueryDTO productQueryDTO) {
		Long recTotal = this.getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer sb = new StringBuffer();
				sb.append("select count(product.id) from Product product");
				sb.append(" where (:prodName is null or product.prodName like :prodName)");
				sb.append(" and (:prodType is null or product.prodType like :prodType)");
				sb.append(" and (:prodBatch is null or product.prodBatch like :prodBatch)");
				Query query =session.createQuery(sb.toString());
				query.setParameter("prodName", productQueryDTO.getProdName()==null||productQueryDTO.getProdName().trim().equals("")? null: "%"+productQueryDTO.getProdName()+"%");
				query.setParameter("prodType", productQueryDTO.getProdType()==null||productQueryDTO.getProdType().trim().equals("")? null: "%"+productQueryDTO.getProdType()+"%");
				query.setParameter("prodBatch", productQueryDTO.getProdBatch()==null||productQueryDTO.getProdBatch().trim().equals("")? null: "%"+productQueryDTO.getProdBatch()+"%");
				return (Long) query.uniqueResult();
			}
		});
		
		List<Product> resultList = this.getHibernateTemplate().executeFind(new HibernateCallback<List<Product>>() {

			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer sb = new StringBuffer();
				sb.append("select product from Product product");
				sb.append(" where (:prodName is null or product.prodName like :prodName)");
				sb.append(" and (:prodType is null or product.prodType like :prodType)");
				sb.append(" and (:prodBatch is null or product.prodBatch like :prodBatch)");
				Query query =session.createQuery(sb.toString());
				query.setParameter("prodName", productQueryDTO.getProdName()==null||productQueryDTO.getProdName().trim().equals("")? null: "%"+productQueryDTO.getProdName()+"%");
				query.setParameter("prodType", productQueryDTO.getProdType()==null||productQueryDTO.getProdType().trim().equals("")? null: "%"+productQueryDTO.getProdType()+"%");
				query.setParameter("prodBatch", productQueryDTO.getProdBatch()==null||productQueryDTO.getProdBatch().trim().equals("")? null: "%"+productQueryDTO.getProdBatch()+"%");
				Integer firstResult = (productQueryDTO.getPageNum()-1)*productQueryDTO.getPageSize();
				query.setFirstResult(firstResult);
				query.setMaxResults(productQueryDTO.getPageSize());
				return query.list();
			}
		});
		
		
		
		return new Page<Product>(productQueryDTO.getPageNum(),productQueryDTO.getPageSize(),resultList,recTotal);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<Product> findProductAndStorageByPage(final ProductQueryDTO productQueryDTO) {
		Long recTotal = this.getHibernateTemplate().execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer sb = new StringBuffer();
				sb.append("select count(product.id) from Product product inner join product.storage");
				sb.append(" where (:prodName is null or product.prodName like :prodName)");
				sb.append(" and (:stkWarehouse is null or product.storage.stkWarehouse like :stkWarehouse)");

				Query query =session.createQuery(sb.toString());
				query.setParameter("prodName", productQueryDTO.getProdName()==null||productQueryDTO.getProdName().trim().equals("")? null: "%"+productQueryDTO.getProdName()+"%");
				query.setParameter("stkWarehouse", productQueryDTO.getStkWarehouse()==null||productQueryDTO.getStkWarehouse().trim().equals("")? null: "%"+productQueryDTO.getStkWarehouse()+"%");
				return (Long) query.uniqueResult();
			}
		});
		
		
		List<Product> resultList = this.getHibernateTemplate().executeFind(new HibernateCallback<List<Product>>() {

			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer sb = new StringBuffer();
				sb.append("select product from Product product inner join fetch product.storage");
				sb.append(" where (:prodName is null or product.prodName like :prodName)");
				sb.append(" and (:stkWarehouse is null or product.storage.stkWarehouse like :stkWarehouse)");

				Query query =session.createQuery(sb.toString());
				query.setParameter("prodName", productQueryDTO.getProdName()==null||productQueryDTO.getProdName().trim().equals("")? null: "%"+productQueryDTO.getProdName()+"%");
				query.setParameter("stkWarehouse", productQueryDTO.getStkWarehouse()==null||productQueryDTO.getStkWarehouse().trim().equals("")? null: "%"+productQueryDTO.getStkWarehouse()+"%");Integer firstResult = (productQueryDTO.getPageNum()-1)*productQueryDTO.getPageSize();
				query.setFirstResult(firstResult);
				query.setMaxResults(productQueryDTO.getPageSize());
				return query.list();
			}
		});
		
		
		
		return new Page<Product>(productQueryDTO.getPageNum(),productQueryDTO.getPageSize(),resultList,recTotal);
	}

}
