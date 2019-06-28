package com.attmng.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.attmng.domain.AttendanceVO;
import com.attmng.domain.EmployeeVO;
import com.attmng.domain.WorkflowVO;
import com.attmng.dto.AttendanceDTO;
import com.attmng.dto.WorkflowDTO;
import com.attmng.service.AttendanceService;
import com.attmng.service.WorkflowService;

@Controller
public class AttendanceController {

  @Autowired
  private AttendanceService AService;
  
  @Autowired
  private WorkflowService WService;

  SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
  String yearMonth = format.format(System.currentTimeMillis());
  EmployeeVO vo;
  WorkflowVO wvo;

  @RequestMapping(value = "attendanceGET", method = RequestMethod.GET)
  public String AttendanceGet(Model model, HttpServletResponse response, HttpServletRequest request,
      AttendanceDTO dto, HttpSession session) throws Exception {

    vo = (EmployeeVO) session.getAttribute("Logininfo");
    AttendanceDTO attendanceDTO = new AttendanceDTO();
    WorkflowDTO   workflowDTO   = new WorkflowDTO()  ;
    
    List<AttendanceVO> attendance = AService.AttendanceGET(vo.getId(), yearMonth, 0);

    model.addAttribute("attendanceList", attendance);
    
    int workflow = WService.workflowcheck(vo.getId());
    String workflow_feed = WService.workflowfeedback(vo.getId());
    
    if(workflow == 100 ) {      // 사시모도시 후 알람, 메모 설정
        model.addAttribute("s_status", 1);      
        
        model.addAttribute("memo", workflow_feed);
    }   
    if(workflow == 200) {           // 승인 대기중
        model.addAttribute("s_status", 2);      
    }
    if(workflow == 300) {           // 승인 확인 후 알람설정
        model.addAttribute("s_status", 3);  
    }
    
    /* request.getAttribute(ID); */
    return "G06-1";

  }
  
  @RequestMapping(value = "/workflowfeedback", method = RequestMethod.POST)
  public void workflowfeedback(Model model, HttpServletResponse response, HttpServletRequest request,
          WorkflowDTO dto, HttpSession session) throws Exception {
      
      
  }
  
  @RequestMapping(value = "/workflowUpdate", method = RequestMethod.POST)
  public String workflowUpdate(Model model, HttpServletResponse response, HttpServletRequest request,
          WorkflowDTO dto, HttpSession session) throws Exception {

      vo = (EmployeeVO) session.getAttribute("Logininfo");
      
      SimpleDateFormat format1 = new SimpleDateFormat ("yyyyMM");
      
      Date time = new Date();
      
      String key_year_month = format1.format(time);
      
      int status = 200;
      
      model.addAttribute("id", vo.getId());
      model.addAttribute("key_year_month", key_year_month);
      model.addAttribute("status", status);

      int workflow = WService.WorkflowGET(vo.getId(), key_year_month, status);
      //List<AttendanceVO> attendance = AService.AttendanceGET(vo.getId(), yearMonth, 0);
      
      //model.addAttribute("workflowList", workflow);
      
      // request.getAttribute(ID); 
      return "G06-1";
  }

  @RequestMapping(value = "/mainPage", method = RequestMethod.GET)
  public String moveMainPage(Model model, HttpServletResponse response, HttpServletRequest request,
      AttendanceDTO dto, HttpSession session) throws Exception {

    // 로그인 정보세션
    session.setAttribute("Logininfo", vo);
    if (vo.getAdm_code() == null) {
      return "G00-1";
    }
    // login 성공시 게시물리스트를 출력해주기위한 model객체
    return "G00-2";

  }

  @RequestMapping(value = "/attendanceUpdate", method = RequestMethod.POST)
  public String AttendanceUpdate(Model model, HttpServletResponse response,
      HttpServletRequest request, AttendanceDTO dto, HttpSession session) throws Exception {

    vo = (EmployeeVO) session.getAttribute("Logininfo");

    AttendanceDTO attendanceDTO = new AttendanceDTO();
    WorkflowDTO   workflowDTO   = new WorkflowDTO()  ;
    

    if("2".equals(String.valueOf(request.getParameter("sendFlag")))){
        this.workflowUpdate(model, response, request, workflowDTO, session);        
    }

    String year = request.getParameter("year");
    String month = request.getParameter("month");

    if (Integer.parseInt(month) < 10) {
      month = "0" + month;
    }

    String yearMonth = year + month;

    // String inHour = request.getParameter("inhour1");
    // in_minute, out_hour, out_minute, op_time(葉쇔깓�셽�뼋),
    // w_list(鵝쒏���냵若�), br_time(鴉묉넩�셽�뼋),
    // notice(�젿�몜雅뗩쟿), remark(�굺��)

    Calendar cal = Calendar.getInstance(); // new GregorianCalendar(year, month, 1);

    int data = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

    Map m = request.getParameterMap();
    int mSize = m.size();

    for (int i = 1; i <= data; i++) {
      dto = new AttendanceDTO();

      String[] tempArray = new String[10];

      String temp = null;

      temp = i + "";

      if (i < 10) {
        temp = "0" + i;
      }

      Enumeration p = request.getParameterNames();

      for (int j = 0; j < 10; j++) {
        String name = (String) p.nextElement();
        String[] values = (String[]) m.get(name);

        tempArray[j] = values[i - 1];

      }


      /*
       * dto.setS_time(tempArray[1] + ":" + tempArray[2]); dto.setE_time(tempArray[3] + ":" +
       * tempArray[4]); dto.setWco_name(tempArray[5]);
       * dto.setBr_time(Double.parseDouble(tempArray[6])); dto.setNotice(tempArray[7]);
       * dto.setRemarks(tempArray[8]); dto.setOp_time(Double.parseDouble(tempArray[9]));
       */

      AService.AttendanceUpdate(vo.getId(), yearMonth, temp, 0, tempArray);
    }



    List<AttendanceVO> attendance = AService.AttendanceGET(vo.getId(), yearMonth, 0);

    model.addAttribute("attendanceList", attendance);
    // model.addAttribute("attendanceUpdate", attendance);
    /* request.getAttribute(ID); */

    return "G06-1";
  }
  /*
   * @RequestMapping(value = "/ExcelSave", method = RequestMethod.GET) public String ExcelGet(Model
   * model, HttpServletResponse response, HttpServletRequest request, AttendanceDTO dto,HttpSession
   * session) throws Exception {
   * 
   * List<AttendanceVO> attendance = AService.ExcelGet("designer", "0");
   * 
   * model.addAttribute("getExcelInfo", attendance); request.getAttribute(ID); return "test";
   * 
   * }
   */

}
