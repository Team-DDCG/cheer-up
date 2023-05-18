package com.service.spring.service;

import com.service.spring.domain.FitVO;

public interface FitService {
	int registerFit(FitVO vo) throws Exception;
	int updateFit(FitVO vo) throws Exception;
	int deleteFit(int fitId) throws Exception;
	FitVO getFit(int seekerId) throws Exception;
}
