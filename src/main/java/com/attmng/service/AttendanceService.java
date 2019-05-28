package com.attmng.service;

import java.util.List;

import com.attmng.domain.AttendanceVO;
import com.attmng.dto.AttendanceDTO;

public interface AttendanceService {
	
	public AttendanceVO AttendancePOST(AttendanceDTO dto) throws Exception;

	public List<AttendanceVO> AttendanceGET(String sessionID) throws Exception;
	
	//public List<AttendanceVO> ExcelGet(String sessionID, String date) throws Exception;
}