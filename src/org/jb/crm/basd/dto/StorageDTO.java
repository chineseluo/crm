/**
 * @author cai
 * */


package org.jb.crm.basd.dto;


import java.util.HashSet;
import java.util.Set;
import org.jb.common.dto.BaseDTO;

public class StorageDTO extends BaseDTO {
	private String stkWarehouse;
	private String  stkWare;
	private Integer stkCount;
	private String  stkMemo;



	public String getStkWarehouse() {
		return stkWarehouse;
	}
	
	public void setStkWarehouse(String stkWarehouse) {
		this.stkWarehouse = stkWarehouse;
	}

	public String getStkWare() {
		return stkWare;
	}

	public void setStkWare(String stkWare) {
		this.stkWare = stkWare;
	}

	public Integer getStkCount() {
		return stkCount;
	}

	public void setStkCount(Integer stkCount) {
		this.stkCount = stkCount;
	}

	public String getStkMemo() {
		return stkMemo;
	}

	public void setStkMemo(String stkMemo) {
		this.stkMemo = stkMemo;
	}

	

}
