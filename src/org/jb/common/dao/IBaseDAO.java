package org.jb.common.dao;

import java.io.Serializable;
import java.util.List;

import org.jb.common.domain.BaseDomain;

/**
 * 父类通用泛型DAO接口 完成增，删，改，根据ID查询的功能 给泛型约束类型（不能太泛）
 * 
 * PK:主键类型:要求泛型中，不能写基本数据类型(int char),就写包装类(也是Hibernate编程的要求)
 * long->Long
 * int->Integer
 * char->Character
 * ....
 * T:实体类型
 * 提高代码安全性
 * @author william
 * 
 */
public interface IBaseDAO<PK extends Serializable,T extends BaseDomain> {

	/**
	 * 保存对象
	 * @param instance
	 */
	public void save(T instance);

	/**
	 * 更新对象
	 * @param instance
	 */
	public void update(T instance);

	/**
	 * 删除对象
	 * @param instance
	 */
	public void delete(T instance);

	/**
	 * 批量对象
	 * @param list
	 */
	public void deleteAll(List<T> list);

	/**
	 * 根据对象的主键，加载对象
	 * @param pk
	 * @return
	 */
	public T getById(PK pk);

	public void clear();

}
