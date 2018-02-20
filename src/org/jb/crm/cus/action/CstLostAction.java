package org.jb.crm.cus.action;


import java.util.Date;

import org.jb.common.action.BaseAction;
import org.jb.common.bean.Page;
import org.jb.crm.cus.dto.CstLostDTO;
import org.jb.crm.cus.dto.CstLostQueryDTO;
import org.jb.crm.cus.service.ICstLostService;
import org.jb.crm.sys.dto.SysUserDTO;

import com.opensymphony.xwork2.ModelDriven;

public class CstLostAction extends BaseAction implements ModelDriven<CstLostDTO>{

	private static final long serialVersionUID = 1L;
	
	private CstLostDTO cstLostDTO=new CstLostDTO();
	private CstLostQueryDTO cstLostQueryDTO=new CstLostQueryDTO();

	public CstLostQueryDTO getCstLostQueryDTO() {
		return cstLostQueryDTO;
	}

	@Override
	public CstLostDTO getModel() {
		return cstLostDTO;
	}
	
	private ICstLostService cstLostService;

	public void setCstLostService(ICstLostService cstLostService) {
		this.cstLostService = cstLostService;
	}
	
	public String loadCstLostsByManager(){
		try{
			//this.cstLostService.generatePreWarningCstLost();
			SysUserDTO dto=(SysUserDTO) this.getSession().get("userDto");
			cstLostQueryDTO.setLstCustManagerId(dto.getId());
			Page<CstLostDTO> pageResult= this.cstLostService.getByPaging(cstLostQueryDTO);
			this.getRequest().put("pageResult", pageResult);
			this.getRequest().put("queryCondition", cstLostQueryDTO);
			return "toListCstLostPage";
		}catch(Exception exc){
			exc.printStackTrace();
			return ERROR;
		}
	}
	
	public String toModifyPutoffCstLostPage(){
		try{
			cstLostDTO=this.cstLostService.getById(cstLostQueryDTO.getId());
			return "toModifyPutoffCstLostPage";
		}catch(Exception exc){
			exc.printStackTrace();
			return ERROR;
		}
	}
	
	public String modifyPutoffCstLost(){
		try{
			cstLostDTO.setLstStatus("2");
			this.cstLostService.modifyPutoffCstLost(cstLostDTO);
			return "loadCstLostsByManager";
		}catch(Exception exc){
			exc.printStackTrace();
			return ERROR;
		}
	}
	
	public String toConfirmPutoffCstLostPage(){
		try{
			cstLostDTO=this.cstLostService.getById(cstLostQueryDTO.getId());
			return "toConfirmPutoffCstLostPage";
		}catch(Exception exc){
			exc.printStackTrace();
			return ERROR;
		}
	}
	public String confirmPutoffCstLost(){
		try{
			cstLostDTO.setLstStatus("3");
			cstLostDTO.setLstLostDate(new Date());
			this.cstLostService.confirmPutoffCstLost(cstLostDTO);
			return "loadCstLostsByManager";
		}catch(Exception exc){
			exc.printStackTrace();
			return ERROR;
		}
	}
	
}
