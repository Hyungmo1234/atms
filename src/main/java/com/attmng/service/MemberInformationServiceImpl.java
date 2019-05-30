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
		
		// 占쎌뜏占쎌뒗野껊돍�삕野껋�⑥칮�뜝�룞�삕野껊〃易곩뜝�룞�삕野껊돍�삕野껊〕�삕�뤃�떣�삕野껊���삕椰꾩떣�삕鈺곌퍜�삕�뵳占썲뜝�럡荑귛뜝�럡�뀣�뜝�럡占썲뜝�럡�떖
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
