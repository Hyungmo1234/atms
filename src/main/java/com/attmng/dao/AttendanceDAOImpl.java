package com.attmng.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<AttendanceVO> AttendanceGET(String sessionID, String month, int deleteFlag) throws Exception {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		
		paraMap.put("id", sessionID);
		paraMap.put("month", month);
		paraMap.put("flag", deleteFlag);
		
		return sqlSession.selectList(namespace + ".getAttendanceInfo", paraMap);
	}
	
	@Override
	public void AttendanceUpdate(String sessionID, String month, String day, int deleteFlag) throws Exception {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		
		String formatOfDatetime = format.format (System.currentTimeMillis());
		
		paraMap.put("id", sessionID);
		paraMap.put("month", month);
		paraMap.put("day", day);
		paraMap.put("flag", deleteFlag);
		paraMap.put("upd_id", sessionID);
		paraMap.put("upd_date", formatOfDatetime);
		
		sqlSession.update(namespace + ".attendanceUpdate", paraMap);
	}
	
	
	/*
	 * @Override public List<AttendanceVO> ExcelGet(String sessionID, String date)
	 * throws Exception {
	 * 
	 * return sqlSession.selectList(namespace + ".getExcelInfo", sessionID); }
	 */
}
