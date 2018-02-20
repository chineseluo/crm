package org.jb.crm.service.service;


import java.util.List;

import org.jb.common.bean.Page;
import org.jb.crm.service.dto.CstServiceDTO;
import org.jb.crm.service.dto.CstServiceQueryDTO;

public interface ICstServiceService {
	public void createCstServiceByManager(CstServiceDTO cstServiceDTO);

	public CstServiceDTO getById(Long id);

	public Page<CstServiceDTO> getByPaging(CstServiceQueryDTO cstServiceQueryDTO);

	public void dispatchCstServiceBySale(CstServiceDTO cstServiceDTO);

	public List<String> getAllSvrStatus();

	public void deleteCstServiceBySale(CstServiceDTO cstServiceDTO);
	
	public void dealCstServiceByManager(CstServiceDTO cstServiceDTO);

	public void feedbackCstServiceByManager(CstServiceDTO cstServiceDTO);


}
