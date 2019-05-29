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
		//　例外処理必要　！！！　ユザーの権限確認
		
		//　クエリを実行してデータをもらう
		List<MemberInformationDTO> membersData = MemInfoService.getMembersInformation();
		
		//　データを追加する
		model.addAttribute("membersData", membersData);
		
		//　画面に移動
		return "G00-2";
	}
	
	/*
	 * ２．管理者_社員情報照会
	 */
	@RequestMapping(value="/G10", method = RequestMethod.GET)
	public String Admin_get_MembersInformation(Model model) throws Exception {
		
		//　クエリを実行してデータをもらう
		List<MemberInformationDTO> membersData = MemInfoService.getMembersInformation();
		
		//　例外処理必要　！！！　データがない場合
		
		//　データを追加する
		model.addAttribute("membersData", membersData);
		
		//　画面に移動
		return "G10";
	}
	
	/*
	 * ３．管理者_社員別詳細情報照会
	 */
	@RequestMapping(value="/G10/G11", method = RequestMethod.POST)
	public String Admin_get_MemberInformation(HttpServletRequest request, Model model) throws Exception {
		//　パラメータ、NAMEをもらう
		String name = request.getParameter("name");
		
		//　クエリを実行してデータをもらう
		List<MemberInformationDTO> memberData = MemInfoService.getMemberInformation(name);
		
		//　例外処理必要　！！！データがない場合
		
		//　データを追加する
		model.addAttribute("memberData", memberData.get(0));
		
		//　画面に移動
		return "G11";
	}
	
	/*
	 * 4．管理者_社員別勤怠情報照会
	 */
	@RequestMapping(value="/G10/G12", method = RequestMethod.POST)
	public String Admin_get_commuteInformation(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		 
		//
		MemInfoService.getMemberAttendanceData(request, session, model);
		
		return "G12";
	}
	
}