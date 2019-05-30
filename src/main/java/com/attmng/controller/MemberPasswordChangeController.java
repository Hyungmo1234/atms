package com.attmng.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attmng.domain.EmployeeVO;
import com.attmng.dto.MemberPasswordChangeDTO;
import com.attmng.service.MemberPasswordChangeService;

@Controller
public class MemberPasswordChangeController {
	
	@Autowired
	   private MemberPasswordChangeService service;
	
	@RequestMapping(value = "/G05")
	   public String G05_main(Model model, MemberPasswordChangeDTO dto,HttpSession session) throws Exception {
	      
	      try {
			
	         session.getAttribute("Logininfo");
          
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      
	      return "G05";
	   }
	
	@RequestMapping(value = "/G05/pw_change")
		public String G05_pwchange(Model model, MemberPasswordChangeDTO dto, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception{
			
		
			try {
				
				//1.�뿢耶섅깙�궧�꺈�꺖�깋�겏�뀯�뒟�걮�걼�깙�궧�꺈�꺖�깋閻븃첀
				 EmployeeVO loginUser = (EmployeeVO)session.getAttribute("Logininfo");
		         dto.setPassword(loginUser.getPassword());
		         dto.setId(loginUser.getId());
		         
				String pw = request.getParameter("pw");
				String new_pw = request.getParameter("new_pw");
				String re_new_pw = request.getParameter("re_new_pw");
				if (pw!=null) {
					if (new_pw!=null) {
						if(re_new_pw!=null) {
							if(pw.equals(dto.getPassword())) {
								if (new_pw.equals(re_new_pw)) {
									if(pw.equals(new_pw)){
										response.setContentType("text/html; charset=utf-8");
										PrintWriter out = response.getWriter();
										out.println("<script>alert('既存パスワードと違うようにしてください。');location.href='/G05'; </script>");
										out.flush();
									}else {
										
										response.setContentType("text/html; charset=utf-8");
										PrintWriter out = response.getWriter();
										out.println("<script>alert('変更したした。');location.href='/G03'; </script>");
										out.flush();
										System.out.println(new_pw);
										service.G05_Update(dto.getId(), new_pw);
									}
								}else {
									response.setContentType("text/html; charset=utf-8");
									PrintWriter out = response.getWriter();
									out.println("<script>alert('変更するパスワードと不一致します。');location.href='/G05'; </script>");
									out.flush();
								}
							}else {
								response.setContentType("text/html; charset=utf-8");
								PrintWriter out = response.getWriter();
								out.println("<script>alert('既存パスワードが違います。');location.href='/G05'; </script>");
								out.flush();
								
							}
						}else {
							response.setContentType("text/html; charset=utf-8");
							PrintWriter out = response.getWriter();
							out.println("<script>alert('変更するパスワードチェックを入力してください。');location.href='/G05'; </script>");
							out.flush();
						}
					}else {
						response.setContentType("text/html; charset=utf-8");
						PrintWriter out = response.getWriter();
						out.println("<script>alert('変更するパスワードを入力してください。');location.href='/G05'; </script>");
						out.flush();
					}
				}else {
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('既存パスワードを入力してください。');location.href='/G05'; </script>");
					out.flush();
				}
				
				
			} catch (Exception e) {
				
			}

		
		return "G03";
		
	}

}