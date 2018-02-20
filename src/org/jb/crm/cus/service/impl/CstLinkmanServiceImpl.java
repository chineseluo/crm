package org.jb.crm.cus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jb.common.bean.Page;
import org.jb.common.service.BaseService;
import org.jb.crm.cus.dao.ICstLinkmanDao;
import org.jb.crm.cus.domain.CstLinkman;
import org.jb.crm.cus.dto.CstLinkmanDTO;
import org.jb.crm.cus.dto.CstLinkmanQueryDTO;
import org.jb.crm.cus.service.ICstLinkmanService;

public class CstLinkmanServiceImpl extends BaseService implements ICstLinkmanService{

	private ICstLinkmanDao cstLinkmanDao;
	
	public void setCstLinkmanDao(ICstLinkmanDao cstLinkmanDao) {
		this.cstLinkmanDao = cstLinkmanDao;
	}

	@Override
	public CstLinkmanDTO getById(Long id){
		CstLinkman cstLinkman=cstLinkmanDao.getById(id);
		CstLinkmanDTO cstLinkmanDTO= new CstLinkmanDTO();
		this.getMapper().map(cstLinkman,cstLinkmanDTO);
		return cstLinkmanDTO;
	}
	
	@Override
	public void saveCstLinkman(CstLinkmanDTO cstLinkmanDTO) {
		CstLinkman cstLinkman=new CstLinkman();
		this.getMapper().map(cstLinkmanDTO,cstLinkman);
		cstLinkmanDao.save(cstLinkman);
	}
	
	@Override
	public void updateCstLinkman(CstLinkmanDTO cstLinkmanDTO) {
		CstLinkman cstLinkman=new CstLinkman();
		this.getMapper().map(cstLinkmanDTO,cstLinkman);
		cstLinkmanDao.update(cstLinkman);
	}
	
	@Override
	public void deleteCstLinkman(CstLinkmanDTO cstLinkmanDTO) {
		CstLinkman cstLinkman=this.cstLinkmanDao.getById(cstLinkmanDTO.getId());
		cstLinkmanDao.delete(cstLinkman);
	}

	@Override
	public Page<CstLinkmanDTO> getByPaging(CstLinkmanQueryDTO cstLinkmanQueryDTO) {
		Page<CstLinkman> pageResult=cstLinkmanDao.getByCondition(cstLinkmanQueryDTO);
		List<CstLinkman> resultList = pageResult.getList();
		List<CstLinkmanDTO> dtoList = new ArrayList<CstLinkmanDTO>();
		
		for(int i = 0 ; i < resultList.size() ; i ++){
			CstLinkmanDTO dto = new CstLinkmanDTO();
			this.getMapper().map(resultList.get(i), dto);
			dtoList.add(dto);
		}
		
		return new Page<CstLinkmanDTO>(pageResult.getCurrentPage(),pageResult.getPageSize(),dtoList,pageResult.getRecTotal());
	}
	


}
