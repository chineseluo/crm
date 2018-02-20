package org.jb.common.service;

import org.dozer.Mapper;

/**
 * 父类业务对象
 * 实现Dozer依赖注入
 * @author william
 *
 */
public class BaseService {

	private Mapper mapper ;

	public Mapper getMapper() {
		return mapper;
	}

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
	
	
}
