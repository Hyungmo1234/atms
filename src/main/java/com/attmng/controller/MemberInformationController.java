package com.attmng.controller;

/* 管理者向けのページコントローラー
 * 作成者：NCB 廉セファン
 * 最終編集日：2019/05/28
 * 
 * コントローラー情報
 * １．管理者メイン画面
 * ２．管理者_社員情報照会
 * ３．管理者_社員別詳細情報照会
 * ４．管理者_社員別勤怠情報照会
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

import com.attmng.dto.MemberInformationDTO;
import com.attmng.service.MemberInformationService;


// @Auth
@Controller
@RequestMapping(value="/G00-2")
public class MemberInformationController {	
	
	
	@Inject
	MemberInformationService MemInfoService;
	
	/*
	 * １．管理者メイン画面
	 */
	@RequestMapping(value="", method = RequestMethod.GET)
	public String Admin_Main(Model model) throws Exception {
		
		List<MemberInformationDTO> membersData = MemInfoService.getMembersInformation();
		model.addAttribute("membersData", membersData);
		
		return "G00-2";
	}
	
	/*
	 * ２．管理者_社員情報照会
	 */
	@RequestMapping(value="/G10", method = RequestMethod.GET)
	public String Admin_get_MembersInformation(Model model) throws Exception {
		
		List<MemberInformationDTO> membersData = MemInfoService.getMembersInformation();
		model.addAttribute("membersData", membersData);
		
		return "G10";
	}
	
	/*
	 * ３．管理者_社員別詳細情報照会
	 */
	@RequestMapping(value="/G10/G11", method = RequestMethod.POST)
	public String Admin_get_MemberInformation(HttpServletRequest request, Model model) throws Exception {
		
		String name = request.getParameter("name");
		
		List<MemberInformationDTO> memberData = MemInfoService.getMemberInformation(name);
		model.addAttribute("memberData", memberData.get(0));
		
		return "G11";
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