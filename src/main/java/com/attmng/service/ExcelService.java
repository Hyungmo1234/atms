package com.attmng.service;

import java.util.List;

import com.attmng.domain.ExcelToSaveAttendanceGetVo;
import com.attmng.dto.ExcelToSaveAttendanceGetDTO;

public interface ExcelService {
	
	public List<ExcelToSaveAttendanceGetDTO> ExcelGET(String sessionID, String key_year_month) throws Exception;
}
