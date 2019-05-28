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
	
	@RequestMapping(value = "/G00-1", method = RequestMethod.POST)
	public String LoginPOST(Model model, HttpServletResponse response,EmployeeDTO dto,HttpSession session) throws Exception {
		
		try {
			EmployeeVO vo = service.LoginPOST(dto);
			if (vo.getPassword().equals(dto.getPassword())) {
				//로그인 정보세션
				session.setAttribute("Logininfo", vo);
				// login 성공시 게시물리스트를 출력해주기위한 model객체 
				return "G00-1";
			} else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('password failed'); </script>");
				out.flush();
				return "G01";
			}
		} catch (NullPointerException e) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('id Null'); </script>");
			out.flush();
			return "G01";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    //메소드 이름은 LOGOUT 매게 변수는 SESSION
    public String logout(HttpSession session) {
        //m으로 선언된 세션을 삭제시킨다.
        session.removeAttribute("Logininfo");
        // /페이지로 리다이렉트 시킨다.
        return "redirect:/";
    }
}
