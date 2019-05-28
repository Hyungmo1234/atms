package com.attmng.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.attmng.dto.MemberInfomationDTO;
import com.attmng.service.MemberInfomationService;


// @Auth
@Controller
@RequestMapping(value="/member")
public class MemberInformationController {	
	
	@Inject
	MemberInfomationService MemInfoService;
	
	// 
	@RequestMapping(value="", method = RequestMethod.GET)
	public ModelAndView getMembersInfomation(Model model) throws Exception {
		
		List<MemberInfomationDTO> membersData = MemInfoService.getMembersInfomation();
		
		model.addAttribute("membersData", membersData);
		
		return new ModelAndView("members_infomation");
	}
	
	
	@RequestMapping(value="/info", method = RequestMethod.POST)
	public ModelAndView getMemberInfomation(HttpServletRequest request, Model model) throws Exception {
		
		String name = request.getParameter("name");
		
		List<MemberInfomationDTO> memberData = MemInfoService.getMemberInfomation(name);
		model.addAttribute("memberData", memberData.get(0));
		
		return new ModelAndView("member_infomation");
	}
	
	// return new ModelAndView("login");
	/*
	 * // public void board_main(HttpSession session, Model model)
	 * throws Exception { 
	 * List<boardBean> boardList =
	 * boardService.getBoardList(); model.addAttribute("boardList", boardList); }
	 * 
	 * // 
	 * @RequestMapping(value="writing", method = RequestMethod.POST) public String
	 * writing(HttpSession session) throws Exception {
	 * 
	 * return "board_writing"; }
	 * 
	 * // 
	 * @RequestMapping("/update")
	 * 
	 * @ResponseBody public Map<String,Object> updatePosts(HttpServletRequest
	 * request, HttpSession session) throws Exception { String boardNum =
	 * request.getParameter("boardNum"); String title =
	 * request.getParameter("title"); String content =
	 * request.getParameter("content");
	 * 
	 * Map<String, Object> param = new HashMap<String, Object>(); param.put("title",
	 * title); param.put("content", content);
	 * 
	 * String sessionId = (String) session.getAttribute("userId");
	 * 
	 * return boardService.udtPosts(boardNum, param, sessionId); }
	 */
	
}