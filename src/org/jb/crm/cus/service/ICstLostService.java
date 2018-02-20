package org.jb.crm.cus.service;

import org.jb.common.bean.Page;
import org.jb.crm.cus.dto.CstLostDTO;
import org.jb.crm.cus.dto.CstLostQueryDTO;

public interface ICstLostService {
	public Page<CstLostDTO> getByPaging(CstLostQueryDTO cstLostQueryDTO);
	public void generatePreWarningCstLost();
	public CstLostDTO getById(Long id);
	public void confirmPutoffCstLost(CstLostDTO cstLostDTO);
	public void modifyPutoffCstLost(CstLostDTO cstLostDTO);
}
