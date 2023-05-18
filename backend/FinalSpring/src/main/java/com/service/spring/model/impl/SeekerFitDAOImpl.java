package com.service.spring.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.SeekerFitVO;
import com.service.spring.model.SeekerFitDAO;

@Repository
public class SeekerFitDAOImpl implements SeekerFitDAO{
	public static final String NS = "SeekerFitMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int registerSeekerFit(SeekerFitVO seekerFit) {
		return sqlSession.insert(NS + "registerSeekerFit", seekerFit);
	}

	@Override
	public int deleteSeekerFit(int fitId) {
		return sqlSession.delete(NS + "deleteSeekerFit", fitId);
	}

	@Override
	public int updateSeekerFit(SeekerFitVO seekerFit) {
		return sqlSession.update(NS + "updateSeekerFit", seekerFit);
	}

	@Override
	public SeekerFitVO getSeekerFit(int id) {
		return sqlSession.selectOne(NS + "getSeekerFit", id);
	}
	

}
