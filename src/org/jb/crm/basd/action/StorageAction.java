package org.jb.crm.basd.action;

import org.jb.common.action.BaseAction;
import org.jb.crm.basd.service.IStorageService;

public class StorageAction extends BaseAction {
	private IStorageService storageService;

	public void setStorageService(IStorageService storageService) {
		this.storageService = storageService;
	}

}
