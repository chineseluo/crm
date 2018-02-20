package org.jb.crm.basd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jb.common.bean.Page;
import org.jb.common.service.BaseService;
import org.jb.crm.basd.dao.IOrdersDao;
import org.jb.crm.basd.domain.Orders;
import org.jb.crm.basd.dto.OrdersDTO;
import org.jb.crm.basd.dto.OrdersQueryDTO;
import org.jb.crm.basd.service.IOrdersService;
import org.jb.crm.rept.dto.InstantCustomer;
import org.jb.crm.rept.dto.InstantCustomerQueryDTO;

public class OrdersServiceImpl extends BaseService implements IOrdersService {

private IOrdersDao ordersDao;
	
	public void setOrdersDao(IOrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	@Override
	public OrdersDTO getById(Long id){
		Orders orders=ordersDao.getById(id);
		OrdersDTO ordersDTO= new OrdersDTO();
		this.getMapper().map(orders,ordersDTO);
		return ordersDTO;
	}
	
	@Override
	public void saveOrders(OrdersDTO ordersDTO) {
		Orders orders=new Orders();
		this.getMapper().map(ordersDTO,orders);
		ordersDao.save(orders);
	}
	
	@Override
	public void updateOrders(OrdersDTO ordersDTO) {
		Orders orders=new Orders();
		this.getMapper().map(ordersDTO,orders);
		ordersDao.update(orders);
	}
	
	@Override
	public void deleteOrders(OrdersDTO ordersDTO) {
		Orders orders=this.ordersDao.getById(ordersDTO.getId());
		ordersDao.delete(orders);
	}

	@Override
	public Page<OrdersDTO> getByCondition(OrdersQueryDTO ordersQueryDTO) {
		Page<Orders> pageResult=ordersDao.getByCondition(ordersQueryDTO);
		List<Orders> resultList = pageResult.getList();
		List<OrdersDTO> dtoList = new ArrayList<OrdersDTO>();
		
		for(int i = 0 ; i < resultList.size() ; i ++){
			OrdersDTO dto = new OrdersDTO();
			this.getMapper().map(resultList.get(i), dto);
			dtoList.add(dto);
		}
		
		return new Page<OrdersDTO>(pageResult.getCurrentPage(),pageResult.getPageSize(),dtoList,pageResult.getRecTotal());
	}

}
