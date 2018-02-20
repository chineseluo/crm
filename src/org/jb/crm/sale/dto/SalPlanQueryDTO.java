package org.jb.crm.sale.dto;

public class SalPlanQueryDTO {
	private String optionType;
	private Long id;
	private	String plaToDo;
	private String plaResult;

	public String getPlaResult() {
		return plaResult;
	}

	public void setPlaResult(String plaResult) {
		this.plaResult = plaResult;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaToDo() {
		return plaToDo;
	}

	public void setPlaToDo(String plaToDo) {
		this.plaToDo = plaToDo;
	}

}
