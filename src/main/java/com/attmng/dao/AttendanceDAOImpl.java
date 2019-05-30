package com.attmng.dao;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	public void AttendanceUpdate(String sessionID, String month, String day, int deleteFlag, String[] tempArray) throws Exception {
		Map<String, Object> paraMap = new HashMap<String, Object>();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String formatOfDatetime = format.format(System.currentTimeMillis());
		
		/*
		 * dto.setS_time(request.getParameter("in_hour"+i + "in_minute"+i));
		 * dto.setE_time(request.getParameter("out_hour"+i + "out_minute"+i));
		 * dto.setOp_time(Double.parseDouble(request.getParameter("op_time"+i)));
		 * dto.setBr_time(Double.parseDouble(request.getParameter("br_time"+i)));
		 * dto.setWco_name(request.getParameter("w_list"+i));
		 * dto.setNotice(request.getParameter("notice"+i));
		 * dto.setRemarks(request.getParameter("remark"+i));
		 */
		//	where part
		paraMap.put("id", sessionID);
		paraMap.put("month", month);
		paraMap.put("day", day);
		paraMap.put("flag", deleteFlag);
		
		
		/*
		 * dto.setS_time(tempArray[1] + ":" + tempArray[2]); dto.setE_time(tempArray[3]
		 * + ":" + tempArray[4]); dto.setWco_name(tempArray[5]);
		 * dto.setBr_time(Double.parseDouble(tempArray[6]));
		 * dto.setNotice(tempArray[7]); dto.setRemarks(tempArray[8]);
		 * dto.setOp_time(Double.parseDouble(tempArray[9]));
		 */
		//	update part
		paraMap.put("s_time", tempArray[1] + ":" + tempArray[2]);
		paraMap.put("e_time", tempArray[3] + ":" + tempArray[4]);
		double opt =
				(((Double.parseDouble(tempArray[3])*60) + Double.parseDouble(tempArray[4])) -
				((Double.parseDouble(tempArray[1])*60) + Double.parseDouble(tempArray[2])) -
				Double.parseDouble(tempArray[7]))/60;
		paraMap.put("op_time", opt);
		paraMap.put("wco_name", tempArray[6]);
		paraMap.put("br_time", Double.parseDouble(tempArray[7]));
		paraMap.put("notice", tempArray[8]);
		paraMap.put("remarks", tempArray[9]);
		paraMap.put("upd_id", sessionID);
		paraMap.put("upd_date", formatOfDatetime);

		sqlSession.update(namespace + ".attendanceUpdate", paraMap);
	}

	@Override
	public void AttendanceInput(String sessionID, String yearMonth) throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String formatOfDatetime = format.format(System.currentTimeMillis());

		Date now = new Date();
		int year = now.getYear() + 1900;
		int month = now.getMonth() + 1;
		Calendar cal = Calendar.getInstance(); //new GregorianCalendar(year, month, 1);
		int data = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		String temp = null;
		
		for (int i = 1; i <= data; i++) {
			Map<String, Object> paraMap = new HashMap<String, Object>();

			temp = i + "";
			
			if(i < 10) {
				temp = "0" + i;
			}
			
			paraMap.put("id", sessionID);
			paraMap.put("yearMonth", yearMonth);
			paraMap.put("day", temp);
			paraMap.put("flag", 0);
			paraMap.put("reg_date", formatOfDatetime);
			paraMap.put("reg_id", sessionID);
			paraMap.put("defTimeFormat", "00:00");
			paraMap.put("defDoubleFormat", "0");
			paraMap.put("defVarcharFormat", "");

			sqlSession.insert(namespace + ".attendanceInsert", paraMap);
			
		}
	};

	/*
	 * @Override public List<AttendanceVO> ExcelGet(String sessionID, String date)
	 * throws Exception {
	 * 
	 * return sqlSession.selectList(namespace + ".getExcelInfo", sessionID); }
	 */
}
