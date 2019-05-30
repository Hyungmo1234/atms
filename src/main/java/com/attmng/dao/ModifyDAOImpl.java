package com.attmng.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.domain.EmployeeVO;
import com.attmng.domain.JoinVO;

@Repository
public class ModifyDAOImpl implements ModifyDAO {

	private static final String namespace = "com.attmng.atms.mappers.employee";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void modifyPOST(EmployeeVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(vo.getCellphone());
		sqlSession.update(namespace + ".Modify", vo);
	}

	@Override
	public EmployeeVO EmpData(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".empList", id);
	}

}