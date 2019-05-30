package com.attmng.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.domain.EmployeeVO;
import com.attmng.domain.JoinVO;

@Repository
public class JoinDAOImpl implements JoinDAO {

	private static final String namespace = "com.attmng.atms.mappers.employee";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void JoinPOST(JoinVO vo) throws Exception {
		//
		sqlSession.insert(namespace + ".JoinPOST", vo);

	}

	@Override
	public List<EmployeeVO> EmployeeGET(String vo) throws Exception {

		return sqlSession.selectList(namespace + ".DepartmentInfo", vo);
	}

	public List<JoinVO> JoinGET(String com_code) throws Exception {
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("com_code", com_code);
		
		System.out.println(parameter.toString());
		
		return sqlSession.selectList(namespace + ".JoinGET", parameter);
	}
	
	public List<JoinVO> Idcheck(String id) throws Exception{
		
		return sqlSession.selectList(namespace + ".Idcheck", id);
		
	}
}