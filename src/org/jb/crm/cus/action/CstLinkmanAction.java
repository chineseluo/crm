package org.jb.crm.cus.action;

import org.jb.common.action.BaseAction;
import org.jb.common.bean.Page;
import org.jb.crm.cus.dto.CstCustomerDTO;
import org.jb.crm.cus.dto.CstLinkmanDTO;
import org.jb.crm.cus.dto.CstLinkmanQueryDTO;
import org.jb.crm.cus.service.ICstCustomerService;
import org.jb.crm.cus.service.ICstLinkmanService;

import com.opensymphony.xwork2.ModelDriven;

public class CstLinkmanAction extends BaseAction implements ModelDriven<CstLinkmanDTO> {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private ICstLinkmanService cstLinkmanService;

	public void setCstLinkmanService(ICstLinkmanService cstLinkmanService) {
		this.cstLinkmanService = cstLinkmanService;
	}

	private CstLinkmanDTO cstLinkmanDTO = new CstLinkmanDTO();

	private CstLinkmanQueryDTO cstLinkmanQueryDTO = new CstLinkmanQueryDTO();

	public CstLinkmanQueryDTO getCstLinkmanQueryDTO() {
		return cstLinkmanQueryDTO;
	}

	public void setCstLinkmanQueryDTO(CstLinkmanQueryDTO cstLinkmanQueryDTO) {
		this.cstLinkmanQueryDTO = cstLinkmanQueryDTO;
	}

	private CstCustomerDTO cstCustomer;

	public CstCustomerDTO getCstCustomer() {
		return cstCustomer;
	}

	public String addCstLinkman() {
		try {
			cstCustomer = cstCustomerService.getById(cstLinkmanQueryDTO.getLkmCustomerId());
			cstLinkmanDTO.setLkmCustName(cstCustomer.getCustName());
			cstLinkmanDTO.setCstCustomerDTO(cstCustomer);
			cstLinkmanService.saveCstLinkman(cstLinkmanDTO);

			this.getRequest().put("queryCondition", cstLinkmanQueryDTO);
			return "loadAllCstLinkmans";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}

	public String toAddCstLinkmanPage() {
		return "toAddCstLinkmanPage";
	}

	private ICstCustomerService cstCustomerService;

	public void setCstCustomerService(ICstCustomerService cstCustomerService) {
		this.cstCustomerService = cstCustomerService;
	}

	public String toModifyCstLinkmanPage() {
		cstLinkmanDTO=cstLinkmanService.getById(cstLinkmanDTO.getId());
		return "toModifyLinkmanPage";
	}

	public String modifyCstLinkman() {
		try {
			cstLinkmanService.updateCstLinkman(cstLinkmanDTO);
			this.getRequest().put("queryCondition", cstLinkmanQueryDTO);
			return "loadAllCstLinkmans";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	public String removeCstLinkman() {
		try {
			cstLinkmanService.deleteCstLinkman(cstLinkmanDTO);
			this.getRequest().put("queryCondition", cstLinkmanQueryDTO);
			return "loadAllCstLinkmans";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}

	public String loadAllCstLinkmans() {
		try {
			Page<CstLinkmanDTO> pageResult = this.cstLinkmanService.getByPaging(cstLinkmanQueryDTO);
			cstCustomer = cstCustomerService.getById(cstLinkmanQueryDTO.getLkmCustomerId());
			this.getRequest().put("pageResult", pageResult);
			this.getRequest().put("queryCondition", cstLinkmanQueryDTO);
			return "toListCstLinkmanPage";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}

	@Override
	public CstLinkmanDTO getModel() {
		return cstLinkmanDTO;
	}

}
