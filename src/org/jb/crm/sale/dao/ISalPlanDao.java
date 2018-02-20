package org.jb.crm.sale.dao;

import java.util.List;

import org.jb.common.dao.IBaseDAO;
import org.jb.crm.sale.domain.SalPlan;
import org.jb.crm.sale.dto.SalChanceQueryDTO;

public interface ISalPlanDao extends IBaseDAO<Long, SalPlan> {

	public List<SalPlan> loadSalPlanBySalChanceId(SalChanceQueryDTO salChanceQueryDto);

}
