package com.attmng.controller;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attmng.domain.EmployeeVO;
import com.attmng.dto.EmployeeDTO;
import com.attmng.service.LoginService;



@Controller
public class LoginController {
	
	@Autowired
    private LoginService service;
	
	@RequestMapping(value = "/LoginPOST", method = RequestMethod.POST)
	public String LoginPOST(Model model, HttpServletResponse response,EmployeeDTO dto,HttpSession session) throws Exception {
		
		try {
			EmployeeVO vo = service.LoginPOST(dto);
			if (vo.getPassword().equals(dto.getPassword())) {
				//로그인 정보세션
				session.setAttribute("Logininfo", vo);
				// login 성공시 게시물리스트를 출력해주기위한 model객체 
				return "main_login";
			} else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('password failed'); </script>");
				out.flush();
				return "login";
			}
		} catch (NullPointerException e) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('id Null'); </script>");
			out.flush();
			return "login";
		}
	}
}
