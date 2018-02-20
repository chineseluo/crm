package org.jb.crm.sys.dto;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;
import org.jb.common.dto.BaseDTO;

/**
 * 权限实体
 * 
 * @author william
 * 
 */
public class SysRightDTO extends BaseDTO {

	private String rightText;
	private String rightUrl;

	private SysRightDTO parent;

	private Set<SysRightDTO> children = new HashSet<SysRightDTO>();

	private Integer checkState = 0;
	
	private Boolean isExpand = false;
	
	
	
	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}

	@JSON(name="isexpand")
	public Boolean getIsExpand() {
		return isExpand;
	}

	public void setIsExpand(Boolean isExpand) {
		this.isExpand = isExpand;
	}

	@JSON(name="text")
	public String getRightText() {
		return rightText;
	}

	public void setRightText(String rightText) {
		this.rightText = rightText;
	}

	@JSON(name="value")
	public String getRightUrl() {
		return rightUrl;
	}

	@JSON(name="showcheck")
	public Boolean getShowCheck(){
		return true;
	}
	
	@JSON(name="checkstate")
	public Integer getCheckState(){
		return this.checkState;
	}
	
	@JSON(name="hasChildren")
	public Boolean getHasChildren(){
		return this.children.size() >0 ;
	}
	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	public SysRightDTO getParent() {
		return parent;
	}

	public void setParent(SysRightDTO parent) {
		this.parent = parent;
	}

	@JSON(name="ChildNodes")
	public Set<SysRightDTO> getChildren() {
		return children;
	}

	public void setChildren(Set<SysRightDTO> children) {
		this.children = children;
	}

}
