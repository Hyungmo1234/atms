package com.attmng.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.attmng.domain.AttendanceVO;
import com.attmng.dto.AttendanceDTO;

@Service
public interface AttendanceDAO {
	public AttendanceVO AttendancePOST(AttendanceDTO dto) throws Exception;
	public List<AttendanceVO> AttendanceGET(String sessionID, String month, int deleteFlag) throws Exception;
	public void AttendanceUpdate(String sessionID, String month, String day, int deleteFlag) throws Exception;
	
	//データが存在しない場合、勤怠テーブルにデータ追加
	public void AttendanceInput(String sessionID, String month) throws Exception;
	//public List<AttendanceVO> ExcelGet(String sessionID, String date) throws Exception;
}
