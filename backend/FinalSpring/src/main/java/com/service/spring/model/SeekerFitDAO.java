package com.service.spring.model;

import com.service.spring.domain.SeekerFitVO;

public interface SeekerFitDAO {
	int registerSeekerFit(SeekerFitVO seekerFit);
    int deleteSeekerFit(int fitId);
    int updateSeekerFit(SeekerFitVO seekerFit);
    SeekerFitVO getSeekerFit(int id);
}
