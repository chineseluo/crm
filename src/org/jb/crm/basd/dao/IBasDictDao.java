package org.jb.crm.basd.dao;


import java.util.List;

import org.jb.common.bean.Page;
import org.jb.common.dao.IBaseDAO;
import org.jb.crm.basd.domain.BasDict;
import org.jb.crm.basd.dto.BasDictQueryDTO;

public interface IBasDictDao extends IBaseDAO<Long, BasDict> {
	
	public Page<BasDict> getByCondition(BasDictQueryDTO basDictQueryDTO);

	public List<BasDict> getByDictType(String dictType);

	public List<String> getDictTypeByTip(String dictType);

	public List<String> loadCustLevelType();

}
