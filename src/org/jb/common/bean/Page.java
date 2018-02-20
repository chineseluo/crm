package org.jb.common.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * ∑÷“≥Bean
 * @author william
 *
 */
public class Page<T> {

	private Integer currentPage = 1;
	private Integer pageSize = 10;
	private List<T> list = new ArrayList<T>();
	private Long recTotal = 0L;
	
	public Page() {
		super();
	}

	public Page(Integer currentPage, Integer pageSize, List<T> list,
			Long recTotal) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.list = list;
		this.recTotal = recTotal;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Long getRecTotal() {
		return recTotal;
	}

	public void setRecTotal(Long recTotal) {
		this.recTotal = recTotal;
	}

	public Long getTotalPage(){
		if(this.recTotal % this.pageSize == 0){
			return this.recTotal / this.pageSize; 
		}else{
			return this.recTotal / this.pageSize + 1;
		}
	}
}
