package org.jb.crm.rept.service.impl;

import java.util.List;

import org.jb.crm.basd.dao.IBasDictDao;
import org.jb.crm.basd.domain.BasDict;
import org.jb.crm.rept.dao.IInstantCustomerDao;
import org.jb.crm.rept.dto.CustCons;
import org.jb.crm.rept.dto.InstantCustomer;
import org.jb.crm.rept.dto.InstantCustomerQueryDTO;
import org.jb.crm.rept.dto.InstantCustomerService;
import org.jb.crm.rept.service.IInstantCustomerService;

public class InstantCustomerServiceImpl implements IInstantCustomerService {
	private IInstantCustomerDao instantCustomerDao;
	private IBasDictDao basDictDao;
	
	public void setBasDictDao(IBasDictDao basDictDao) {
		this.basDictDao = basDictDao;
	}

	public void setInstantCustomerDao(IInstantCustomerDao instantCustomerDao) {
		this.instantCustomerDao = instantCustomerDao;
	}
	
	@Override
	public List<InstantCustomer> loadAllInstantCustomer(
			InstantCustomerQueryDTO instantCustomerQueryDTO) {
		return this.instantCustomerDao.loadAllInstantCustomer(instantCustomerQueryDTO);
	}

	@Override
	public List<InstantCustomerService> loadAllInstantCustomerServiceByYear(String year) {
		
		return this.instantCustomerDao.loadAllInstantCustomerServiceByYear(year);
	}

	@Override
	public List<CustCons> loadAllCustCons(String optionType) {
		List<CustCons> resultList = this.instantCustomerDao.loadAllCustCons(optionType);
		
		
		if(!optionType.equals("custLevel")){
			if(resultList.size() != 0){
				for (int i = 0; i < 5; i++) {
					
					boolean flag1=true;
					int j = 0;
					for (j = 0; j < resultList.size(); j++) {
						boolean flag= true;
						if(resultList.get(j).getSasifyOrCredit() == j+1){
							flag=false;
						}
						if(flag){
							resultList.add(j, new CustCons(j+1,(long) 0));
							flag1=false;
							break;
						}	
						
					}
					if(flag1&&j<5){
						resultList.add(j, new CustCons(j+1,(long) 0));
					}
		
				}
				
			}
			else{
				for (int i = 0; i < 5; i++) {
					resultList.add(new CustCons(i+1,(long) 0));
				}
			}
	
		}
		else{
			List<String> custLevelTypeList = this.basDictDao.loadCustLevelType();
			for (int i = 0; i < resultList.size(); i++) {
				for (int j = 0; j <custLevelTypeList.size() ; j++) {
					if(resultList.get(i).getCustLevel().equals(custLevelTypeList.get(j))){
						custLevelTypeList.remove(j);
						i = 0;
						break;
					}
					
				}
				
			}
			for (int i = 0; i < custLevelTypeList.size(); i++) {
				resultList.add(new CustCons(custLevelTypeList.get(i),(long)0));
			}
		}
		return resultList;
	}
	
	



}
