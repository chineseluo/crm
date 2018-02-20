package org.jb.crm.rept.dao;

import java.util.List;

import org.jb.crm.rept.dto.CustCons;
import org.jb.crm.rept.dto.InstantCustomer;
import org.jb.crm.rept.dto.InstantCustomerQueryDTO;
import org.jb.crm.rept.dto.InstantCustomerService;

public interface IInstantCustomerDao {

	public List<InstantCustomer> loadAllInstantCustomer(InstantCustomerQueryDTO instantCustomerQueryDTO);
	public List<InstantCustomerService> loadAllInstantCustomerServiceByYear(String year);
	public List<CustCons> loadAllCustCons(String optionType);

}
