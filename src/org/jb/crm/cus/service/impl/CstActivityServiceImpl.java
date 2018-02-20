package org.jb.crm.cus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jb.common.service.BaseService;
import org.jb.crm.cus.dao.ICstActivityDao;
import org.jb.crm.cus.domain.CstActivity;
import org.jb.crm.cus.dto.CstActivityDTO;
import org.jb.crm.cus.service.ICstActivityService;

public class CstActivityServiceImpl extends BaseService implements ICstActivityService {

	private ICstActivityDao cstActivityDao;
	

	public void setCstActivityDao(ICstActivityDao cstActivityDao) {
		this.cstActivityDao = cstActivityDao;
	}

	@Override
	public void saveCstActivity(CstActivityDTO cstActivityDTO) {
		CstActivity cstActivity =new CstActivity();
		this.getMapper().map(cstActivityDTO, cstActivity);
		cstActivityDao.save(cstActivity);
		
	}

	@Override
	public void updateCstActivity(CstActivityDTO cstActivityDTO) {
		CstActivity cstActivity =new CstActivity();
		this.getMapper().map(cstActivityDTO, cstActivity);
		cstActivityDao.update(cstActivity);
		
	}

	@Override
	public CstActivityDTO getById(Long id) {
		CstActivityDTO cstActivityDTO =new CstActivityDTO();
		this.getMapper().map(cstActivityDao.getById(id),cstActivityDTO);
		return cstActivityDTO;
	}

	@Override
	public void deleteCstActivity(CstActivityDTO cstActivityDTO) {
		CstActivity cstActivity =cstActivityDao.getById(cstActivityDTO.getId());
		cstActivityDao.delete(cstActivity);
	}

	@Override
	public List<CstActivityDTO> getByCustomerId(Long id) {
		List<CstActivity> resultList=cstActivityDao.getByCustomer(id);
		List<CstActivityDTO> dtoList=new ArrayList<CstActivityDTO>();
		for(CstActivity cstActivity:resultList){
			CstActivityDTO cstActivityDTO=new CstActivityDTO();
			this.getMapper().map(cstActivity,cstActivityDTO);
			dtoList.add(cstActivityDTO);
		}
 		return dtoList;
	}
}
