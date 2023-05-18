package com.service.spring.service.impl;

import java.util.List;

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
	public Category2VO read(int category2Id) throws Exception {
		return category2DAO.read(category2Id);
	}

	@Override
	public List<Category2VO> listAll() throws Exception {
		return category2DAO.listAll();
	}

	@Override
	public List<Category2VO> findAllCompanyByName(String keyword) throws Exception {
		return category2DAO.findAllCompanyByName(keyword);
	}

}
