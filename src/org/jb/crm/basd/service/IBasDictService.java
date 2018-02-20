package org.jb.crm.basd.service;

import java.util.List;

import org.jb.common.bean.Page;
import org.jb.crm.basd.dto.BasDictDTO;
import org.jb.crm.basd.dto.BasDictQueryDTO;

public interface IBasDictService {


	public void saveBasDict(BasDictDTO basDictDTO);

	public void deleteBasDict(BasDictDTO basDictDTO);

	public void changeBasDict(BasDictDTO basDictDTO);

	public Page<BasDictDTO> loadAllBasDictsByPagging(BasDictQueryDTO basDictQueryDTO);

	public BasDictDTO loadBasDictById(BasDictQueryDTO basDictQueryDTO);

	public List<BasDictDTO> loadAllDictsByType(String dictType);

	public List<String> loadAllDictTypeByTip(String dictType);

}
