package com.service.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.SeekerFitVO;
import com.service.spring.model.SeekerFitDAO;
import com.service.spring.service.SeekerFitService;

@Service
public class SeekerFitServiceImpl implements SeekerFitService{
	
	@Autowired
	private SeekerFitDAO seekerFitDAO;

	@Override
	public int registerSeekerFit(SeekerFitVO seekerFit) {
		return seekerFitDAO.registerSeekerFit(seekerFit);
	}

	@Override
	public int deleteSeekerFit(int fitId) {
		return seekerFitDAO.deleteSeekerFit(fitId);
	}

	@Override
	public int updateSeekerFit(SeekerFitVO seekerFit) {
		return seekerFitDAO.updateSeekerFit(seekerFit);
	}

	@Override
	public SeekerFitVO getSeekerFit(int id) {
		return seekerFitDAO.getSeekerFit(id);
	}

}
