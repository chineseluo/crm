package org.jb.crm.cus.dao;

import java.util.Date;
import java.util.List;

import org.jb.common.bean.Page;
import org.jb.common.dao.IBaseDAO;
import org.jb.crm.cus.domain.CstCustomer;
import org.jb.crm.cus.dto.CstCustomerQueryDTO;


public interface ICstCustomerDao extends IBaseDAO<Long,CstCustomer> {

	public Page<CstCustomer> getByCondition(CstCustomerQueryDTO cstCustomerQueryDTO);
	
	public List<CstCustomer> getNotOrderCustomers(Date beginDate,Date endDate);
	
	public Date getLastestOrderDateById(Long id);

	public List<CstCustomer> getAllByCondition(CstCustomerQueryDTO cstCustomerQueryDTO);

	
}