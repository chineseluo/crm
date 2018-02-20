package org.jb.crm.basd.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.jb.common.bean.Page;
import org.jb.common.service.BaseService;
import org.jb.crm.basd.dao.IBasDictDao;
import org.jb.crm.basd.domain.BasDict;
import org.jb.crm.basd.dto.BasDictDTO;
import org.jb.crm.basd.dto.BasDictQueryDTO;
import org.jb.crm.basd.service.IBasDictService;

public class BasDictServiceImpl extends BaseService implements IBasDictService{
		private IBasDictDao basDictDao ;
		
		@Override
		public void saveBasDict(BasDictDTO basDictDTO) {
			BasDict basDict = new BasDict() ;
			this.getMapper().map(basDictDTO,basDict);
			this.basDictDao.save(basDict);
			
		}
		
		@Override
		public void deleteBasDict(BasDictDTO basDictDTO) {
			BasDict basDict = new BasDict();
			this.getMapper().map(basDictDTO, basDict);
			this.basDictDao.delete(basDict);
		}
		
		@Override
		public void changeBasDict(BasDictDTO basDictDTO) {
			BasDict basDict = new BasDict();
			this.getMapper().map(basDictDTO, basDict);
			this.basDictDao.update(basDict);		
		}

		public void setBasDictDao(IBasDictDao basDictDao) {
			this.basDictDao = basDictDao;
		}
		
		@Override
		public Page<BasDictDTO> loadAllBasDictsByPagging(BasDictQueryDTO basDictQueryDTO) {
			Page<BasDict> pageResult = this.basDictDao.getByCondition(basDictQueryDTO);
			List<BasDictDTO> dtoList = new ArrayList<BasDictDTO>();
			for(int i = 0 ; i < pageResult.getList().size() ; i ++){
				BasDictDTO dto = new BasDictDTO() ;
				this.getMapper().map(pageResult.getList().get(i), dto);
				dtoList.add(dto);				
			}
			return new Page<BasDictDTO>(pageResult.getCurrentPage(), pageResult.getPageSize(),dtoList, pageResult.getRecTotal());
		}


		@Override
		public BasDictDTO loadBasDictById(BasDictQueryDTO basDictQueryDTO) {
			BasDict dict = this.basDictDao.getById(basDictQueryDTO.getId());
			BasDictDTO dto = new BasDictDTO();
			this.getMapper().map(dict, dto);
			return dto;
		}
		
		@Override
		public List<BasDictDTO> loadAllDictsByType(String dictType) {
			List<BasDict> basDicts = this.basDictDao.getByDictType(dictType);
			List<BasDictDTO> dtoList = new ArrayList<BasDictDTO>();
			for(int i = 0 ; i < basDicts.size() ; i ++){
				BasDictDTO dto = new BasDictDTO() ;
				this.getMapper().map(basDicts.get(i), dto);
				dtoList.add(dto);				
			}
			return dtoList;
		}
		
		@Override
		public List<String> loadAllDictTypeByTip(String dictType) {
			return this.basDictDao.getDictTypeByTip(dictType);
		}
}
