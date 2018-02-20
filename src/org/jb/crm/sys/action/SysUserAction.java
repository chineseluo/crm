package org.jb.crm.sys.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jb.common.action.BaseAction;
import org.jb.common.bean.Page;
import org.jb.crm.sys.dto.SysRightDTO;
import org.jb.crm.sys.dto.SysRoleDTO;
import org.jb.crm.sys.dto.SysRoleQueryDTO;
import org.jb.crm.sys.dto.SysUserDTO;
import org.jb.crm.sys.dto.SysUserQueryDTO;
import org.jb.crm.sys.service.ISysRoleService;
import org.jb.crm.sys.service.ISysUserService;

public class SysUserAction extends BaseAction {

	private ISysUserService sysUserService;
	private ISysRoleService sysRoleService;
	
	private SysUserDTO sysUserDTO = new SysUserDTO();
	private SysUserQueryDTO sysUserQueryDTO = new SysUserQueryDTO();
	
	//����Ȩ�޵��ı�����(rightText)
	private Set<String> rightStrSet = new HashSet<String>();
	
	/**
	 * ����û�
	 */
	

	public String saveUser(){
		try{
			this.sysUserService.saveUser(sysUserDTO);
			return SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * �û���½
	 * @param sysUserService
	 */
	public String login(){
		try{
			SysUserDTO result = this.sysUserService.login(sysUserQueryDTO);
			//1.�����в˵��ڳ�ʼ����������
			//2.����û���Ȩ������ʾ�˵�
			Set<SysRightDTO> rightDtoSet = result.getSysRole().getSysRights();
			for(SysRightDTO rightDto : rightDtoSet){
				//Ȩ�޹���--�û�����--��ɫ
				showMenu(rightDto);
			}
			System.out.println(rightDtoSet);
			StringBuilder sb = new StringBuilder();
			for(String str : rightStrSet){
				sb.append(str + ",");
			}
			String resultStr = sb.substring(0,sb.length()-1);
			
			this.getSession().put("rightStr", resultStr);
			this.getSession().put("userDto", result);
			return SUCCESS;
		}catch(Exception ex){
			this.getRequest().put("responseText", "用户登录失败:"+ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	
	public String loginout (){
		try{
			if(this.getSession().get("userDto")!=null){
				this.getSession().remove("userDto");
				this.getSession().remove("rightStr");
			}
			return SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * ��װ�û���Ȩ���б�
	 * @param rightDTO
	 */
	private void showMenu(SysRightDTO rightDTO){
		if(null != rightDTO){
			rightStrSet.add(rightDTO.getRightText());
			SysRightDTO parent = rightDTO.getParent();
			showMenu(parent);
		}
	}
	
	/**
	 * �û��б��ѯ
	 * 
	 */
	public String loadAllUsers(){
		try{
			Page<SysUserDTO> pageResult = this.sysUserService.loadAllUsersByPagging(sysUserQueryDTO);
			this.getRequest().put("pageResult", pageResult);
			this.getRequest().put("queryCondition",sysUserQueryDTO);
			return SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * ����û�ID�������û���Ϣ
	 * @return
	 */
	public String loadUserById(){
		try{
			SysUserDTO dto = this.sysUserService.loadUserById(sysUserQueryDTO);
			this.getRequest().put("userDTO", dto);
			String oper = this.getParameters().get("oper")[0];
			if("modify".equals(oper)){
				List<SysRoleDTO> roleDtoList = this.sysRoleService.loadAllNormalRoles(new SysRoleQueryDTO());
				this.getRequest().put("roleDtoList", roleDtoList);
			}
			return oper;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * �����û�
	 * @return
	 */
	public String modifyUser(){
		try{
			this.sysUserService.modifyUser(sysUserDTO);
			return SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * ɾ���û�
	 * @return
	 */
	public String deleteUser(){
		try{
			this.sysUserService.deleteUser(sysUserDTO);
			return SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
		
	}
	
	
	public SysUserQueryDTO getSysUserQueryDTO() {
		return sysUserQueryDTO;
	}

	public void setSysUserQueryDTO(SysUserQueryDTO sysUserQueryDTO) {
		this.sysUserQueryDTO = sysUserQueryDTO;
	}

	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public SysUserDTO getSysUserDTO() {
		return sysUserDTO;
	}

	public void setSysUserDTO(SysUserDTO sysUserDTO) {
		this.sysUserDTO = sysUserDTO;
	}

	public void setSysRoleService(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}
	
	
}
