package org.jb.crm.basd.service;

import org.jb.common.bean.Page;
import org.jb.crm.basd.dto.ProductDTO;
import org.jb.crm.basd.dto.ProductQueryDTO;

public interface IProductService {

	public Page<ProductDTO> loadAllProductByPage(ProductQueryDTO productQueryDTO);

	public Page<ProductDTO> findProductAndStorageByPage(ProductQueryDTO productQueryDTO);

}
