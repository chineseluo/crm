package org.jb.crm.cus.service;

import java.util.List;

import org.jb.common.bean.Page;
import org.jb.crm.cus.dto.CstCustomerDTO;
import org.jb.crm.cus.dto.CstCustomerQueryDTO;
import org.jb.crm.sale.dto.SalChanceDTO;
import org.jb.crm.sys.dto.SysUserDTO;

public interface ICstCustomerService {
	public Page<CstCustomerDTO> getByPaging(CstCustomerQueryDTO cstCustomerQueryDTO);
	public CstCustomerDTO getById(Long id);
	public CstCustomerDTO getByCustName(String custName);
	void updateCstCustomer(CstCustomerDTO cstCustomerDTO);
	void deleteCstCustomer(CstCustomerDTO cstCustomerDTO, SysUserDTO sysUserDTO);
	public void addCstCustomer(SalChanceDTO salChanceDto);
	public List<CstCustomerDTO> getAllCstCustomer(CstCustomerQueryDTO cstCustomerQueryDTO);
}
