package org.jb.crm.sys.domain;

import java.util.HashSet;
import java.util.Set;

import org.jb.common.domain.BaseDomain;

/**
 * 权限实体
 * 
 * @author william
 * 
 */
public class SysRight extends BaseDomain {

	private String rightText;
	private String rightUrl;

	private SysRight parent;

	private Set<SysRight> children = new HashSet<SysRight>();

	public String getRightText() {
		return rightText;
	}

	public void setRightText(String rightText) {
		this.rightText = rightText;
	}

	public String getRightUrl() {
		return rightUrl;
	}

	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	public SysRight getParent() {
		return parent;
	}

	public void setParent(SysRight parent) {
		this.parent = parent;
	}

	public Set<SysRight> getChildren() {
		return children;
	}

	public void setChildren(Set<SysRight> children) {
		this.children = children;
	}

}
