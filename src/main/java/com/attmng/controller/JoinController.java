package com.attmng.controller;

import javax.servlet.http.HttpServletRequest;
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

import com.attmng.domain.JoinVO;
import com.attmng.service.JoinService;

@Controller
public class JoinController {

	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

	@Autowired
	private JoinService joinService;

	
	  // join
	  	  @RequestMapping(value = "/JoinPOST", method = RequestMethod.POST) public
	  String JoinPOST(@ModelAttribute JoinVO vo, Model model,HttpServletResponse
	  response, HttpServletRequest request, HttpSession session) throws Exception {
	  
	  logger.info("JoinPOST");
	   
	  return "G01"; }
	 

	@RequestMapping(value = "/JoinGET", method = RequestMethod.GET)
	public String JoinGET(@RequestParam("com_name") String com_name, Model model) throws Exception {

		model.addAttribute("JoinGET", joinService.JoinGET(com_name));

		return "G02";
	}

}
