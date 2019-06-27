package com.attmng.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.attmng.domain.EmployeeVO;
import com.attmng.domain.JoinVO;
import com.attmng.dto.MemberInformationDTO;
import com.attmng.service.JoinService;
import com.attmng.service.MemberInformationService;


// @Auth
@Controller
public class MemberInformationController {


  @Inject
  MemberInformationService MemInfoService;

  @Autowired
  private JoinService joinService;

  // all month data
  @RequestMapping("/G06-2")
  public ModelAndView alldata(HttpServletRequest request, HttpSession session, Model model)
      throws Exception {

    MemInfoService.getUserAttendanceData(request, session, model);

    return new ModelAndView("G12");
  }

  @RequestMapping(value = "/G10", method = RequestMethod.GET)
  public String Admin_get_MembersInformation(Model model, HttpSession session) throws Exception {
    EmployeeVO vo = (EmployeeVO) session.getAttribute("Logininfo");
    List<MemberInformationDTO> membersData =
        MemInfoService.getMembersInformation(vo.getAdm_code(), vo.getComName_ryak());


    model.addAttribute("membersData", membersData);

    return "G10";
  }

  @RequestMapping(value = "G11", method = RequestMethod.POST)
  public String Admin_get_MemberInformation(HttpServletRequest request, Model model)
      throws Exception {
    String name = request.getParameter("name");

    List<MemberInformationDTO> memberData = MemInfoService.getMemberInformation(name);

    model.addAttribute("memberData", memberData.get(0));

    return "G11";
  }

  @RequestMapping(value = "/G12", method = RequestMethod.POST)
  public String Admin_get_commuteInformation(HttpServletRequest request, HttpSession session,
      Model model) throws Exception {

    //
    MemInfoService.getMemberAttendanceData(request, session, model);

    return "G12";
  }

  @RequestMapping(value = "/test", method = RequestMethod.POST)
  public String test(HttpServletRequest request, Model model, HttpSession session)
      throws Exception {
    String testa = request.getParameter("com_code1");
    String testb = request.getParameter("dep_areaHidden");
    String testc = request.getParameter("pos_code");
    String testd = request.getParameter("search");

    Map<String, Object> tempMap = new HashMap<String, Object>();

    tempMap.put("testa", testa);
    tempMap.put("testb", testb);
    tempMap.put("testc", testc);
    tempMap.put("testd", testd);



    EmployeeVO vo = (EmployeeVO) session.getAttribute("Logininfo");
    List<MemberInformationDTO> membersData =
        MemInfoService.getMembersInformation2(vo.getAdm_code(), vo.getComName_ryak(), tempMap);

    model.addAttribute("com_code1", testa);
    model.addAttribute("dep_areaHidden", testb);
    model.addAttribute("JoinGET2", joinService.JoinGET(testa));
    model.addAttribute("pos_code", testc);
    model.addAttribute("search", testd);

    model.addAttribute("membersData", membersData);

    return "G10";
  }

}
