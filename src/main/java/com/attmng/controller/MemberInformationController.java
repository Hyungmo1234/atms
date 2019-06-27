package com.attmng.controller;

import java.util.HashMap;

/* 蒻멤넀由ㅿ옙�겭由뀐옙嫄⑨옙寃쀯옙源わ옙爰뽳옙沅�占쎄텭占쎄틡占쎄퉱占쎄틙占쎄틬占쎄�占쎄틬
 * 俑앹뮀�땱占쎈굢�룒NCB 畑몃맓沅⑼옙源�占쎄텏占쎄틡
 * 占쏙옙麗멸퇍�옱占쎌뜐占쎈엠塋딉옙2019/05/28
 * 
 * 占쎄텭占쎄틡占쎄퉱占쎄틙占쎄틬占쎄�占쎄틬占쎄퉬占쎌졒
 * 塋딅쵓�렲蒻멤넀由ㅿ옙�겧源놂옙沅롳옙爰랃옙逾쏙옙�뵄
 * 塋딅���렲蒻멤넀由ㅿ옙占�_埇쎌뼃諭삼옙源꾬옙�졒占쎈�깁큺占�
 * 塋딅낑�렲蒻멤넀由ㅿ옙占�_埇쎌뼃諭삼옙�떔掠뗫뀞�닓占쎄퉬占쎌졒占쎈�깁큺占�
 * 塋딅톪�렲蒻멤넀由ㅿ옙占�_埇쎌뼃諭삼옙�떔占쎈뼄占쎌×源꾬옙�졒占쎈�깁큺占�
 */

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.attmng.domain.EmployeeVO;
import com.attmng.domain.JoinVO;
import com.attmng.dto.MemberInformationDTO;
import com.attmng.service.JoinService;
import com.attmng.service.MemberInformationService;


// @Auth
@Controller
public class MemberInformationController {	
	
	
	@Inject
	MemberInformationService MemInfoService;
	
	@Autowired
	private JoinService joinService;

	// all month data
	@RequestMapping("/G06-2")
	public ModelAndView alldata(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		
		//
		MemInfoService.getUserAttendanceData(request, session, model);
		
		return new ModelAndView("G12");
	}
	
	
	/*
	 * 塋딅���렲蒻멤넀由ㅿ옙占�_埇쎌뼃諭삼옙源꾬옙�졒占쎈�깁큺占�
	 */
	@RequestMapping(value="/G00-2/G10", method = RequestMethod.GET)
	public String Admin_get_MembersInformation(Model model, HttpSession session) throws Exception {
		EmployeeVO vo = (EmployeeVO) session.getAttribute("Logininfo");
		//占쏙옙占쎄텥占쎄텚占쎄틒占쎄뎌畑댁옊二깍옙嫄�占쎄쾷占쎄퉰占쎄틬占쎄땟占쎄뎌占쎄탾占쎄덩占쎄콨
		List<MemberInformationDTO> membersData = MemInfoService.getMembersInformation(vo.getAdm_code(), vo.getComName_ryak());
		
		//占쏙옙�젇�뿥夷쇽옙�늾占쎈┐�걲�굙已⑨옙占썹쳥怨삵렞塋딄낄占쏙옙占쎄퉰占쎄틬占쎄땟占쎄괏占쎄쾼占쎄콢占쎌죨占쎈└
		
		//占쏙옙占쎄퉰占쎄틬占쎄땟占쎄뎌�벀�뜴�뮙占쎄굉占쎄데
		model.addAttribute("membersData", membersData);
		
		//占쏙옙占쎈돕占쎌뵄占쎄쾽�뇖�궍�빣
		return "G10";
	}
	
	/*
	 * 塋딅낑�렲蒻멤넀由ㅿ옙占�_埇쎌뼃諭삼옙�떔掠뗫뀞�닓占쎄퉬占쎌졒占쎈�깁큺占�
	 */
	@RequestMapping(value="/G00-2/G10/G11", method = RequestMethod.POST)
	public String Admin_get_MemberInformation(HttpServletRequest request, Model model) throws Exception {
		//占쏙옙占쎄튃占쎄�占쎄뭄占쎄틬占쎄땟占쎄각AME占쎄뎌占쎄탾占쎄덩占쎄콨
		String name = request.getParameter("name");
		
		//占쏙옙占쎄텥占쎄텚占쎄틒占쎄뎌畑댁옊二깍옙嫄�占쎄쾷占쎄퉰占쎄틬占쎄땟占쎄뎌占쎄탾占쎄덩占쎄콨
		List<MemberInformationDTO> memberData = MemInfoService.getMemberInformation(name);
		
		//占쏙옙�젇�뿥夷쇽옙�늾占쎈┐�걲�굙已⑨옙占썹쳥怨삵렞塋딄낄源덌옙爰뽳옙沅�占쎄괏占쎄쾼占쎄콢占쎌죨占쎈└
		
		//占쏙옙占쎄퉰占쎄틬占쎄땟占쎄뎌�벀�뜴�뮙占쎄굉占쎄데
		model.addAttribute("memberData", memberData.get(0));
		
		//占쏙옙占쎈돕占쎌뵄占쎄쾽�뇖�궍�빣
		return "G11";
	}
	
	/*
	 * 4塋딅¨占썩넀由ㅿ옙占�_埇쎌뼃諭삼옙�떔占쎈뼄占쎌×源꾬옙�졒占쎈�깁큺占�
	 */
	@RequestMapping(value="/G00-2/G10/G12", method = RequestMethod.POST)
	public String Admin_get_commuteInformation(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		 
		//
		MemInfoService.getMemberAttendanceData(request, session, model);
		
		return "G12";
	}
	
	@RequestMapping(value="/test", method = RequestMethod.POST)
	public String test(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		String testa = request.getParameter("com_code1");
		String testb = request.getParameter("dep_areaHidden");
		String testc = request.getParameter("pos_code");
		String testd = request.getParameter("search");
	
		Map<String, Object> tempMap = new HashMap<String, Object>();
		
		tempMap.put("testa", testa);
		tempMap.put("testb", testb);
		tempMap.put("testc", testc);
		tempMap.put("testd", testd);
		
		
		
		EmployeeVO vo = (EmployeeVO) session.getAttribute("Logininfo");
		//占쏙옙占쎄텥占쎄텚占쎄틒占쎄뎌畑댁옊二깍옙嫄�占쎄쾷占쎄퉰占쎄틬占쎄땟占쎄뎌占쎄탾占쎄덩占쎄콨
		List<MemberInformationDTO> membersData = MemInfoService.getMembersInformation2(vo.getAdm_code(), vo.getComName_ryak(), tempMap);
		
		//model.addAttribute("JoinGET2", joinService.JoinGET(testa));
		model.addAttribute("com_code1", testa);
		model.addAttribute("dep_areaHidden", testb);
		model.addAttribute("JoinGET2", joinService.JoinGET(testa));
		model.addAttribute("pos_code", testc);
		model.addAttribute("search", testd);
		
		//占쏙옙�젇�뿥夷쇽옙�늾占쎈┐�걲�굙已⑨옙占썹쳥怨삵렞塋딄낄占쏙옙占쎄퉰占쎄틬占쎄땟占쎄괏占쎄쾼占쎄콢占쎌죨占쎈└
		
		//占쏙옙占쎄퉰占쎄틬占쎄땟占쎄뎌�벀�뜴�뮙占쎄굉占쎄데
		model.addAttribute("membersData", membersData);
		
		return "G10";
	}

}