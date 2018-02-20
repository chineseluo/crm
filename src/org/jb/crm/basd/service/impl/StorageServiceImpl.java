package org.jb.crm.basd.service.impl;

import org.jb.common.service.BaseService;
import org.jb.crm.basd.dao.IStorageDao;
import org.jb.crm.basd.service.IStorageService;


public class StorageServiceImpl extends BaseService implements IStorageService {
	private IStorageDao storageDao;

	public void setStorageDao(IStorageDao storageDao) {
		this.storageDao = storageDao;
	}

}
