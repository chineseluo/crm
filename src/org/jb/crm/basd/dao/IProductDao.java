package org.jb.crm.basd.dao;

import org.jb.common.bean.Page;
import org.jb.common.dao.IBaseDAO;
import org.jb.crm.basd.domain.Product;
import org.jb.crm.basd.dto.ProductQueryDTO;

public interface IProductDao extends IBaseDAO<Long, Product>{

	Page<Product> loadAllProductByPage(ProductQueryDTO productQueryDTO);

	public Page<Product> findProductAndStorageByPage(ProductQueryDTO productQueryDTO);

}
