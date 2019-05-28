package com.attmng.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.domain.AttendanceVO;
import com.attmng.dto.AttendanceDTO;

@Repository
public class AttendanceDAOImpl implements AttendanceDAO {
	
	private static final String namespace = "com.attmng.atms.mappers.attendance";

	@Autowired
	private SqlSession sqlSession;
	/*
	 * @Override public List getLoginInfo() throws Exception { // TODO
	 * Auto-generated method stub
	 * 
	 * System.out.println(sqlSession.selectList(namespace + ".getLoginInfo"));
	 * return null; }
	 */

	@Override
	public AttendanceVO AttendancePOST(AttendanceDTO dto) throws Exception {

		return sqlSession.selectOne(namespace + ".getAttendanceInfo", dto.getId());
	}
	
	@Override
	public List<AttendanceVO> AttendanceGET(String sessionID) throws Exception {

		return sqlSession.selectList(namespace + ".getAttendanceInfo", sessionID);
	}
	
	@Override
	public List<AttendanceVO> ExcelGet(String sessionID, String date) throws Exception {

		return sqlSession.selectList(namespace + ".getExcelInfo", sessionID);
	}
}
