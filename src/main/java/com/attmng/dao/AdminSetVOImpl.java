package com.attmng.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.domain.AdminSetVO;

@Repository
public class AdminSetVOImpl implements AdminSetDAO {
	private static final String namespace = "com.attmng.atms.mappers.adminSet";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<AdminSetVO> AdminList() throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList(namespace+ ".adminList");
	}

}
