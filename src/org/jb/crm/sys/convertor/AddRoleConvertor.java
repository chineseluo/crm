package org.jb.crm.sys.convertor;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.util.StrutsTypeConverter;
import org.jb.crm.sys.dto.SysRightDTO;

public class AddRoleConvertor extends StrutsTypeConverter {

	/**
	 * 从页面到后台
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String [] rightIds = values;
		Set<SysRightDTO> dtos = new HashSet<SysRightDTO>();
		for(int i = 0 ; i < rightIds.length ; i ++){
			SysRightDTO dto = new SysRightDTO();
			dto.setId(Long.parseLong(rightIds[i]));
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public String convertToString(Map context, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}
