package org.jb.crm.sale.service;

import org.jb.common.bean.Page;
import org.jb.crm.sale.dto.SalChanceDTO;
import org.jb.crm.sale.dto.SalChanceQueryDTO;
public interface ISalChanceService {

	public void saveSalChance(SalChanceDTO salChanceDto);

	public Page<SalChanceDTO> findSalChanceByPage(SalChanceQueryDTO salChanceQueryDto);

	public void deleteSalChance(SalChanceQueryDTO salChanceQueryDto);

	public SalChanceDTO loadSalChanceById(SalChanceQueryDTO salChanceQueryDto);

	public void updateSalChance(SalChanceDTO salChanceDto);

	public void saveDispatchSalChance(SalChanceDTO salChanceDto);

	public void stopSalPlan(SalChanceQueryDTO salChanceQueryDto);

	public void developmentSuccess(SalChanceQueryDTO salChanceQueryDto);

}
