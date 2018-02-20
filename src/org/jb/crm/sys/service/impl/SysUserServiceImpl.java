package org.jb.crm.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jb.common.bean.Page;
import org.jb.common.service.BaseService;
import org.jb.crm.sys.dao.ISysRoleDao;
import org.jb.crm.sys.dao.ISysUserDao;
import org.jb.crm.sys.domain.SysRole;
import org.jb.crm.sys.domain.SysUser;
import org.jb.crm.sys.dto.SysUserDTO;
import org.jb.crm.sys.dto.SysUserQueryDTO;
import org.jb.crm.sys.service.ISysUserService;

public class SysUserServiceImpl extends BaseService implements ISysUserService {

	private ISysUserDao sysUserDao;
	private ISysRoleDao sysRoleDao;
	
	@Override
	public void saveUser(SysUserDTO sysUserDTO) {
		SysUser sysUser = new SysUser();
		this.getMapper().map(sysUserDTO, sysUser);
		this.sysUserDao.save(sysUser);

	}

	public void setSysUserDao(ISysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
	}

	@Override
	public SysUserDTO login(SysUserQueryDTO sysUserQueryDTO) {
		List<SysUser> resultList = this.sysUserDao.getByCondition(sysUserQueryDTO).getList();
		if(null != resultList && resultList.size() > 0){
			SysUserDTO dto = new SysUserDTO();
			this.getMapper().map(resultList.get(0), dto);
			return dto;
		}else{
			throw new RuntimeException("用户密码错误");
		}
	}

	@Override
	public Page<SysUserDTO> loadAllUsersByPagging(SysUserQueryDTO sysUserQueryDTO) {
		Page<SysUser> pageResult = this.sysUserDao.getByCondition(sysUserQueryDTO);
		List<SysUserDTO> dtoList=  new ArrayList<SysUserDTO>();
		for(int i = 0 ; i < pageResult.getList().size() ; i ++){
			SysUserDTO dto = new SysUserDTO();
			this.getMapper().map(pageResult.getList().get(i), dto);
			dtoList.add(dto);
		}
		
		return new Page<SysUserDTO>(pageResult.getCurrentPage(),pageResult.getPageSize(),dtoList,pageResult.getRecTotal());
	}

	@Override
	public SysUserDTO loadUserById(SysUserQueryDTO sysUserQueryDTO) {
		SysUser sysUser = this.sysUserDao.getById(sysUserQueryDTO.getId());
		SysUserDTO dto = new SysUserDTO();
		this.getMapper().map(sysUser, dto);
		return dto;
	}

	@Override
	public void modifyUser(SysUserDTO sysUserDTO) {
		SysUser sysUser = this.sysUserDao.getById(sysUserDTO.getId());
		sysUser.setSysRole(null);
		this.getMapper().map(sysUserDTO, sysUser);
		this.sysUserDao.update(sysUser);
	}

	public void setSysRoleDao(ISysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}

	@Override
	public void deleteUser(SysUserDTO sysUserDTO) {
		SysUser sysUser = this.sysUserDao.getById(sysUserDTO.getId());
		sysUser.setUsrFlag(0);
		this.sysUserDao.update(sysUser);
	}

	@Override
	public List<SysUserDTO> findManager() {
		List<SysUser> resultList = sysUserDao.findManager();
		List<SysUserDTO> dtoList = new ArrayList<SysUserDTO>();
		for (int i = 0; i < resultList.size(); i++) {
			SysUserDTO sysUserDTO = new SysUserDTO();
			this.getMapper().map(resultList.get(i),sysUserDTO);
			dtoList.add(sysUserDTO);
		}
		return dtoList;
	}

}
