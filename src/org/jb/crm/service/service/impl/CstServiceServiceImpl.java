package org.jb.crm.service.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jb.common.bean.Page;
import org.jb.common.service.BaseService;
import org.jb.crm.service.dao.ICstServiceDao;
import org.jb.crm.service.domain.CstService;
import org.jb.crm.service.dto.CstServiceDTO;
import org.jb.crm.service.dto.CstServiceQueryDTO;
import org.jb.crm.service.service.ICstServiceService;
import org.jb.crm.sys.dao.ISysUserDao;
import org.jb.crm.sys.domain.SysUser;

public class CstServiceServiceImpl extends BaseService implements ICstServiceService {
	private ICstServiceDao cstServiceDao;

	public void setCstServiceDao(ICstServiceDao cstServiceDao) {
		this.cstServiceDao = cstServiceDao;
	}
	
	private ISysUserDao sysUserDao;
	
	public void setSysUserDao(ISysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
	}

	@Override
	public void createCstServiceByManager(CstServiceDTO cstServiceDTO) {
		CstService service = new CstService();
		this.getMapper().map(cstServiceDTO, service);
		this.cstServiceDao.save(service);

	}
	
	@Override
	public CstServiceDTO getById(Long id){
		CstService cstService=this.cstServiceDao.getById(id);
		CstServiceDTO cstServiceDTO=new CstServiceDTO();
		this.getMapper().map(cstService,cstServiceDTO);
		return cstServiceDTO;
	}
	
	@Override
	public void dispatchCstServiceBySale(CstServiceDTO cstServiceDTO){
		CstService cstService=this.cstServiceDao.getById(cstServiceDTO.getId());
		SysUser sysDue=sysUserDao.getById(cstServiceDTO.getSvrDueDTO().getId());
		cstService.setSvrDue(sysDue);
		cstService.setSvrDueDate(new Date());
		cstService.setSvrDueTo(sysDue.getUsrName());
		cstService.setSvrStatus("已分配");
		this.cstServiceDao.update(cstService);
	}
	
	@Override
	public void deleteCstServiceBySale(CstServiceDTO cstServiceDTO){
		CstService cstService=this.cstServiceDao.getById(cstServiceDTO.getId());
		this.cstServiceDao.delete(cstService);
	}
	
	@Override
	public Page<CstServiceDTO> getByPaging(CstServiceQueryDTO cstServiceQueryDTO){
		Page<CstService> pageResult=cstServiceDao.getByCondition(cstServiceQueryDTO);
		List<CstService> resultList = pageResult.getList();
		List<CstServiceDTO> dtoList = new ArrayList<CstServiceDTO>();
		
		for(int i = 0 ; i < resultList.size() ; i ++){
			CstServiceDTO dto = new CstServiceDTO();
			this.getMapper().map(resultList.get(i), dto);
			dtoList.add(dto);
		}
		
		return new Page<CstServiceDTO>(pageResult.getCurrentPage(),pageResult.getPageSize(),dtoList,pageResult.getRecTotal());
	}
	
	@Override
	public List<String> getAllSvrStatus(){
		List<String> svrStatusList=new ArrayList<String>();
		svrStatusList.add("新创建");
		svrStatusList.add("已分配");
		svrStatusList.add("已处理");
		svrStatusList.add("已归档");
		return svrStatusList;
	}

	@Override
	public void dealCstServiceByManager(CstServiceDTO cstServiceDTO) {
		CstService cstService=this.cstServiceDao.getById(cstServiceDTO.getId());
		SysUser svrDealer=sysUserDao.getById(cstServiceDTO.getSvrDealerDTO().getId());
		cstService.setSvrDeal(cstServiceDTO.getSvrDeal());
		cstService.setSvrDealDate(new Date());
		cstService.setSvrDealer(svrDealer);
		cstService.setSvrDealBy(svrDealer.getUsrName());
		cstService.setSvrStatus("已处理");
		this.cstServiceDao.update(cstService);
		
	}
	
	@Override
	public void feedbackCstServiceByManager(CstServiceDTO cstServiceDTO){
		CstService cstService=this.cstServiceDao.getById(cstServiceDTO.getId());
		cstService.setSvrSatisfy(cstServiceDTO.getSvrSatisfy());
		cstService.setSvrResult(cstServiceDTO.getSvrResult());
		if(cstService.getSvrSatisfy()>=3)
			cstService.setSvrStatus("已归档");
		else
			cstService.setSvrStatus("已分配");
		this.cstServiceDao.update(cstService);
	}
	

}
