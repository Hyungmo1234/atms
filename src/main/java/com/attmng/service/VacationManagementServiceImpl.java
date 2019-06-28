package com.attmng.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attmng.dao.VacationManagementDAO;
import com.attmng.domain.VacationManagementVO;

@Service
public class VacationManagementServiceImpl implements VacationManagementService {

	@Autowired
	private VacationManagementDAO dao;
	
	@Override
	public int Save(List<Map<String, Object>> vacationScheduleListMap) throws Exception {
		return dao.Save(vacationScheduleListMap);
	}
	
	@Override
	public Map<String, List<VacationManagementVO>> selectInfo(Map<String, String> info) throws Exception {
		return dao.selectInfo(info);
	}
}
