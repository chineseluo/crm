package org.jb.crm.cus.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.jb.common.bean.Page;
import org.jb.common.service.BaseService;
import org.jb.crm.cus.dao.ICstCustomerDao;
import org.jb.crm.cus.dao.ICstLostDao;
import org.jb.crm.cus.domain.CstCustomer;
import org.jb.crm.cus.domain.CstLost;
import org.jb.crm.cus.dto.CstLostDTO;
import org.jb.crm.cus.dto.CstLostQueryDTO;
import org.jb.crm.cus.service.ICstLostService;

public class CstLostServiceImpl extends BaseService implements ICstLostService {

	private ICstLostDao cstLostDao;

	public void setCstLostDao(ICstLostDao cstLostDao) {
		this.cstLostDao = cstLostDao;
	}

	private ICstCustomerDao cstCustomerDao;

	public void setCstCustomerDao(ICstCustomerDao cstCustomerDao) {
		this.cstCustomerDao = cstCustomerDao;
	}

	@Override
	public Page<CstLostDTO> getByPaging(CstLostQueryDTO cstLostQueryDTO) {
		Page<CstLost> pageResult = cstLostDao.getByCondition(cstLostQueryDTO);
		List<CstLost> resultList = pageResult.getList();
		List<CstLostDTO> dtoList = new ArrayList<CstLostDTO>();

		for (int i = 0; i < resultList.size(); i++) {
			CstLostDTO dto = new CstLostDTO();
			this.getMapper().map(resultList.get(i), dto);
			dtoList.add(dto);
		}

		return new Page<CstLostDTO>(pageResult.getCurrentPage(), pageResult.getPageSize(), dtoList, pageResult.getRecTotal());
	}

	@Override
	public void generatePreWarningCstLost() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -6);
		//cstLostDao.deleteExtras(calendar.getTime(), new Date());
		List<CstCustomer> cstCustomerList = this.cstCustomerDao.getNotOrderCustomers(calendar.getTime(), new Date());
		for (CstCustomer cstCustomer : cstCustomerList) {
			boolean flag=true;
			for(CstLost cstLost:cstCustomer.getCstLosts()){
				Date lastestOrderDate=cstCustomerDao.getLastestOrderDateById(cstCustomer.getId());
				if(lastestOrderDate==null || !cstLost.getLstLastOrderDate().before(lastestOrderDate)){
					flag=false;
					break;
				}
			}
			if(flag){
				CstLost cstLost = new CstLost();
				cstLost.setLstCustomer(cstCustomer);
				cstLost.setLstCustName(cstCustomer.getCustName());
				cstLost.setLstCustManagerName(cstCustomer.getCustManagerName());
				cstLost.setLstCustManager(cstCustomer.getCustManager());
				cstLost.setLstLastOrderDate(cstCustomerDao.getLastestOrderDateById(cstCustomer.getId()));
				cstLost.setLstStatus("1");
				cstLostDao.save(cstLost);
			}

		}

	}

	@Override
	public CstLostDTO getById(Long id) {
		CstLost cstLost = cstLostDao.getById(id);
		CstLostDTO cstLostDTO = new CstLostDTO();
		this.getMapper().map(cstLost, cstLostDTO);
		return cstLostDTO;
	}

	@Override
	public void modifyPutoffCstLost(CstLostDTO cstLostDTO) {
		CstLost cstLost = this.cstLostDao.getById(cstLostDTO.getId());
		if (cstLostDTO.getLstDelay() != null && !cstLostDTO.getLstDelay().trim().equals(""))
			if (cstLost.getLstDelay() != null && !cstLost.getLstDelay().trim().equals("") && !cstLost.getLstDelay().trim().equals("null"))
				cstLost.setLstDelay(cstLost.getLstDelay() + "<br/>" + cstLostDTO.getLstDelay());
			else
				cstLost.setLstDelay(cstLostDTO.getLstDelay());
		if (cstLost.getLstCustomer().getCustStatus().equals("2"))// 流失状态必须修改为正常状态
			cstLost.getLstCustomer().setCustStatus("1");
		cstLost.setLstStatus(cstLostDTO.getLstStatus());
	}

	@Override
	public void confirmPutoffCstLost(CstLostDTO cstLostDTO) {
		CstLost cstLost = this.cstLostDao.getById(cstLostDTO.getId());
		cstLost.setLstReason(cstLostDTO.getLstReason());
		cstLost.setLstLostDate(cstLostDTO.getLstLostDate());
		cstLost.setLstStatus("3");
		if (!cstLost.getLstCustomer().getCustStatus().equals("3"))// 删除状态不必修改为流失状态
			cstLost.getLstCustomer().setCustStatus("2");
		cstLostDao.update(cstLost);
	}
	

}
