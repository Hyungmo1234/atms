package com.attmng.dao;

import java.util.List;
import java.util.Map;

import com.attmng.dto.MemberAttendanceDTO;
import com.attmng.dto.MemberInformationDTO;

public interface MemberInformationDAO {
	public List<MemberInformationDTO> getMembersInfo(String Adm_code, String ComName_ryak) throws Exception;
	public List<MemberInformationDTO> getMemberInfo(String name) throws Exception;
	public List<MemberAttendanceDTO> getMemberAttendance(Map<String, Object> sqlData) throws Exception;
}
