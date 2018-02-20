package org.jb.crm.cus.service;

import java.util.List;

import org.jb.crm.cus.dto.CstActivityDTO;

public interface ICstActivityService {
	public void saveCstActivity(CstActivityDTO cstActivityDTO);
	public void updateCstActivity(CstActivityDTO cstActivityDTO);
	public CstActivityDTO getById(Long id);
	public List<CstActivityDTO> getByCustomerId(Long id);
	public void deleteCstActivity(CstActivityDTO cstActivityDTO);
}
