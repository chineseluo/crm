package org.jb.crm.basd.action;

import org.jb.common.action.BaseAction;
import org.jb.common.bean.Page;
import org.jb.crm.basd.dto.ProductDTO;
import org.jb.crm.basd.dto.ProductQueryDTO;
import org.jb.crm.basd.service.IProductService;

public class ProductAction extends BaseAction {
	private IProductService productService;
	private ProductQueryDTO productQueryDTO = new ProductQueryDTO();
	private ProductDTO productDTO = new ProductDTO();
 	
	
	public String loadAllProductByPage(){
		try {
			Page<ProductDTO> pageResult = this.productService.loadAllProductByPage(productQueryDTO);
			this.getRequest().put("pageResult", pageResult);
			this.getRequest().put("queryCondition", productQueryDTO);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	public String findProductAndStorageByPage(){
		
		try {		
			Page<ProductDTO> pageResult = this.productService.findProductAndStorageByPage(productQueryDTO);
			this.getRequest().put("pageResult", pageResult);
			this.getRequest().put("queryCondition", productQueryDTO);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;	
		}
	}
	
	
	
	
	

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public ProductQueryDTO getProductQueryDTO() {
		return productQueryDTO;
	}

	public void setProductQueryDTO(ProductQueryDTO productQueryDTO) {
		this.productQueryDTO = productQueryDTO;
	}





	public ProductDTO getProductDTO() {
		return productDTO;
	}





	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

}
