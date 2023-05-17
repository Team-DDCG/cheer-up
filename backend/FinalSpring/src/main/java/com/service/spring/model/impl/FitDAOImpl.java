package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.FitVO;
import com.service.spring.model.FitDAO;

@Repository
public class FitDAOImpl implements FitDAO {

	public static final String NS = "CompanyMapper.";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int registerFit(FitVO vo) throws Exception {
		return sqlSession.insert(NS+"registerFit", vo);
	}

	@Override
	public int updateFit(FitVO vo) throws Exception {
		return sqlSession.update(NS+"updateFit", vo);
	}

	@Override
	public int deleteFit(int fitId) throws Exception {
		return sqlSession.delete(NS+"deleteFit", fitId);
	}

}
