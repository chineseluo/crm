package org.jb.crm.cus.dao;

import java.util.Date;

import org.jb.common.bean.Page;
import org.jb.common.dao.IBaseDAO;
import org.jb.crm.cus.domain.CstLost;
import org.jb.crm.cus.dto.CstLostQueryDTO;

public interface ICstLostDao extends IBaseDAO<Long, CstLost>{
	public Page<CstLost> getByCondition(CstLostQueryDTO cstLostQueryDTO);
}
