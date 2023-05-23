package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.SeekerFitVO;

public interface SeekerFitService {
	int registerSeekerFit(SeekerFitVO seekerFit);
    int deleteSeekerFit(int fitId);
    int updateSeekerFit(SeekerFitVO seekerFit);
    List<SeekerFitVO> getSeekerFit(int id);
}
