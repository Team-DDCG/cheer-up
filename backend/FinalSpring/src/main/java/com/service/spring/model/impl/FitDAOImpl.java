package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.service.spring.domain.FitVO;
import com.service.spring.model.FitDAO;

public class FitDAOImpl implements FitDAO {

	public static final String NS = "CompanyMapper.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerFit(FitVO vo) throws Exception {
		int result = sqlSession.insert(NS+"registerFit", vo);
		return result;
	}

	@Override
	public int updateFit(FitVO vo) throws Exception {
		int result = sqlSession.update(NS+"updateFit", vo);
		return result;
	}

	@Override
	public int deleteFit(int fitId) throws Exception {
		int result = sqlSession.delete(NS+"deleteFit", fitId);
		return result;
	}

}
