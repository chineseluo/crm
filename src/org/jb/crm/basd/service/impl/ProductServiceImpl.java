package org.jb.crm.basd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jb.common.bean.Page;
import org.jb.common.service.BaseService;
import org.jb.crm.basd.dao.IProductDao;
import org.jb.crm.basd.domain.Product;
import org.jb.crm.basd.dto.ProductDTO;
import org.jb.crm.basd.dto.ProductQueryDTO;
import org.jb.crm.basd.service.IProductService;


public class ProductServiceImpl extends BaseService implements IProductService{
	private IProductDao productDao;

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Page<ProductDTO> loadAllProductByPage(ProductQueryDTO productQueryDTO) {
		Page<Product> pageBean = this.productDao.loadAllProductByPage(productQueryDTO);
		List<ProductDTO> listDto = new ArrayList<ProductDTO>();
		List<Product> listProduct = pageBean.getList();
		for (int i = 0; i < listProduct.size(); i++) {
			ProductDTO productDTO = new ProductDTO();
			this.getMapper().map(listProduct.get(i), productDTO);
			listDto.add(productDTO);
		}	
		return new Page<ProductDTO>(pageBean.getCurrentPage(),pageBean.getPageSize(),listDto,pageBean.getRecTotal());
	}

	@Override
	public Page<ProductDTO> findProductAndStorageByPage(ProductQueryDTO productQueryDTO) {
		Page<Product> pageBean = this.productDao.findProductAndStorageByPage(productQueryDTO);
		List<ProductDTO> listDto = new ArrayList<ProductDTO>();
		List<Product> listProduct = pageBean.getList();
		for (int i = 0; i < listProduct.size(); i++) {
			ProductDTO productDTO = new ProductDTO();
			this.getMapper().map(listProduct.get(i), productDTO);
			listDto.add(productDTO);
		}	
		return new Page<ProductDTO>(pageBean.getCurrentPage(),pageBean.getPageSize(),listDto,pageBean.getRecTotal());
	}
	

}
