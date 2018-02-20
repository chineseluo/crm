package org.jb.crm.sale.dao;

import org.jb.common.bean.Page;
import org.jb.common.dao.IBaseDAO;
import org.jb.crm.sale.domain.SalChance;
import org.jb.crm.sale.dto.SalChanceQueryDTO;

public interface ISalChanceDao extends IBaseDAO<Long, SalChance> {

	public Page<SalChance> findSalChanceByPage(SalChanceQueryDTO salChanceQueryDto);

}
