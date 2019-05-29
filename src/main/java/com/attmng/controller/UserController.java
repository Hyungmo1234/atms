package com.attmng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * �깺�꺖�궣�겢�겗�깪�꺖�궦燁삣땿
 * @author Use
 *�땯壤볢�낉폏�쓮若뉔렗
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	//login page
	@RequestMapping("/G01")
	public ModelAndView loginpage() throws Exception {
		logger.info("call login");
		return new ModelAndView("G01");
	}

	//after login main page
	@RequestMapping("/G00-0")
	public ModelAndView mainpage() {
		return new ModelAndView("G00-0");
	}

	
	 //add member page
	  
	 @RequestMapping("/G02") public ModelAndView joinpage() {
	  logger.info("call add member");
	  
	 return new ModelAndView("G02"); }
	 
	
	//member data page 
	@RequestMapping("/G03")
	public ModelAndView memberdata() {
		logger.info("call  member data");
		return new ModelAndView("G03");
	}
	
	

	//update member page 
	@RequestMapping("/G04")
	public ModelAndView upadatemember() {
		logger.info("call  upadate member");
		return new ModelAndView("G04");
	}
	
	//update member page 
	@RequestMapping("/G05")
	public ModelAndView changepw() {
		logger.info("call  change password");
		return new ModelAndView("G05");
	}
	
	//this month data 
		@RequestMapping("/G06-1")
		public ModelAndView inputdata() {
			logger.info("call  input datar");
			return new ModelAndView("G06-1");
		}
		
		//all month data
		@RequestMapping("/G06-2")
		public ModelAndView alldata() {
			logger.info("call  all data");
			return new ModelAndView("G06-2");
		}
		
		//Calendar
		@RequestMapping("/G07")
		public ModelAndView calendar() {
			logger.info("call  Calendar");
			return new ModelAndView("G07");
		}
}
