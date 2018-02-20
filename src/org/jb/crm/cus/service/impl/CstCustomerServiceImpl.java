package org.jb.crm.cus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jb.common.bean.Page;
import org.jb.common.service.BaseService;
import org.jb.crm.cus.dao.ICstCustomerDao;
import org.jb.crm.cus.domain.CstCustomer;
import org.jb.crm.cus.dto.CstCustomerDTO;
import org.jb.crm.cus.dto.CstCustomerQueryDTO;
import org.jb.crm.cus.service.ICstCustomerService;
import org.jb.crm.sale.dto.SalChanceDTO;
import org.jb.crm.sys.domain.SysUser;
import org.jb.crm.sys.dto.SysUserDTO;

public class CstCustomerServiceImpl extends BaseService implements ICstCustomerService{

	private ICstCustomerDao cstCustomerDao;
	
	public void setCstCustomerDao(ICstCustomerDao cstCustomerDao) {
		this.cstCustomerDao = cstCustomerDao;
	}


	@Override
	public Page<CstCustomerDTO> getByPaging(CstCustomerQueryDTO cstCustomerQueryDTO) {
		Page<CstCustomer> pageResult = this.cstCustomerDao.getByCondition(cstCustomerQueryDTO);
		List<CstCustomer> resultList = pageResult.getList();
		List<CstCustomerDTO> dtoList = new ArrayList<CstCustomerDTO>();
		
		for(int i = 0 ; i < resultList.size() ; i ++){
			CstCustomerDTO dto = new CstCustomerDTO();
			this.getMapper().map(resultList.get(i), dto);
			dtoList.add(dto);
		}
		
		return new Page<CstCustomerDTO>(pageResult.getCurrentPage(),pageResult.getPageSize(),dtoList,pageResult.getRecTotal());
	}


	@Override
	public CstCustomerDTO getById(Long id) {
		CstCustomerDTO cstCustomerDTO=new CstCustomerDTO();
		this.getMapper().map(cstCustomerDao.getById(id), cstCustomerDTO);
		return cstCustomerDTO;
	}
	
	@Override
	public void updateCstCustomer(CstCustomerDTO cstCustomerDTO) {	
		CstCustomer cstCustomer=new CstCustomer();
		this.getMapper().map(cstCustomerDTO, cstCustomer);
		this.cstCustomerDao.update(cstCustomer);
	}
	

	@Override
	public void deleteCstCustomer(CstCustomerDTO cstCustomerDTO,SysUserDTO sysUserDTO) {
		CstCustomer cstCustomer=this.cstCustomerDao.getById(cstCustomerDTO.getId());
		if(cstCustomer.getCustManager().getId().equals(sysUserDTO.getId()))
			cstCustomer.setCustStatus("3");
		this.cstCustomerDao.update(cstCustomer);
	}


	@Override
	public void addCstCustomer(SalChanceDTO salChanceDto) {
		CstCustomer cstCustomer= new CstCustomer();
		cstCustomer.setCustName(salChanceDto.getChcCustName());
		cstCustomer.setCustManagerName(salChanceDto.getChcDueTo());
		
		cstCustomer.setCustStatus("1");
		cstCustomer.setCustNo(salChanceDto.getId()+"");
		SysUser manager = new SysUser();
		this.getMapper().map(salChanceDto.getDueUserDTO(), manager);
		cstCustomer.setCustManager(manager);
		this.cstCustomerDao.save(cstCustomer);	
	}


	@Override
	public CstCustomerDTO getByCustName(String custName) {
		CstCustomerQueryDTO cstCustomerQueryDTO =new CstCustomerQueryDTO();
		cstCustomerQueryDTO.setCustName(custName);
		List<CstCustomer> list=cstCustomerDao.getByCondition(cstCustomerQueryDTO).getList();
		if(list==null || list.size()!=1)
			return null;
		CstCustomerDTO cstCustomerDTO =new CstCustomerDTO();
		this.getMapper().map(list.get(0),cstCustomerDTO);
		return cstCustomerDTO;
	}
	
	@Override
	public List<CstCustomerDTO> getAllCstCustomer(CstCustomerQueryDTO cstCustomerQueryDTO){
		
		List<CstCustomer> resultList = this.cstCustomerDao.getAllByCondition(cstCustomerQueryDTO);
		List<CstCustomerDTO> dtoList = new ArrayList<CstCustomerDTO>();
		
		for(int i = 0 ; i < resultList.size() ; i ++){
			CstCustomerDTO dto = new CstCustomerDTO();
			this.getMapper().map(resultList.get(i), dto);
			dtoList.add(dto);
		}
		return dtoList;
	}



}
