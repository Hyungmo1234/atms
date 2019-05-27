package com.attmng.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.attmng.dao.LoginDAO;



@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
    BasicDataSource dataSource;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	
	@RequestMapping("/dbTest.do")
    public String dbTest(Model model) {
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = dataSource.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select now() as now;");
            
            while(rs.next()) {
                model.addAttribute("serverTime", rs.getString("now"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();    
            
        } finally {
            try {
                if(st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            try {
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }                        
        }
        
        return "main";
    }

	@Inject
	LoginDAO LoginDAO;
	
	//�꺆�궛�궎�꺍�뵽�씊
	@RequestMapping("/login")
	public ModelAndView loginpage() throws Exception {
		LoginDAO.getLoginInfo();
		return new ModelAndView("login");
	}

	//�깳�궎�꺍�뵽�씊
	@RequestMapping("/main")
	public ModelAndView mainpage() {
		return new ModelAndView("main");
	}

	//鴉싧뱻�쇉�뙯�뵽�씊
	@RequestMapping("/join")
	public ModelAndView joinpage() {
		return new ModelAndView("join");
	}
	
}
