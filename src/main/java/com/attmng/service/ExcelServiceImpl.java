package com.attmng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.dao.ExcelDAO;
import com.attmng.domain.ExcelToSaveAttendanceGetVo;
import com.attmng.dto.ExcelToSaveAttendanceGetDTO;

@Repository
public class ExcelServiceImpl implements ExcelService {

	@Autowired
	private ExcelDAO dao;

	@Override
	public List<ExcelToSaveAttendanceGetDTO> ExcelGET(String sessionID, String key_year_month) throws Exception {
		// TODO Auto-generated method stub
		return dao.ExcelGet(sessionID, key_year_month);
	}
}
