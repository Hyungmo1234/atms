package com.attmng.controller;

/* 嶸←릤�끻릲�걨�겗�깪�꺖�궦�궠�꺍�깉�꺆�꺖�꺀�꺖
 * 鵝쒏닇�낉폏NCB 兩됥궩�깢�궊�꺍
 * ��永귞랬�썓�뿥竊�2019/05/28
 * 
 * �궠�꺍�깉�꺆�꺖�꺀�꺖�깄�젿
 * 竊묕펿嶸←릤�끹깳�궎�꺍�뵽�씊
 * 竊믭펿嶸←릤��_鹽얍뱻�깄�젿�뀱鴉�
 * 竊볩펿嶸←릤��_鹽얍뱻�닪屋녕눗�깄�젿�뀱鴉�
 * 竊뷂펿嶸←릤��_鹽얍뱻�닪�떎�졿깄�젿�뀱鴉�
 */

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.attmng.domain.EmployeeVO;
import com.attmng.dto.MemberInformationDTO;
import com.attmng.service.MemberInformationService;


// @Auth
@Controller
public class MemberInformationController {	
	
	
	@Inject
	MemberInformationService MemInfoService;
	

	// all month data
	@RequestMapping("/G06-2")
	public ModelAndView alldata(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		
		//
		MemInfoService.getUserAttendanceData(request, session, model);
		
		return new ModelAndView("G12");
	}
	
	
	/*
	 * 竊믭펿嶸←릤��_鹽얍뱻�깄�젿�뀱鴉�
	 */
	@RequestMapping(value="/G10", method = RequestMethod.GET)
	public String Admin_get_MembersInformation(Model model, HttpSession session) throws Exception {
		EmployeeVO vo = (EmployeeVO) session.getAttribute("Logininfo");
		//���궚�궓�꺁�굮若잒죱�걮�겍�깈�꺖�궭�굮�굚�굢�걝
		List<MemberInformationDTO> membersData = MemInfoService.getMembersInformation(vo.getAdm_code(), vo.getComName_ryak());
		
		//��堊뗥쨼�눇�릤恙낁쫨��竊곻펯竊곥���깈�꺖�궭�걣�겒�걚�졃�릦
		
		//���깈�꺖�궭�굮瓦썲뒥�걲�굥
		model.addAttribute("membersData", membersData);
		
		//���뵽�씊�겓燁삣땿
		return "G10";
	}
	
	/*
	 * 竊볩펿嶸←릤��_鹽얍뱻�닪屋녕눗�깄�젿�뀱鴉�
	 */
	@RequestMapping(value="/G11", method = RequestMethod.POST)
	public String Admin_get_MemberInformation(HttpServletRequest request, Model model) throws Exception {
		//���깙�꺀�깳�꺖�궭�갢AME�굮�굚�굢�걝
		String name = request.getParameter("name");
		
		//���궚�궓�꺁�굮若잒죱�걮�겍�깈�꺖�궭�굮�굚�굢�걝
		List<MemberInformationDTO> memberData = MemInfoService.getMemberInformation(name);
		
		//��堊뗥쨼�눇�릤恙낁쫨��竊곻펯竊곥깈�꺖�궭�걣�겒�걚�졃�릦
		
		//���깈�꺖�궭�굮瓦썲뒥�걲�굥
		model.addAttribute("memberData", memberData.get(0));
		
		//���뵽�씊�겓燁삣땿
		return "G11";
	}
	
	/*
	 * 4竊롧�←릤��_鹽얍뱻�닪�떎�졿깄�젿�뀱鴉�
	 */
	@RequestMapping(value="/G12", method = RequestMethod.POST)
	public String Admin_get_commuteInformation(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		 
		//
		MemInfoService.getMemberAttendanceData(request, session, model);
		
		return "G12";
	}
	
}