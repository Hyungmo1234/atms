package com.attmng.dao;
import java.util.List;

import org.springframework.stereotype.Service;

import com.attmng.domain.ExcelToSaveAttendanceGetVo;
import com.attmng.dto.ExcelToSaveAttendanceGetDTO;

@Service
public interface ExcelDAO {
	public List<ExcelToSaveAttendanceGetDTO> ExcelGet(String sessionID, String key_year_month) throws Exception;
}