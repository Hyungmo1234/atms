package com.attmng.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.attmng.domain.AttendanceVO;
import com.attmng.domain.EmployeeVO;
import com.attmng.domain.WorkflowVO;
import com.attmng.dto.AttendanceDTO;
import com.attmng.service.AttendanceService;
import com.attmng.service.MemberInformationService;
import com.attmng.service.WorkflowService;

@Controller
public class ApprovalController {
   
   @Autowired
   private AttendanceService AService;
   
   @Autowired
   private WorkflowService WService;
 
   @Inject
   MemberInformationService MemInfoService;
   
   SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
   String yearMonth = format.format(System.currentTimeMillis());
   EmployeeVO vo;
   WorkflowVO wvo;
   
   @RequestMapping(value = "oksign", method = RequestMethod.POST)
   public String okSign(Model model, HttpServletResponse response, HttpServletRequest request,
         HttpSession session, @RequestParam("id_value") String str) throws Exception {
      
      vo = (EmployeeVO) session.getAttribute("Logininfo");
      
      SimpleDateFormat format1 = new SimpleDateFormat ("yyyyMMdd");
      Date time = new Date();
      String commit_date = format1.format(time);
      int status = 300;
      String id = str;
      System.out.println(id+"입니다.");
      
      model.addAttribute("commit_name", vo.getId());
      model.addAttribute("commit_date", commit_date);
      model.addAttribute("status", status);
      model.addAttribute("id", id);

      int workflow = WService.Workflow_ok(vo.getId(), commit_date, status, id);
      
      
      //재 출력
      MemInfoService.getUserAttendanceData(request, session, model);
      
      List<AttendanceVO> attendance = AService.AttendanceGET(id, yearMonth, 0);
      
      model.addAttribute("attendanceList", attendance);
     
//      
//      List<AttendanceVO> attendance = AService.AttendanceGET(vo.getId(), yearMonth, 0);
//      
//      model.addAttribute("attendanceList", attendance);
//      
//      workflow = WService.workflowcheck(vo.getId());
//      
//      if(workflow != 0) {
//         
//         System.out.println("널이 아닙니다.");
//             model.addAttribute("aaaaaa", 1);
//         
//      }
      
      return "G12";
      }
   
   @RequestMapping(value = "/G00-2/G10/cancel", method = RequestMethod.POST)
   public String cancel(Model model, HttpServletResponse response, HttpServletRequest request,
         HttpSession session, @RequestParam("id_value") String str) throws Exception {
      
      vo = (EmployeeVO) session.getAttribute("Logininfo");
      
      SimpleDateFormat format1 = new SimpleDateFormat ("yyyyMMdd");
      Date time = new Date();
      String commit_date = format1.format(time);
      int status = 100;
      String id = str;
      System.out.println(id+"입니다.");
      
      model.addAttribute("commit_name", vo.getId());
      model.addAttribute("commit_date", commit_date);
      model.addAttribute("status", status);
      model.addAttribute("id", id);

      int workflow = WService.Workflow_cancel(vo.getId(), commit_date, status, id);
      
      
      MemInfoService.getUserAttendanceData(request, session, model);
      
      List<AttendanceVO> attendance = AService.AttendanceGET(id, yearMonth, 0);
      
      model.addAttribute("attendanceList", attendance);
     
      
      return "G12";
      }
   
}