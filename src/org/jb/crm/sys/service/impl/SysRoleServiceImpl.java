package org.jb.crm.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jb.common.bean.Page;
import org.jb.common.service.BaseService;
import org.jb.crm.sys.dao.ISysRoleDao;
import org.jb.crm.sys.domain.SysRight;
import org.jb.crm.sys.domain.SysRole;
import org.jb.crm.sys.dto.SysRoleDTO;
import org.jb.crm.sys.dto.SysRoleQueryDTO;
import org.jb.crm.sys.service.ISysRoleService;

public class SysRoleServiceImpl extends BaseService implements
		ISysRoleService {

	private ISysRoleDao sysRoleDao;
	
	@Override
	public void addRole(SysRoleDTO sysRoleDTO) {
		SysRole sysRole = new SysRole();
		
		this.getMapper().map(sysRoleDTO, sysRole);
		this.sysRoleDao.save(sysRole);
	}

	public void setSysRoleDao(ISysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}

	@Override
	public Page<SysRoleDTO> loadAllRolesByPagging(
			SysRoleQueryDTO sysRoleQueryDTO) {
		Page<SysRole> pageResult = this.sysRoleDao.getByCondition(sysRoleQueryDTO);
		List<SysRole> resultList = pageResult.getList();
		List<SysRoleDTO> dtoList = new ArrayList<SysRoleDTO>();
		
		for(int i = 0 ; i < resultList.size() ; i ++){
			SysRoleDTO dto = new SysRoleDTO();
			this.getMapper().map(resultList.get(i), dto);
			dtoList.add(dto);
		}
		
		return new Page<SysRoleDTO>(pageResult.getCurrentPage(),pageResult.getPageSize(),dtoList,pageResult.getRecTotal());
		
	}

	@Override
	public SysRoleDTO loadRoleById(SysRoleQueryDTO sysRoleQueryDTO) {
		SysRole role = this.sysRoleDao.getById(sysRoleQueryDTO.getId());
		//Set<SysRight> sysRightsSet = role.getSysRights();
		SysRoleDTO dto = new SysRoleDTO();
		this.getMapper().map(role, dto);
		return dto;
	}

	@Override
	public void mofidyRole(SysRoleDTO sysRoleDTO) {//±à¼­½ÇÉ«£¬É¾³ý½ÇÉ«
		SysRole role = this.sysRoleDao.getById(sysRoleDTO.getId());
		role.setSysRights(null);
		this.sysRoleDao.update(role);
		this.getMapper().map(sysRoleDTO, role);
		this.sysRoleDao.update(role);//[±à¼­½ÇÉ«£¬É¾³ý½ÇÉ«]-->³Ö¾Ã»¯
	}

	@Override
	public void deleteRole(SysRoleDTO sysRoleDTO) {
		SysRole role = this.sysRoleDao.getById(sysRoleDTO.getId());
		role.setRoleFlag(0);
		this.sysRoleDao.update(role);
	}

	@Override
	public List<SysRoleDTO> loadAllNormalRoles(SysRoleQueryDTO sysRoleQueryDTO) {
		List<SysRole> resultList = this.sysRoleDao.getByCondition(sysRoleQueryDTO).getList();
		List<SysRoleDTO> dtoList = new ArrayList<SysRoleDTO>();
		for(int i = 0 ; i < resultList.size() ; i ++){
			SysRoleDTO dto = new SysRoleDTO();
			this.getMapper().map(resultList.get(i), dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	
}
