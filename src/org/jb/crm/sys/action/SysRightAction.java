package org.jb.crm.sys.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.jb.common.action.BaseAction;
import org.jb.crm.sys.dto.SysRightDTO;
import org.jb.crm.sys.dto.SysRightQueryDTO;
import org.jb.crm.sys.service.ISysRightService;

/**
 * Ȩ��Action
 * @author william
 *
 */
public class SysRightAction extends BaseAction {

	private ISysRightService sysRightService;
	
	private SysRightQueryDTO sysRightQueryDTO = new SysRightQueryDTO();
	
	private List<SysRightDTO> resultList = new ArrayList<SysRightDTO>();
	/**
	 * ����Ȩ��
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
	 * ���ݽ�ɫ��ţ�ƥ������Ȩ��Ȩ���б�
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
