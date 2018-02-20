package org.jb.crm.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jb.common.service.BaseService;
import org.jb.crm.sys.dao.ISysRightDao;
import org.jb.crm.sys.dao.ISysRoleDao;
import org.jb.crm.sys.domain.SysRight;
import org.jb.crm.sys.domain.SysRole;
import org.jb.crm.sys.dto.SysRightDTO;
import org.jb.crm.sys.dto.SysRightQueryDTO;
import org.jb.crm.sys.dto.SysRoleDTO;
import org.jb.crm.sys.service.ISysRightService;

public class SysRightServiceImpl extends BaseService implements
		ISysRightService {

	private ISysRightDao sysRightDao;
	
	private ISysRoleDao sysRoleDao;
	
	
	@Override
	public List<SysRightDTO> loadRights(SysRightQueryDTO sysRightQueryDTO) {
		List<SysRight> resultList = this.sysRightDao.getRights(sysRightQueryDTO);
		List<SysRightDTO> dtoList=  new ArrayList<SysRightDTO>();
		for(int i = 0 ; i < resultList.size() ; i ++){
			SysRightDTO dto = new SysRightDTO();
			this.getMapper().map(resultList.get(i), dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	public void setSysRightDao(ISysRightDao sysRightDao) {
		this.sysRightDao = sysRightDao;
	}
	
	@Override
	public List<SysRightDTO> loadRightsByRole(SysRightQueryDTO sysRightQueryDTO) {
		//��ѯ���ݿ��и�����ڵ�Ȩ��
		List<SysRight> resultList = this.sysRightDao.getRights(sysRightQueryDTO);
		List<SysRightDTO> dtoList = new ArrayList<SysRightDTO>();
		for(int i = 0 ; i < resultList.size() ; i ++){
			SysRightDTO dto = new SysRightDTO();
			this.getMapper().map(resultList.get(i), dto);
			dtoList.add(dto);
		}
		//��ѯ�ѻ�õĽ�ɫȨ��
		SysRole role = this.sysRoleDao.getById(sysRightQueryDTO.getRoleId());
		SysRoleDTO roleDto = new SysRoleDTO();
		this.getMapper().map(role, roleDto);
		
		Set<SysRightDTO> assignedSet = roleDto.getSysRights();
		
		for(int i = 0 ; i < dtoList.size() ; i ++){//Ӫ������\�ͻ�����Ȩ�޹���(�û�������ɫ����)
			SysRightDTO parent = dtoList.get(i);
			//��ѡ
			check(parent,assignedSet);
			//չ��
			expand(parent);
		}
		return dtoList;
	}

	//���ڵ��չ��
	private void expand(SysRightDTO parent) {
		if(null != parent){
			parent.setIsExpand(true);
			Set<SysRightDTO> children = parent.getChildren();
			for(SysRightDTO child : children){
				child.setIsExpand(true);
				expand(child);
			}
		}
		
	}

	//���ڵ�Ĺ�ѡ
	private void check(SysRightDTO sysRightDTO,Set<SysRightDTO> assignedSet  ){
		if(null != sysRightDTO){
			for(SysRightDTO child : assignedSet){
				if(child.getId().equals(sysRightDTO.getId())){
					sysRightDTO.setCheckState(1);
				}
				Set<SysRightDTO> children = sysRightDTO.getChildren();
				for(SysRightDTO innerChild : children){
					check(innerChild,assignedSet);
				}
			}
		}
	}
	
	public void setSysRoleDao(ISysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}

	
}
