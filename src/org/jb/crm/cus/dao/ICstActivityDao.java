package org.jb.crm.cus.dao;

import java.util.List;

import org.jb.common.dao.IBaseDAO;
import org.jb.crm.cus.domain.CstActivity;

public interface ICstActivityDao extends IBaseDAO<Long, CstActivity> {
	public List<CstActivity> getByCustomer(Long id);
}
