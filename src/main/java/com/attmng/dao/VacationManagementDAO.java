package com.attmng.dao;

import java.util.List;
import java.util.Map;

import com.attmng.domain.VacationManagementVO;

public interface VacationManagementDAO {
	public int Save(List<Map<String, Object>> vacationScheduleListMap) throws Exception;

	public Map<String, List<VacationManagementVO>> selectInfo(Map<String, String> info);
}
