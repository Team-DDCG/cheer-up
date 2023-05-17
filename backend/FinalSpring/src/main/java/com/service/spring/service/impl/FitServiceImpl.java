package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.FitVO;
import com.service.spring.model.FitDAO;
import com.service.spring.service.FitService;

@Service
public class FitServiceImpl implements FitService{
	
	@Autowired
	private FitDAO fitDAO;

	@Override
	public int registerFit(FitVO vo) throws Exception {
		return fitDAO.registerFit(vo);
	}

	@Override
	public int updateFit(FitVO vo) throws Exception {
		return fitDAO.updateFit(vo);
	}

	@Override
	public int deleteFit(int fitId) throws Exception {
		return fitDAO.deleteFit(fitId);
	}

}
