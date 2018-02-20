package org.jb.crm.sys.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.jb.common.action.BaseAction;
import org.jb.crm.sys.dto.SysRightDTO;
import org.jb.crm.sys.dto.SysRightQueryDTO;
import org.jb.crm.sys.service.ISysRightService;

/**
 * 权限Action
 * @author william
 *
 */
public class SysRightAction extends BaseAction {

	private ISysRightService sysRightService;
	
	private SysRightQueryDTO sysRightQueryDTO = new SysRightQueryDTO();
	
	private List<SysRightDTO> resultList = new ArrayList<SysRightDTO>();
	/**
	 * 加载权限
	 * @return
	 */
	public String loadRights(){
		try{
			resultList = this.sysRightService.loadRights(sysRightQueryDTO);
			return SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 根据角色编号，匹配已授权的权限列表
	 * @return
	 */
	public String loadRightsByRole(){
		try{
			this.resultList = this.sysRightService.loadRightsByRole(sysRightQueryDTO);
			return SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
					
		}
	}
	
	
	
	

	public List<SysRightDTO> getResultList() {
		return resultList;
	}

	public void setSysRightService(ISysRightService sysRightService) {
		this.sysRightService = sysRightService;
	}

	@JSON(serialize=false)
	public SysRightQueryDTO getSysRightQueryDTO() {
		return sysRightQueryDTO;
	}

	public void setSysRightQueryDTO(SysRightQueryDTO sysRightQueryDTO) {
		this.sysRightQueryDTO = sysRightQueryDTO;
	}
	
	
	
}
