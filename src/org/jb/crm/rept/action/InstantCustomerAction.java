package org.jb.crm.rept.action;

import java.util.List;

import org.jb.common.action.BaseAction;
import org.jb.crm.rept.dto.CustCons;
import org.jb.common.bean.Page;
import org.jb.crm.basd.service.IBasDictService;
import org.jb.crm.cus.dto.CstLostDTO;
import org.jb.crm.cus.dto.CstLostQueryDTO;
import org.jb.crm.cus.service.ICstLostService;
import org.jb.crm.rept.dto.InstantCustomer;
import org.jb.crm.rept.dto.InstantCustomerQueryDTO;
import org.jb.crm.rept.dto.InstantCustomerService;
import org.jb.crm.rept.service.IInstantCustomerService;

public class InstantCustomerAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IInstantCustomerService instantCustomerService;
	private InstantCustomerQueryDTO instantCustomerQueryDTO = new InstantCustomerQueryDTO();
	private String instantCustomerServiceYear;
	private IBasDictService basDictService;

	public void setBasDictService(IBasDictService basDictService) {
		this.basDictService = basDictService;
	}

	private String optionType;

	private ICstLostService cstLostService;
	private CstLostQueryDTO cstLostQueryDTO = new CstLostQueryDTO();

	public CstLostQueryDTO getCstLostQueryDTO() {
		return cstLostQueryDTO;
	}

	public void setCstLostQueryDTO(CstLostQueryDTO cstLostQueryDTO) {
		this.cstLostQueryDTO = cstLostQueryDTO;
	}

	public void setCstLostService(ICstLostService cstLostService) {
		this.cstLostService = cstLostService;
	}

	public String loadAllInstantCustomer() {
		try {
			List<InstantCustomer> resultList = this.instantCustomerService.loadAllInstantCustomer(instantCustomerQueryDTO);
			this.getRequest().put("resultList", resultList);
			this.getRequest().put("instantCustomerQueryDTO", instantCustomerQueryDTO);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String loadAllInstantCustomerService() {
		try {
			List<InstantCustomerService> resultList = this.instantCustomerService.loadAllInstantCustomerServiceByYear(instantCustomerServiceYear);
			this.getRequest().put("svrTypeList", basDictService.loadAllDictsByType("服务类型"));
			this.getRequest().put("resultList", resultList);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String loadAllInstantCustomerLost() {
		try {
			cstLostQueryDTO.setLstStatus("3");
			Page<CstLostDTO> resultList = this.cstLostService.getByPaging(cstLostQueryDTO);
			this.getRequest().put("pageResult", resultList);
			this.getRequest().put("queryCondition", cstLostQueryDTO);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String loadAllCustCons() {
		try {
			List<CustCons> resultList = this.instantCustomerService.loadAllCustCons(optionType);
			this.getRequest().put("resultList", resultList);
			this.getRequest().put("optionType", optionType);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String getInstantCustomerServiceYear() {
		return instantCustomerServiceYear;
	}

	public void setInstantCustomerServiceYear(String instantCustomerServiceYear) {
		this.instantCustomerServiceYear = instantCustomerServiceYear;
	}

	public void setInstantCustomerQueryDTO(InstantCustomerQueryDTO instantCustomerQueryDTO) {
		this.instantCustomerQueryDTO = instantCustomerQueryDTO;
	}

	public InstantCustomerQueryDTO getInstantCustomerQueryDTO() {
		return instantCustomerQueryDTO;
	}

	public void setInstantCustomerService(IInstantCustomerService instantCustomerService) {
		this.instantCustomerService = instantCustomerService;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

}
