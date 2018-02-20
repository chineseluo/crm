package org.jb.crm.basd.dao;

import java.util.List;

import org.jb.common.bean.Page;
import org.jb.common.dao.IBaseDAO;
import org.jb.crm.basd.domain.Orders;
import org.jb.crm.basd.dto.OrdersQueryDTO;
import org.jb.crm.rept.dto.InstantCustomer;
import org.jb.crm.rept.dto.InstantCustomerQueryDTO;

public interface IOrdersDao extends IBaseDAO<Long, Orders>{
	public Page<Orders> getByCondition(OrdersQueryDTO ordersQueryDTO);
}
