package com.attmng.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.attmng.domain.JoinVO;
import com.attmng.service.JoinService;

@Controller
public class AjaxController {
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	String com_name; 
	@Autowired
	private JoinService joinService;
	
	
	@RequestMapping(value = "/G02_1", method = RequestMethod.POST)
	public String JoinPOST(@RequestParam("com_code") String com_code, Model model) throws Exception {	
		
		model.addAttribute("JoinGET", joinService.JoinGET(com_code));
		
		return "G02_1";
	}
	
	@RequestMapping(value = "/G02_2", method = RequestMethod.POST)
	public String IdPOST(@RequestParam("id") String id, Model model,HttpServletResponse response) throws Exception {	
		/*
		 * model.addAttribute("JoinGET", joinService.Idcheck(id));
		 */
	    	List<JoinVO> vo = joinService.Idcheck(id);
	    	
	    	model.addAttribute("IdCheck", 1);
	    	
			if (vo.size() == 0) {
				return "G02_3";
			}else {
				return "G02_2";
			}
	}
	
	/*
	 * @RequestMapping(value = "/dddd", method = RequestMethod.GET) public String
	 * JoinGET(@RequestParam("com_name") String com_name,Model model) throws
	 * Exception {
	 * 
	 * model.addAttribute("JoinGET", joinService.JoinGET(com_name));
	 * 
	 * return "dddd"; }
	 */
	

}