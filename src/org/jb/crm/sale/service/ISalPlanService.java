package org.jb.crm.sale.service;

import java.util.List;

import org.jb.crm.sale.dto.SalChanceQueryDTO;
import org.jb.crm.sale.dto.SalPlanDTO;
import org.jb.crm.sale.dto.SalPlanQueryDTO;

public interface ISalPlanService {

    public List<SalPlanDTO> loadSalPlanBySalChanceId(SalChanceQueryDTO salChanceQueryDto);

	public void savePlan(SalPlanDTO salPlanDto);

	public void updateSalPlan(SalPlanQueryDTO salPlanQueryDto);

	public void delateSalPlan(SalPlanQueryDTO salPlanQueryDto);

	public void saveExecutePlanResult(SalPlanQueryDTO salPlanQueryDto);

}
