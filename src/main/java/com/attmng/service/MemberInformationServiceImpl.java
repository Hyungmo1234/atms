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
		
		// �썒�슔寃뉛옙寃쀨쯁占쏙옙寃롨쯁占쏙옙寃뉛옙寃롳옙援싷옙寃믭옙嫄싷옙議껓옙由�占쎄쿂占쎄텚占쎄�占쎄틬
		if(year == null || month == null) {
			SimpleDateFormat SimDateYear = new SimpleDateFormat ("yyyy");
			String DateYear = SimDateYear.format(time);
			year = DateYear;
			
			SimpleDateFormat SimDateMonth = new SimpleDateFormat ("MM");
			String DateMonth = SimDateMonth.format(time);
			month = DateMonth;
		}
		
		if(month.length() < 2) {
			month = "0" + month;
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
		
		return null;
	}

	

}
