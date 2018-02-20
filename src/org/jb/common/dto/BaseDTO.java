package org.jb.common.dto;

import java.util.Date;

/**
 *  µÃÂ∏∏¿‡
 * 
 * @author william
 * 
 */
public class BaseDTO {

	private Long id;
	
	private Date lastOperatorTime = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLastOperatorTime() {
		return lastOperatorTime;
	}

	public void setLastOperatorTime(Date lastOperatorTime) {
		this.lastOperatorTime = lastOperatorTime;
	}

	
}
