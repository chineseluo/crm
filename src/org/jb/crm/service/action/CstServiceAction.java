package org.jb.crm.service.action;

import java.util.List;

import org.jb.common.action.BaseAction;
import org.jb.common.bean.Page;
import org.jb.crm.basd.dto.BasDictDTO;
import org.jb.crm.basd.service.IBasDictService;
import org.jb.crm.cus.dto.CstCustomerDTO;
import org.jb.crm.cus.dto.CstCustomerQueryDTO;
import org.jb.crm.cus.service.ICstCustomerService;
import org.jb.crm.service.dto.CstServiceDTO;
import org.jb.crm.service.dto.CstServiceQueryDTO;
import org.jb.crm.service.service.ICstServiceService;
import org.jb.crm.sys.dto.SysUserDTO;
import org.jb.crm.sys.service.ISysUserService;

import com.opensymphony.xwork2.ModelDriven;

public class CstServiceAction extends BaseAction implements ModelDriven<CstServiceDTO>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ICstServiceService cstServiceService;
	
	public void setCstServiceService(ICstServiceService cstServiceService) {
		this.cstServiceService = cstServiceService;
	}
	
	private IBasDictService basDictService;
	
	public void setBasDictService(IBasDictService basDictService) {
		this.basDictService = basDictService;
	}
	
	private ICstCustomerService cstCustomerService;

	public void setCstCustomerService(ICstCustomerService cstCustomerService) {
		this.cstCustomerService = cstCustomerService;
	}
	
	private ISysUserService sysUserService;
	
	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	private CstServiceDTO cstServiceDTO=new CstServiceDTO();
	
	private List<BasDictDTO> svrTypeList;
	
	private List<CstCustomerDTO> svrCustomerList;
	
	private List<String> svrStatusList;
	
	private List<SysUserDTO> svrManagerList;
	
	private Page<CstServiceDTO> pageResult;
	
	public List<BasDictDTO> getSvrTypeList() {
		return svrTypeList;
	}

	public List<CstCustomerDTO> getSvrCustomerList() {
		return svrCustomerList;
	}

	public List<String> getSvrStatusList() {
		return svrStatusList;
	}

	public List<SysUserDTO> getSvrManagerList() {
		return svrManagerList;
	}

	public Page<CstServiceDTO> getPageResult() {
		return pageResult;
	}

	public CstServiceQueryDTO cstServiceQueryDTO=new CstServiceQueryDTO();

	public CstServiceQueryDTO getCstServiceQueryDTO() {
		return cstServiceQueryDTO;
	}


	public String toAddCstServicePage(){
		try{
			svrTypeList=this.basDictService.loadAllDictsByType("服务类型");
			CstCustomerQueryDTO cstCustomerQueryDTO=new CstCustomerQueryDTO();
			SysUserDTO userDto=(SysUserDTO) this.getSession().get("userDto");
			cstCustomerQueryDTO.setCustManagerId(userDto.getId());
			cstCustomerQueryDTO.setCustStatus("1");
			svrCustomerList=this.cstCustomerService.getAllCstCustomer(cstCustomerQueryDTO);
			return "toDetailAddCstServicePage";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}


	
	
	public String addCstServiceByManager(){
		try {
			cstServiceDTO.setSvrCustName(cstCustomerService.getById(cstServiceDTO.getSvrCustomerDTO().getId()).getCustName());
			this.cstServiceService.createCstServiceByManager(cstServiceDTO);
			this.getRequest().put("responseText", "服务已成功创建");
			return "toAddCstServicePage";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String toDispatchCstServicePage(){
		try {
			svrTypeList=this.basDictService.loadAllDictsByType("服务类型");
			svrStatusList=this.cstServiceService.getAllSvrStatus();
			svrManagerList=this.sysUserService.findManager();
			cstServiceQueryDTO.setSvrStatus("新创建");
			pageResult=this.cstServiceService.getByPaging(cstServiceQueryDTO);
			this.getRequest().put("queryCondition", cstServiceQueryDTO);
			return "toListDispatchCstServicePage";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String dispatchCstServiceBySale(){
		try{
			this.cstServiceService.dispatchCstServiceBySale(cstServiceDTO);
			return "toDispatchCstServicePage";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toDealCstServicePage(){
		try{
			svrTypeList=this.basDictService.loadAllDictsByType("服务类型");
			svrStatusList=this.cstServiceService.getAllSvrStatus();
			cstServiceQueryDTO.setSvrStatus("已分配");
			cstServiceQueryDTO.setSvrDueId(((SysUserDTO)this.getSession().get("userDto")).getId());
			pageResult=this.cstServiceService.getByPaging(cstServiceQueryDTO);
			this.getRequest().put("queryCondition", cstServiceQueryDTO);
			return "toListDealCstServicePage";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toDetailDealCstServicePage(){
		try{
			cstServiceDTO=this.cstServiceService.getById(cstServiceDTO.getId());
			return "toDetailDealCstServicePage";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String dealCstServiceByManager(){
		try{
			this.cstServiceService.dealCstServiceByManager(cstServiceDTO);
			return "toDealCstServicePage";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toFeedbackCstServicePage(){
		try{
			svrTypeList=this.basDictService.loadAllDictsByType("服务类型");
			svrStatusList=this.cstServiceService.getAllSvrStatus();
			cstServiceQueryDTO.setSvrStatus("已处理");
			pageResult=this.cstServiceService.getByPaging(cstServiceQueryDTO);
			this.getRequest().put("queryCondition", cstServiceQueryDTO);
			return "toListFeedbackCstServicePage";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toDetailFeedbackCstServicePage(){
		try{
			cstServiceDTO=this.cstServiceService.getById(cstServiceDTO.getId());
			return "toDetailFeedbackCstServicePage";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String feedbackCstServiceByManager(){
		try{
			this.cstServiceService.feedbackCstServiceByManager(cstServiceDTO);
			return "toFeedbackCstServicePage";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toArchCstServicePage(){
		try{
			svrTypeList=this.basDictService.loadAllDictsByType("服务类型");
			svrStatusList=this.cstServiceService.getAllSvrStatus();
			cstServiceQueryDTO.setSvrStatus("已归档");
			pageResult=this.cstServiceService.getByPaging(cstServiceQueryDTO);
			this.getRequest().put("queryCondition", cstServiceQueryDTO);
			return "toListArchCstServicePage";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toDetailArchCstServicePage(){
		try{
			cstServiceDTO=this.cstServiceService.getById(cstServiceDTO.getId());
			return "toDetailArchCstServicePage";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String removeCstServiceBySale(){
		try{
			this.cstServiceService.deleteCstServiceBySale(cstServiceDTO);
			return "toDispatchCstServicePage";
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@Override
	public CstServiceDTO getModel() {
		return cstServiceDTO;
	}
	
	
	
}
