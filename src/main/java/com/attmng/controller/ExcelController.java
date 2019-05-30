package com.attmng.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.attmng.domain.AttendanceVO;
import com.attmng.domain.EmployeeVO;
import com.attmng.dto.ExcelToSaveAttendanceGetDTO;
import com.attmng.service.AttendanceService;
import com.attmng.service.ExcelService;

@Controller
public class ExcelController {
	
	SimpleDateFormat format = new SimpleDateFormat ("yyyyMM");
	String key_year_month = format.format (System.currentTimeMillis());
	EmployeeVO vo;
	
	@Autowired
	private ExcelService EService;
	@Autowired
	private AttendanceService AService;

	@RequestMapping(value = "/Excel", method = RequestMethod.POST)
	public String AttendanceGet(HttpServletResponse response, HttpServletRequest request,
			ExcelToSaveAttendanceGetDTO exceldto, HttpSession session, Model model) throws Exception {
		
		//Session ID값 저장
		vo =  (EmployeeVO) session.getAttribute("Logininfo");
		
		//해당 날짜 저장 및 변환
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		if (Integer.parseInt(month) < 10) {
			month = "0" + month;
		}
		String yearMonth = year + month;
		Calendar cal = Calendar.getInstance(); // new GregorianCalendar(year, month, 1);
		int data = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		
		Map m = request.getParameterMap();
		int mSize = m.size();
		
		for (int i = 1; i < data; i++) {
			
			String[] tempArray = new String[10];
			String temp = null;
			temp = i + "";

			if (i < 10) temp = "0" + i;
			
			Enumeration p = request.getParameterNames();
			
			for (int j = 0; j < 10; j++) {
				String name = (String) p.nextElement();
				String[] values = (String[]) m.get(name);
				tempArray[j] = values[i-1];
			}
			
			AService.AttendanceUpdate(vo.getId(), yearMonth, temp, 0, tempArray);
		}
		
		//Excel저장
		List<ExcelToSaveAttendanceGetDTO> excel = EService.ExcelGET(vo.getId(), key_year_month);
		saveToPoi(excel);
		
		//화면 Redirect
		List<AttendanceVO> attendance = AService.AttendanceGET(vo.getId(), yearMonth, 0);
		model.addAttribute("attendanceList", attendance);
		
		return "G06-1";
	}
	
	public static void saveToPoi(List<ExcelToSaveAttendanceGetDTO> excel) throws Exception {

		// 파일 불러오기
		FileInputStream input_document = new FileInputStream("C:\\勤務表\\本社勤務表.xlsx");
		XSSFWorkbook my_xlsx_workbook = new XSSFWorkbook(input_document);

		// 수정값
		XSSFSheet my_worksheet = my_xlsx_workbook.getSheetAt(0);
		XSSFCell cell = null;

		double countRop_time = 0.0;
		double countOp_time = 0.0;
		double countBr_time = 0.0;
		
		String inputYear = excel.get(0).getKey_year_month().substring(0, 4);
		String inputMonth = excel.get(0).getKey_year_month().substring(4);
		String inputDep = excel.get(0).getDep_name();
		String inputName = excel.get(0).getEmp_name();
		
		//연도 출력 cell
		cell = my_worksheet.getRow(3).getCell(3);
		cell.setCellValue(inputYear);

		//월 출력
		cell = my_worksheet.getRow(3).getCell(5);
		cell.setCellValue(inputMonth);
		
		//부서 출력 
		cell = my_worksheet.getRow(3).getCell(6);
		cell.setCellValue(inputDep);
				
		//이름출력
		cell = my_worksheet.getRow(3).getCell(10);
		cell.setCellValue(inputName);
		
		for (int rowNum = 0; rowNum < excel.size(); rowNum++) {

			String inputDay = excel.get(rowNum).getKey_day();
			String inputDayOfWeek = getWeek(inputYear, inputMonth, inputDay);
			String inputWco_name = excel.get(rowNum).getWco_name();
			
			String forInputS_time = ""; 
			
			if(excel.get(rowNum).getS_time() == null) {
				forInputS_time = "00:00:00";
			} else {
				forInputS_time = String.valueOf(excel.get(rowNum).getS_time());
			}
			
			String forInputE_time = ""; 
			
			if(excel.get(rowNum).getE_time() == null) {
				forInputE_time = "00:00:00";
			} else {
				forInputE_time = String.valueOf(excel.get(rowNum).getE_time());
			}
			
			String.valueOf(excel.get(rowNum).getE_time());
			
			String inputS_time = forInputS_time.substring(0, 5);
			String inputE_time = forInputE_time.substring(0, 5);
			double inputBr_time = excel.get(rowNum).getBr_time()/60;
			double inputOp_time = excel.get(rowNum).getOp_time()/60;
			if(excel.get(rowNum).getOp_time() == 0.0) {
				double inputRop_time = 0.0;
			}
			double inputRop_time = inputOp_time + inputBr_time;
			
			// 날짜
			cell = my_worksheet.getRow(9 + rowNum).getCell(2);
			cell.setCellValue(inputDay);

			// 요일
			cell = my_worksheet.getRow(9 + rowNum).getCell(3);
			cell.setCellValue(inputDayOfWeek);

			// 사업내용
			cell = my_worksheet.getRow(9 + rowNum).getCell(4);
			cell.setCellValue(inputWco_name);

			// 업무 시작시간
			cell = my_worksheet.getRow(9 + rowNum).getCell(6);
			cell.setCellValue(inputS_time);

			// 업무 종료시간
			cell = my_worksheet.getRow(9 + rowNum).getCell(8);
			cell.setCellValue(inputE_time);

			// 실가동시간
			cell = my_worksheet.getRow(9 + rowNum).getCell(27);
			cell.setCellValue(inputOp_time);

			// 휴식시간
			cell = my_worksheet.getRow(9 + rowNum).getCell(28);
			cell.setCellValue(inputBr_time);

			// 총 시간
			cell = my_worksheet.getRow(9 + rowNum).getCell(31);
			cell.setCellValue(inputRop_time);
			
			countBr_time += inputBr_time;
			countOp_time += inputOp_time;
			countRop_time += inputRop_time;

		}
		
		// 총 실가동 시간
		cell = my_worksheet.getRow(41).getCell(27);
		cell.setCellValue(countOp_time);
		
		// 총 휴식 시간
		cell = my_worksheet.getRow(41).getCell(28);
		cell.setCellValue(countBr_time);
		
		// 총 가동 시간
		cell = my_worksheet.getRow(41).getCell(31);
		cell.setCellValue(countRop_time);
		

		input_document.close();

		// 파일 저장하기
		String path = "C:\\勤務表";
        String fileName = "本社勤務表_" + excel.get(0).getKey_year_month() + ".xlsx";
        File file = new File(path);
        if (!file.exists()) {
           file.mkdir();
     }
        FileOutputStream output_file = new FileOutputStream(new File(path + "\\" + fileName));
        my_xlsx_workbook.write(output_file);

	}

	public static String getWeek(String _year, String _month, String _day) {

		int year = Integer.parseInt(_year); // 받아온 년도
		int month = Integer.parseInt(_month); // 받아온 달
		int day = Integer.parseInt(_day); // 받아온 일

		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		String[] week = { "", "日", "月", "火", "水", "木", "金", "土" };

		return week[dayOfWeek];
	}
	
}
