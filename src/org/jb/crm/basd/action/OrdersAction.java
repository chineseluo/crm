package org.jb.crm.basd.action;

import org.jb.common.action.BaseAction;
import org.jb.common.bean.Page;
import org.jb.crm.basd.dto.OrdersDTO;
import org.jb.crm.basd.dto.OrdersQueryDTO;
import org.jb.crm.basd.service.IOrdersService;
import org.jb.crm.cus.dto.CstCustomerDTO;
import org.jb.crm.cus.service.ICstCustomerService;

import com.opensymphony.xwork2.ModelDriven;

public class OrdersAction extends BaseAction implements ModelDriven<OrdersDTO> {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private IOrdersService ordersService;

	public void setOrdersService(IOrdersService ordersService) {
		this.ordersService = ordersService;
	}

	private OrdersDTO ordersDTO = new OrdersDTO();

	private OrdersQueryDTO ordersQueryDTO = new OrdersQueryDTO();

	public OrdersQueryDTO getOrdersQueryDTO() {
		return ordersQueryDTO;
	}

	public void setOrdersQueryDTO(OrdersQueryDTO ordersQueryDTO) {
		this.ordersQueryDTO = ordersQueryDTO;
	}

	private CstCustomerDTO cstCustomer;

	public CstCustomerDTO getCstCustomer() {
		return cstCustomer;
	}


	private ICstCustomerService cstCustomerService;

	public void setCstCustomerService(ICstCustomerService cstCustomerService) {
		this.cstCustomerService = cstCustomerService;
	}

	
	public String loadAllOrders() {
		try {
			String custName=ordersQueryDTO.getOdrCustomer();
			ordersQueryDTO.setOdrCustomer(new String(custName.getBytes("ISO-8859-1"),"UTF-8"));
			Page<OrdersDTO> pageResult = this.ordersService.getByCondition(ordersQueryDTO);
			cstCustomer = cstCustomerService.getByCustName(ordersQueryDTO.getOdrCustomer());
			this.getRequest().put("pageResult", pageResult);
			ordersQueryDTO.setOdrCustomer(custName);
			this.getRequest().put("queryCondition", ordersQueryDTO);
			return "toListOrdersPage";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}
	
	public String loadOrdersById() {
		try {
			ordersDTO = this.ordersService.getById(ordersQueryDTO.getId());
			return "toOrdersDetailPage";
		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}
	}

	@Override
	public OrdersDTO getModel() {
		return ordersDTO;
	}

}
