package com.attmng.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.attmng.dto.MemberAttendanceDTO;
import com.attmng.dto.MemberInformationDTO;

public interface MemberInformationService {
	public List<MemberInformationDTO> getMembersInformation(String Adm_code, String ComName_ryak) throws Exception;
	public List<MemberInformationDTO> getMembersInformation2(String Adm_code, String ComName_ryak, Map<String, Object> tempMap) throws Exception;
	public List<MemberInformationDTO> getMemberInformation(String id) throws Exception;
	public List<MemberAttendanceDTO> getMemberAttendanceData(HttpServletRequest request, HttpSession session,  Model model) throws Exception;
	public List<MemberAttendanceDTO> getUserAttendanceData(HttpServletRequest request, HttpSession session,  Model model) throws Exception;
}
