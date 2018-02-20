package org.jb.crm.cus.dao;

import org.jb.common.bean.Page;
import org.jb.common.dao.IBaseDAO;
import org.jb.crm.cus.domain.CstLinkman;
import org.jb.crm.cus.dto.CstLinkmanQueryDTO;

public interface ICstLinkmanDao extends IBaseDAO<Long, CstLinkman>{
	public Page<CstLinkman> getByCondition(CstLinkmanQueryDTO cstLinkmanQueryDTO);
}
