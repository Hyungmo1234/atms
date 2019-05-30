package com.attmng.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.dto.MemberPasswordChangeDTO;

@Repository
public class MemberPasswordChangeDAOImpl implements MemberPasswordChangeDAO{
	
	@Autowired
	   private SqlSession sqlSession;
	   
	   private static final String namespace = "com.attmng.atms.mappers.memberPasswordChange";

	@Override
	public MemberPasswordChangeDTO User_read(MemberPasswordChangeDTO dto) throws Exception {
		
		return sqlSession.selectOne(namespace+".User_read", dto.getId());
	}

	@Override
	public void G05_Update(String id, String password) throws Exception {
		HashMap<String, String> paraMap = new HashMap<String, String>();
		
		paraMap.put("id", id);
	    paraMap.put("password", password);
	    
	    sqlSession.update(namespace + ".G05_Update", paraMap);
	}

	

}
