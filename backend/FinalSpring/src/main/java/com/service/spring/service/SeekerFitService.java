package com.service.spring.service;

import com.service.spring.domain.SeekerFitVO;

public interface SeekerFitService {
	int registerSeekerFit(SeekerFitVO seekerFit);
    int deleteSeekerFit(int fitId);
    int updateSeekerFit(SeekerFitVO seekerFit);
    SeekerFitVO getSeekerFit(int id);
}
