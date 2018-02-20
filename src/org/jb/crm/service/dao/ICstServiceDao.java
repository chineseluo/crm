package org.jb.crm.service.dao;



import org.jb.common.bean.Page;
import org.jb.common.dao.IBaseDAO;
import org.jb.crm.service.domain.CstService;
import org.jb.crm.service.dto.CstServiceQueryDTO;

public interface ICstServiceDao extends IBaseDAO<Long, CstService>{
	public Page<CstService> getByCondition(CstServiceQueryDTO cstServiceQueryDTO);

}
