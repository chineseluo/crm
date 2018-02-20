package org.jb.crm.cus.service;

import org.jb.common.bean.Page;
import org.jb.crm.cus.dto.CstLinkmanDTO;
import org.jb.crm.cus.dto.CstLinkmanQueryDTO;

public interface ICstLinkmanService {
	public void saveCstLinkman(CstLinkmanDTO cstLinkmanDTO);
	public Page<CstLinkmanDTO> getByPaging(CstLinkmanQueryDTO cstLinkmanQueryDTO);
	public void updateCstLinkman(CstLinkmanDTO cstLinkmanDTO);
	public CstLinkmanDTO getById(Long id);
	public void deleteCstLinkman(CstLinkmanDTO cstLinkmanDTO);
}
