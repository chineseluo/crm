package org.jb.common.service;

import org.dozer.Mapper;

/**
 * ����ҵ�����
 * ʵ��Dozer����ע��
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
