package com.service.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Category1VO;
import com.service.spring.model.Category1DAO;
import com.service.spring.service.Category1Service;

@Service
public class Category1ServiceImpl implements Category1Service{
	
	@Autowired
	private Category1DAO category1DAO;

	@Override
	public Category1VO read(int category1Id) throws Exception {
		return category1DAO.read(category1Id);
	}

	@Override
	public List<Category1VO> listAll() throws Exception {
		return category1DAO.listAll();
	}


}
