package org.jb.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.jb.common.dao.IBaseDAO;
import org.jb.common.domain.BaseDomain;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 通用dao接口的实现类
 * 
 * @author william
 * 
 * @param <PK>
 * @param <T>
 */
public class BaseDAOImpl<PK extends Serializable, T extends BaseDomain> extends
		HibernateDaoSupport implements IBaseDAO<PK, T> {

	private Class clazz;// 子类类型

	// BaseDAOImpl<Long,User>:参数化类型
	public BaseDAOImpl() {
		// 在父类构造方法里面的this，代表孩子
		// System.out.println(this);//BaseDAOImpl
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[1];
		// System.out.println("clazz=" + clazz);
	}

	@Override
	public void save(T instance) {
		this.getHibernateTemplate().save(instance);
	}

	@Override
	public void update(T instance) {
		this.getHibernateTemplate().update(instance);

	}

	@Override
	public void delete(T instance) {
		this.getHibernateTemplate().delete(instance);

	}

	@Override
	public void deleteAll(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			this.getHibernateTemplate().delete(list.get(i));
		}

	}

	@Override
	public T getById(PK pk) {
		return (T) this.getHibernateTemplate().get(clazz, pk);
	}
	
	@Override
	public void clear(){
		this.getHibernateTemplate().clear();
	}
	
}
