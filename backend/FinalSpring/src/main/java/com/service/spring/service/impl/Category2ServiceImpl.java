package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Category2VO;
import com.service.spring.model.Category2DAO;
import com.service.spring.service.Category2Service;

@Service
public class Category2ServiceImpl implements Category2Service{
	
	@Autowired
	private Category2DAO category2DAO;

	@Override
	public int registerCategory2(Category2VO vo) throws Exception {
		return category2DAO.registerCategory2(vo);
	}

	@Override
	public int updateCategory2(Category2VO vo) throws Exception {
		return category2DAO.updateCategory2(vo);
	}

	@Override
	public int deleteCategory2(int category2Id) throws Exception {
		return category2DAO.deleteCategory2(category2Id);
	}
	
	

}
