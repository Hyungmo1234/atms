package com.attmng.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {
	private static final String namespace = "com.attmng.atms.mappers.employee";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public List getLoginInfo() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(sqlSession.selectList(namespace + ".getLoginInfo"));
		return null;
	}

}