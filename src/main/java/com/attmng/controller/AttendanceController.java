package com.attmng.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.attmng.domain.AttendanceVO;
import com.attmng.domain.EmployeeVO;
import com.attmng.dto.AttendanceDTO;
import com.attmng.service.AttendanceService;

@Controller
public class AttendanceController {

   @Autowired
   private AttendanceService AService;
   
   SimpleDateFormat format = new SimpleDateFormat ("yyyyMM");
   String yearMonth = format.format (System.currentTimeMillis());
   EmployeeVO vo;

   @RequestMapping(value = "/attendanceGET", method = RequestMethod.GET)
   public String AttendanceGet(Model model, HttpServletResponse response, HttpServletRequest request,
         AttendanceDTO dto, HttpSession session) throws Exception {

      /*
       * String year = request.getParameter("year"); String month =
       * request.getParameter("month");
       * 
       * if(Integer.parseInt(month) < 10) { month = "0" + month; }
       * 
       * String yearMonth = year + month;
       */
      
      vo =  (EmployeeVO) session.getAttribute("Logininfo");
   
      List<AttendanceVO> attendance = AService.AttendanceGET(vo.getId(), yearMonth, 0);

      model.addAttribute("attendanceList", attendance);
      /* request.getAttribute(ID); */
      return "G06-1";

   }
   
   @RequestMapping(value = "/attendanceUpdate", method = RequestMethod.GET)
   public String AttendanceUpdate(Model model, HttpServletResponse response, HttpServletRequest request,
         AttendanceDTO dto, HttpSession session) throws Exception {

      vo =  (EmployeeVO) session.getAttribute("Logininfo");
      
      String year = request.getParameter("year"); 
      String month = request.getParameter("month");
      
      if(Integer.parseInt(month) < 10) { 
         month = "0" + month; 
      }
      
      
      String yearMonth = year + month;
      
      AService.AttendanceUpdate(vo.getId(), yearMonth, "12", 0);

      List<AttendanceVO> attendance = AService.AttendanceGET(vo.getId(), yearMonth, 0);

      model.addAttribute("attendanceList", attendance);
      //model.addAttribute("attendanceUpdate", attendance);
      /* request.getAttribute(ID); */

      return "G06-1";
   }
   /*
    * @RequestMapping(value = "/ExcelSave", method = RequestMethod.GET) public
    * String ExcelGet(Model model, HttpServletResponse response, HttpServletRequest
    * request, AttendanceDTO dto,HttpSession session) throws Exception {
    * 
    * List<AttendanceVO> attendance = AService.ExcelGet("designer", "0");
    * 
    * model.addAttribute("getExcelInfo", attendance); request.getAttribute(ID);
    * return "test";
    * 
    * }
    */

}
