package org.jb.crm.basd.service;

import java.util.List;

import org.jb.common.bean.Page;
import org.jb.crm.basd.dto.OrdersDTO;
import org.jb.crm.basd.dto.OrdersQueryDTO;
import org.jb.crm.rept.dto.InstantCustomer;
import org.jb.crm.rept.dto.InstantCustomerQueryDTO;

public interface IOrdersService {
	public void saveOrders(OrdersDTO ordersDTO);
	public Page<OrdersDTO> getByCondition(OrdersQueryDTO ordersQueryDTO);
	public void updateOrders(OrdersDTO ordersDTO);
	public OrdersDTO getById(Long id);
	public void deleteOrders(OrdersDTO ordersDTO);

}
