package org.jb.crm.basd.action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.jb.common.action.BaseAction;
import org.jb.common.bean.Page;
import org.jb.crm.basd.dto.BasDictDTO;
import org.jb.crm.basd.dto.BasDictQueryDTO;
import org.jb.crm.basd.service.IBasDictService;

public class BasDictAction extends BaseAction {
	private IBasDictService basDictService;
	private BasDictDTO basDictDTO = new BasDictDTO();
	private BasDictQueryDTO basDictQueryDTO = new BasDictQueryDTO();

	public String saveBasDict() {
		try {
			this.basDictService.saveBasDict(basDictDTO);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String loadBasDictById() {
		try {
			BasDictDTO dto = this.basDictService.loadBasDictById(basDictQueryDTO);
			this.getRequest().put("dictDTO", dto);
			if (null == this.getParameters().get("oper")) {
				basDictDTO = dto;
				return SUCCESS;
			} else {
				String oper = this.getParameters().get("oper")[0];
				return oper;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	private List<String> dictTypeList;
	
	@JSON
	public List<String> getDictTypeList() {
		return dictTypeList;
	}

	public void setDictTypeList(List<String> dictTypeList) {
		this.dictTypeList = dictTypeList;
	}

	public String loadDictTypeByTip() {
		try {
			dictTypeList= this.basDictService.loadAllDictTypeByTip(basDictQueryDTO.getDictType());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String deteleBasDict() {
		try {
			this.basDictService.deleteBasDict(basDictDTO);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String changeBasDict() {
		try {
			this.basDictService.changeBasDict(basDictDTO);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String loadAllBasDicts() {
		try {
			Page<BasDictDTO> pageResult = this.basDictService.loadAllBasDictsByPagging(basDictQueryDTO);
			this.getRequest().put("pageResult", pageResult);
			this.getRequest().put("queryCondition", basDictQueryDTO);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public void setBasDictService(IBasDictService basDictService) {
		this.basDictService = basDictService;
	}

	public BasDictDTO getBasDictDTO() {
		return basDictDTO;
	}

	public void setBasDictDTO(BasDictDTO basDictDTO) {
		this.basDictDTO = basDictDTO;
	}

	public BasDictQueryDTO getBasDictQueryDTO() {
		return basDictQueryDTO;
	}

	public void setBasDictQueryDTO(BasDictQueryDTO basDictQueryDTO) {
		this.basDictQueryDTO = basDictQueryDTO;
	}

}
