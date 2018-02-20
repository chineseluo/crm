package org.jb.crm.sys.action;

import java.util.List;

import org.jb.common.action.BaseAction;
import org.jb.common.bean.Page;
import org.jb.crm.sys.dto.SysRoleDTO;
import org.jb.crm.sys.dto.SysRoleQueryDTO;
import org.jb.crm.sys.service.ISysRoleService;

public class SysRoleAction extends BaseAction {

	
	private SysRoleDTO sysRoleDTO = new SysRoleDTO();
	private ISysRoleService sysRoleService ;
	private SysRoleQueryDTO sysRoleQueryDTO = new SysRoleQueryDTO();
	
	
	public String addRole(){
		try {
			this.sysRoleService.addRole(sysRoleDTO);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	
	/**
	 * 查询角色列表
	 * @return
	 */
	public String loadAllRoles(){
		try{
			//根据查询DTO，查询角色信息
			Page<SysRoleDTO> pageResult = this.sysRoleService.loadAllRolesByPagging(sysRoleQueryDTO);
			//转发-->角色列表
			this.getRequest().put("pageResult", pageResult);
			this.getRequest().put("queryCondition", sysRoleQueryDTO);
			return SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	

	/**
	 * 修改角色
	 * @return
	 */
	public String modifyRole(){
		try{
			this.sysRoleService.mofidyRole(sysRoleDTO);
			return SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 根据角色ID,加载角色信息
	 * @return
	 */
	public String loadRoleById(){
		try{
			SysRoleDTO dto = this.sysRoleService.loadRoleById(sysRoleQueryDTO);
			this.getRequest().put("roleDto", dto);
			String operator = this.getParameters().get("oper")[0];
			return operator;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	
	/**
	 * 删除角色
	 * @return
	 */
	public String deleteRole(){
		try{
			this.sysRoleService.deleteRole(sysRoleDTO);
			return SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	
	/**
	 * 加载所有状态roleFlag=1为正常的角色
	 * @return
	 */
	public String loadAllNormalRole(){
		try{
			List<SysRoleDTO> resultList = this.sysRoleService.loadAllNormalRoles(sysRoleQueryDTO);
			this.getRequest().put("resultList", resultList);
			return SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	public SysRoleDTO getSysRoleDTO() {
		return sysRoleDTO;
	}

	public void setSysRoleDTO(SysRoleDTO sysRoleDTO) {
		this.sysRoleDTO = sysRoleDTO;
	}

	public void setSysRoleService(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}



	public SysRoleQueryDTO getSysRoleQueryDTO() {
		return sysRoleQueryDTO;
	}



	public void setSysRoleQueryDTO(SysRoleQueryDTO sysRoleQueryDTO) {
		this.sysRoleQueryDTO = sysRoleQueryDTO;
	}
	
	
}
