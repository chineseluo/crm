package org.jb.crm.sale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jb.common.service.BaseService;
import org.jb.crm.sale.dao.ISalPlanDao;
import org.jb.crm.sale.domain.SalPlan;
import org.jb.crm.sale.dto.SalChanceQueryDTO;
import org.jb.crm.sale.dto.SalPlanDTO;
import org.jb.crm.sale.dto.SalPlanQueryDTO;
import org.jb.crm.sale.service.ISalPlanService;

public class SalPlanServiceImpl extends BaseService implements ISalPlanService {
	private ISalPlanDao salPlanDao;

	public void setSalPlanDao(ISalPlanDao salPlanDao) {
		this.salPlanDao = salPlanDao;
	}

	@Override
	public List<SalPlanDTO> loadSalPlanBySalChanceId(SalChanceQueryDTO salChanceQueryDto) {
		List<SalPlanDTO> dtoList = new ArrayList<SalPlanDTO>();
		List<SalPlan> planBean = this.salPlanDao.loadSalPlanBySalChanceId(salChanceQueryDto);
		
		for (int i = 0; i < planBean.size(); i++) {
			SalPlanDTO salPlanDTO =new SalPlanDTO();
			this.getMapper().map(planBean.get(i), salPlanDTO);
			dtoList.add(salPlanDTO);			
		}
		return dtoList;
	}

	@Override
	public void savePlan(SalPlanDTO salPlanDto) {
		SalPlan salPlan = new SalPlan();
		this.getMapper().map(salPlanDto, salPlan);
		this.salPlanDao.save(salPlan);
		
	}

	@Override
	public void updateSalPlan(SalPlanQueryDTO salPlanQueryDto) {
		SalPlan salPlan = this.salPlanDao.getById(salPlanQueryDto.getId());
		salPlan.setPlaToDo(salPlanQueryDto.getPlaToDo());
		this.salPlanDao.update(salPlan);		
	}

	@Override
	public void delateSalPlan(SalPlanQueryDTO salPlanQueryDto) {
		SalPlan salPlan = this.salPlanDao.getById(salPlanQueryDto.getId());
		this.salPlanDao.delete(salPlan);
	}

	@Override
	public void saveExecutePlanResult(SalPlanQueryDTO salPlanQueryDto) {
		SalPlan salPlan = this.salPlanDao.getById(salPlanQueryDto.getId());
		salPlan.setPlaResult(salPlanQueryDto.getPlaResult());
		this.salPlanDao.update(salPlan);
	}


	
	
	
	

}
