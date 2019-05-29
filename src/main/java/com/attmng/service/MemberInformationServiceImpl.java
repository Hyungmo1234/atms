package com.attmng.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.attmng.dao.MemberInformationDAO;
import com.attmng.dto.MemberAttendanceDTO;
import com.attmng.dto.MemberInformationDTO;

@Service
public class MemberInformationServiceImpl implements MemberInformationService{

	@Autowired
	MemberInformationDAO MemberInformationDAO;
	
	@Override
	public List<MemberInformationDTO> getMembersInformation(String Adm_code, String ComName_ryak) throws Exception {
		// TODO Auto-generated method stub
		return MemberInformationDAO.getMembersInfo(Adm_code, ComName_ryak);
	}

	@Override
	public List<MemberInformationDTO> getMemberInformation(String name) throws Exception {
		// TODO Auto-generated method stub
		return MemberInformationDAO.getMemberInfo(name);
	}

	@Override
	public List<MemberAttendanceDTO> getMemberAttendanceData(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		//
		String id = request.getParameter("id");
		
		String year = null;
		year = request.getParameter("year");
		
		String month = null; 
		month = request.getParameter("month");
		
		
		//
		Date time = new Date();
		
		// 雅뚣겇�겗訝��겎訝��겇�겎�굚�겒�걚�졃�릦�겘�궓�꺀�꺖
		if(year == null || month == null) {
			SimpleDateFormat SimDateYear = new SimpleDateFormat ("yyyy");
			String DateYear = SimDateYear.format(time);
			year = DateYear;
			
			SimpleDateFormat SimDateMonth = new SimpleDateFormat ("MM");
			String DateMonth = SimDateMonth.format(time);
			month = DateMonth;
		}
		
		//
		String year_month = year + month;
		
		//
		Map<String, Object> sqlData = new HashMap();
		sqlData.put("id", id);
		sqlData.put("year_month", year_month);
		
		//
		List<MemberAttendanceDTO> attendanceData = MemberInformationDAO.getMemberAttendance(sqlData);
		model.addAttribute("attendanceData", attendanceData);
		
		//
		model.addAttribute("id", id);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		
		
		// session
		// session.removeAttribute("attendanceMember_Id");
		// session.setAttribute("attendanceMember_Id", id);
		
		return null;
	}

	

}
