package com.attmng.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.attmng.domain.EmployeeVO;
import com.attmng.dto.EmployeeInfoDTO;
import com.attmng.service.EmployeeInfoService;
import com.attmng.service.modifyService;

/**
 * �뜝�럡萸붷뜝�럡�떖�뜝�럡�븗�뜝�럡源삣뜝�럡荑곩뜝�럡臾ュ뜝�럡�떖�뜝�럡�븢占쎈뇲占쎄텓占쎈묍
 * 
 * @author Use �뜝�럥鍮됮땡�끇�겮�뜝�럥援�占쎈짂�뜝�럩踰띸븨���뢾占쎌젢
 */
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	// login page
	@RequestMapping("/G01")
	public ModelAndView loginpage() throws Exception {
		logger.info("call login");
		return new ModelAndView("G01");
	}

	// after login main page
	@RequestMapping("/G00-0")
	public ModelAndView mainpage() {
		return new ModelAndView("G00-0");
	}

	// add member page

	@RequestMapping("/G02")
	public ModelAndView joinpage() {
		logger.info("call add member");

		return new ModelAndView("G02");
	}

	@Autowired
	private modifyService modifyService;

	// update member page
	@RequestMapping("/G04")
	public ModelAndView upadatemember(Model model, @RequestParam("id") String id) throws Exception {
		logger.info("call  upadate member");
		model.addAttribute("emp", modifyService.EmpData(id));
		return new ModelAndView("G04");
	}

	@Autowired
	private EmployeeInfoService service;

	@RequestMapping(value = "/modifyPost", method = RequestMethod.POST)
	public String Modify(@ModelAttribute EmployeeVO vo, Model model, HttpServletResponse response, EmployeeInfoDTO dto,
			HttpSession session) throws Exception {
		logger.info("modifyPOST");
		modifyService.modifyPOST(vo);
		EmployeeVO loginUser = (EmployeeVO) session.getAttribute("Logininfo");
		dto.setId(loginUser.getId());

		model.addAttribute("listAll", service.User_read(dto));

		return "G03";
	}

	/*
	 * //update member page
	 * 
	 * @RequestMapping("/G05") public ModelAndView changepw() {
	 * logger.info("call  change password"); return new ModelAndView("G05"); }
	 */
	// this month data
	@RequestMapping("/G06-1")
	public ModelAndView inputdata() {
		logger.info("call  input datar");
		return new ModelAndView("G06-1");
	}

	// Calendar
	@RequestMapping("/G07")
	public ModelAndView calendar() {
		logger.info("call  Calendar");
		return new ModelAndView("G07");
	}
}
