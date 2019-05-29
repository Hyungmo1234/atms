package com.attmng.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.domain.JoinVO;

@Repository
public class JoinDAOImpl implements JoinDAO {

	
	private static final String namespace = "com.attmng.atms.mappers.employee";

	@Autowired
	private SqlSession sqlSession;
	
    @Override
    public void JoinPOST(JoinVO vo) throws Exception{
    	//
    	sqlSession.insert(namespace+".JoinPOST",vo);
    
    }
}