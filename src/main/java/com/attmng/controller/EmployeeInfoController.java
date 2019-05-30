package com.attmng.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attmng.domain.EmployeeVO;
import com.attmng.dto.EmployeeInfoDTO;
import com.attmng.service.EmployeeInfoService;

@Controller
public class EmployeeInfoController {
	
	@Autowired
	private EmployeeInfoService service;

	
	@RequestMapping(value = "/G03")
	public String test(Model model, HttpServletResponse response, EmployeeInfoDTO dto,HttpSession session) throws Exception {
		
		try {
			EmployeeVO loginUser = (EmployeeVO)session.getAttribute("Logininfo");
			dto.setId(loginUser.getId());
			
			model.addAttribute("listAll", service.User_read(dto));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		 model.addAttribute("LoginPOST",service.LoginPOST());
		
		return "G03";
	}

}
