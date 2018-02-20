package org.jb.crm.sale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jb.common.bean.Page;
import org.jb.common.service.BaseService;
import org.jb.crm.sale.dao.ISalChanceDao;
import org.jb.crm.sale.domain.SalChance;
import org.jb.crm.sale.dto.SalChanceDTO;
import org.jb.crm.sale.dto.SalChanceQueryDTO;
import org.jb.crm.sale.service.ISalChanceService;
import org.jb.crm.sys.domain.SysUser;

public class SalChanceServiceImpl extends BaseService implements ISalChanceService {
	private ISalChanceDao salChanceDao;

	public void setSalChanceDao(ISalChanceDao salChanceDao) {
		this.salChanceDao = salChanceDao;
	}

	@Override
	public void saveSalChance(SalChanceDTO salChanceDto) {
		SalChance salChance = new SalChance();
		this.getMapper().map(salChanceDto, salChance);
		salChanceDao.save(salChance);		
	}

	@Override
	public Page<SalChanceDTO> findSalChanceByPage(SalChanceQueryDTO salChanceQueryDto) {
		
		Page<SalChance> pageBean = salChanceDao.findSalChanceByPage(salChanceQueryDto);
		List<SalChanceDTO> resultListDTO =new ArrayList<SalChanceDTO>();
		List<SalChance> resultList = pageBean.getList();
		for (int i = 0; i < resultList.size(); i++) {
			SalChanceDTO salChanceDTO =new SalChanceDTO();
			this.getMapper().map(resultList.get(i), salChanceDTO);
			resultListDTO.add(salChanceDTO);	
		}
		return new Page<SalChanceDTO>(pageBean.getCurrentPage(),pageBean.getPageSize(),resultListDTO,pageBean.getRecTotal());
	}

	@Override
	public void deleteSalChance(SalChanceQueryDTO salChanceQueryDto) {	
		SalChance salChance = salChanceDao.getById(salChanceQueryDto.getId());
		salChanceDao.delete(salChance);
		
	}

	@Override
	public SalChanceDTO loadSalChanceById(SalChanceQueryDTO salChanceQueryDto) {
		SalChance salChance = this.salChanceDao.getById(salChanceQueryDto.getId());
		SalChanceDTO salChanceDTO = new SalChanceDTO();
		this.getMapper().map(salChance, salChanceDTO);
		return salChanceDTO;
	}

	@Override
	public void updateSalChance(SalChanceDTO salChanceDto) {
		 SalChance salChance = this.salChanceDao.getById(salChanceDto.getId());
		 this.getMapper().map(salChanceDto, salChance);
		 this.salChanceDao.update(salChance);
	}

	@Override
	public void saveDispatchSalChance(SalChanceDTO salChanceDto) {
		SalChance salChance = this.salChanceDao.getById(salChanceDto.getId());
		SysUser sysUser = new SysUser();
		this.getMapper().map(salChanceDto.getDueUserDTO(), sysUser);
		salChance.setDueUser(sysUser);
		salChance.setChcDueDate(salChanceDto.getChcDueDate());
		salChance.setChcStatus("2");
		salChance.setChcDueTo(salChanceDto.getChcDueTo());
		this.salChanceDao.update(salChance);
	}

	@Override
	public void stopSalPlan(SalChanceQueryDTO salChanceQueryDto) {
		SalChance salChance = this.salChanceDao.getById(salChanceQueryDto.getId());
		salChance.setChcStatus("3");
		this.salChanceDao.update(salChance);
	}

	@Override
	public void developmentSuccess(SalChanceQueryDTO salChanceQueryDto) {
		SalChance salChance = this.salChanceDao.getById(salChanceQueryDto.getId());
		salChance.setChcStatus("4");
		this.salChanceDao.update(salChance);
		
	}





}
