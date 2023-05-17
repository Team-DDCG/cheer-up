package com.service.spring.model;

import com.service.spring.domain.FitVO;

public interface FitDAO {

	int registerFit(FitVO vo) throws Exception;
	int updateFit(FitVO vo) throws Exception;
	int deleteFit(int fitId) throws Exception;
}
