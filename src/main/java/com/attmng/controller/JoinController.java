package com.attmng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attmng.domain.JoinVO;
import com.attmng.service.JoinService;

@Controller
public class JoinController {
	
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	@Autowired
	private JoinService joinService;

	// join
	@RequestMapping(value = "/JoinPOST", method = RequestMethod.POST)
	public String JoinPOST(@ModelAttribute JoinVO vo) throws Exception {
		logger.info("JoinPOST");
		
		joinService.JoinPOST(vo);

		return "G01";
	}

}
