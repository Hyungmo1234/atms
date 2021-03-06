package com.attmng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.dao.AttendanceDAO;
import com.attmng.domain.AttendanceVO;
import com.attmng.dto.AttendanceDTO;

@Repository
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceDAO dao;

	@Override
	public AttendanceVO AttendancePOST(AttendanceDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.AttendancePOST(dto);
	}

	@Override
	public List<AttendanceVO> AttendanceGET(String sessionID, String month, int deleteFlag) throws Exception {
		List<AttendanceVO> resultList = dao.AttendanceGET(sessionID, month, deleteFlag);
		
		if(resultList.size() == 0) {
			dao.AttendanceInput(sessionID, month);
		}
		
		return dao.AttendanceGET(sessionID, month, deleteFlag);
	}
	
	@Override
	public void AttendanceUpdate(String sessionID, String month, String day, int deleteFlag, String[] tempArray) throws Exception{
		dao.AttendanceUpdate(sessionID, month, day, deleteFlag, tempArray);
	}
	/*
	 * @Override public List<AttendanceVO> ExcelGet(String sessionID, String check)
	 * throws Exception { // TODO Auto-generated method stub return
	 * dao.ExcelGet(sessionID, check); }
	 */
}
