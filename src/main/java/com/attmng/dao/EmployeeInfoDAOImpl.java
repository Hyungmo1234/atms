package com.attmng.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.dto.EmployeeInfoDTO;

@Repository
	public class EmployeeInfoDAOImpl implements EmployeeInfoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.attmng.atms.mappers.employeeinfo";

	
	@Override
	public EmployeeInfoDTO User_read(EmployeeInfoDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".User_read", dto.getId());
	}
	
	
}
