package com.attmng.controller;

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
import com.attmng.service.modifyService;

/**
 * 占쎄뭔占쎄틬占쎄땃占쎄깻占쎄쿁占쎄묫占쎄틬占쎄땋�뇖�궍�빣
 * 
 * @author Use 占쎈빉鶯ㅻ끼占쎈굢�룒占쎌벍畑대돁�젛
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

	@RequestMapping(value = "/modifyPost", method = RequestMethod.POST)
	public String Modify(@ModelAttribute EmployeeVO vo) throws Exception {
		logger.info("modifyPOST");
		modifyService.modifyPOST(vo);

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

	// all month data
	@RequestMapping("/G06-2")
	public ModelAndView alldata() {
		logger.info("call  all data");
		return new ModelAndView("G06-2");
	}

	// Calendar
	@RequestMapping("/G07")
	public ModelAndView calendar() {
		logger.info("call  Calendar");
		return new ModelAndView("G07");
	}
}
