package com.attmng.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.attmng.dto.AttendanceDTO;
import com.attmng.service.AttendanceService;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceService AService;

	SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
	String yearMonth = format.format(System.currentTimeMillis());
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

		vo = (EmployeeVO) session.getAttribute("Logininfo");

		List<AttendanceVO> attendance = AService.AttendanceGET(vo.getId(), yearMonth, 0);

		model.addAttribute("attendanceList", attendance);
		/* request.getAttribute(ID); */
		return "G06-1";

	}

	@RequestMapping(value = "/attendanceUpdate", method = RequestMethod.POST)
	public String AttendanceUpdate(Model model, HttpServletResponse response, HttpServletRequest request,
			AttendanceDTO dto, HttpSession session) throws Exception {

		vo = (EmployeeVO) session.getAttribute("Logininfo");

		String year = request.getParameter("year");
		String month = request.getParameter("month");

		if (Integer.parseInt(month) < 10) {
			month = "0" + month;
		}

		String yearMonth = year + month;

		// String inHour = request.getParameter("inhour1");
		// in_minute, out_hour, out_minute, op_time(稼働時間),
		// w_list(作業内容), br_time(休憩時間),
		// notice(報告事項), remark(備考)

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
				
				
				tempArray[j] = values[i-1];
				
			}
			
			
			/*
			 * dto.setS_time(tempArray[1] + ":" + tempArray[2]); dto.setE_time(tempArray[3]
			 * + ":" + tempArray[4]); dto.setWco_name(tempArray[5]);
			 * dto.setBr_time(Double.parseDouble(tempArray[6]));
			 * dto.setNotice(tempArray[7]); dto.setRemarks(tempArray[8]);
			 * dto.setOp_time(Double.parseDouble(tempArray[9]));
			 */
			
			AService.AttendanceUpdate(vo.getId(), yearMonth, temp, 0, tempArray);
		}
		
		
		
		List<AttendanceVO> attendance = AService.AttendanceGET(vo.getId(), yearMonth, 0);

		model.addAttribute("attendanceList", attendance);
		// model.addAttribute("attendanceUpdate", attendance);
		/* request.getAttribute(ID); */

		return "G00-1";
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
