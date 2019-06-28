package com.attmng.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.attmng.domain.EmployeeVO;
import com.attmng.domain.VacationManagementVO;
import com.attmng.service.VacationManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class VacationManagementController {

	@Autowired
	private VacationManagementService service;

	@RequestMapping(value = "/G13", method = RequestMethod.GET)
	public String VacationManagement(Model model, HttpServletResponse response, HttpSession session) throws Exception {
		Map<String,String> info = new HashMap<String,String>();
		
		info.put("id"       , "aaaa");
		info.put("yearmonth", "2025");
		
		Map<String, List<VacationManagementVO>> selectInfo = service.selectInfo(info);
		
		model.addAttribute("t_vacation_management"     , selectInfo.get("t_vacation_management"     ));
		model.addAttribute("t_vacation_holiday"        , selectInfo.get("t_vacation_holiday"        ));
		model.addAttribute("t_vacation_worktimecontrol", selectInfo.get("t_vacation_worktimecontrol"));
		
		return "G13";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/G13_1", method = RequestMethod.GET)
	public void Save(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam("vacationSchedule") String vacationSchedule) throws Exception {
		List<Map<String, Object>> vacationScheduleListMap = new ObjectMapper().readValue(vacationSchedule, ArrayList.class);
		
		// GET ID
//		String loginId = ((EmployeeVO) session.getAttribute("Logininfo")).getId();
		
		String loginId = "aaaa";
		
		// SET ID
		for(int i = 0; i < vacationScheduleListMap.size(); ++i) {
			vacationScheduleListMap.get(i).put("id", loginId);
		}
		
		int result = service.Save(vacationScheduleListMap);
		
		model.addAttribute("result", result);
	}
}
