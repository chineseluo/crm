package org.jb.crm.cus.action;

import java.util.List;

import org.jb.common.action.BaseAction;
import org.jb.crm.cus.dto.CstCustomerDTO;
import org.jb.crm.cus.dto.CstActivityDTO;
import org.jb.crm.cus.dto.CstActivityQueryDTO;
import org.jb.crm.cus.service.ICstCustomerService;
import org.jb.crm.cus.service.ICstActivityService;

import com.opensymphony.xwork2.ModelDriven;

public class CstActivityAction extends BaseAction implements ModelDriven<CstActivityDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ICstActivityService cstActivityService;

	public void setCstActivityService(ICstActivityService cstActivityService) {
		this.cstActivityService = cstActivityService;
	}

	private CstActivityDTO cstActivityDTO = new CstActivityDTO();

	private CstActivityQueryDTO cstActivityQueryDTO = new CstActivityQueryDTO();

	public CstActivityQueryDTO getCstActivityQueryDTO() {
		return cstActivityQueryDTO;
	}

	public void setCstActivityQueryDTO(CstActivityQueryDTO cstActivityQueryDTO) {
		this.cstActivityQueryDTO = cstActivityQueryDTO;
	}

	private CstCustomerDTO cstCustomer;

	public CstCustomerDTO getCstCustomer() {
		return cstCustomer;
	}

	public String addCstActivity() {
		try {
			cstCustomer = cstCustomerService.getById(cstActivityQueryDTO.getAtvCustomerId());
			cstActivityDTO.setAtvCustName(cstCustomer.getCustName());
			cstActivityDTO.setCstCustomerDTO(cstCustomer);
			cstActivityService.saveCstActivity(cstActivityDTO);

			this.getRequest().put("queryCondition", cstActivityQueryDTO);
			return "loadAllCstActivitys";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}

	public String toAddCstActivityPage() {
		return "toAddCstActivityPage";
	}

	private ICstCustomerService cstCustomerService;

	public void setCstCustomerService(ICstCustomerService cstCustomerService) {
		this.cstCustomerService = cstCustomerService;
	}

	public String toModifyCstActivityPage() {
		cstActivityDTO=cstActivityService.getById(cstActivityDTO.getId());
		return "toModifyActivityPage";
	}

	public String modifyCstActivity() {
		try {
			cstActivityService.updateCstActivity(cstActivityDTO);
			this.getRequest().put("queryCondition", cstActivityQueryDTO);
			return "loadAllCstActivitys";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	public String removeCstActivity() {
		try {
			cstActivityService.deleteCstActivity(cstActivityDTO);
			this.getRequest().put("queryCondition", cstActivityQueryDTO);
			return "loadAllCstActivitys";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}

	public String loadAllCstActivitys() {
		try {
			List<CstActivityDTO> pageResult = this.cstActivityService.getByCustomerId(cstActivityQueryDTO.getAtvCustomerId());
			cstCustomer = cstCustomerService.getById(cstActivityQueryDTO.getAtvCustomerId());
			this.getRequest().put("pageResult", pageResult);
			this.getRequest().put("queryCondition", cstActivityQueryDTO);
			return "toListCstActivityPage";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}

	@Override
	public CstActivityDTO getModel() {
		return cstActivityDTO;
	}
	
}
