package com.attmng.service;

import java.util.List;

import com.attmng.domain.AttendanceVO;
import com.attmng.dto.AttendanceDTO;

public interface AttendanceService {
	
	public AttendanceVO AttendancePOST(AttendanceDTO dto) throws Exception;

	public List<AttendanceVO> AttendanceGET(String sessionID, String month, int deleteFlag) throws Exception;
	
	public void AttendanceUpdate(String sessionID, String month, String day, int deleteFlag) throws Exception;
	//public List<AttendanceVO> ExcelGet(String sessionID, String date) throws Exception;
}
