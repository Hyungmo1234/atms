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
	
	@Autowired
	private ExcelService EService;
	@Autowired
	private AttendanceService AService;
	
	@RequestMapping(value = "/Excel", method = RequestMethod.POST)
	public String AttendanceGet(HttpServletRequest request,	ExcelToSaveAttendanceGetDTO exceldto, HttpSession session, Model model) throws Exception {

		//Session ID값 저장
		EmployeeVO vo;
		vo =  (EmployeeVO) session.getAttribute("Logininfo");
		
		//현재날짜 "201805" 형식
		SimpleDateFormat format = new SimpleDateFormat ("yyyyMM");
		String key_year_month = format.format (System.currentTimeMillis());
		
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
			
			//DB Update를 위해 AttendanceSerive.AttendanceUpdate 실행
			AService.AttendanceUpdate(vo.getId(), yearMonth, temp, 0, tempArray);
		}
		
		//DB Select을 위해 ExcelService.java 실행
		List<ExcelToSaveAttendanceGetDTO> excel = EService.ExcelGET(vo.getId(), key_year_month);
		
		//엑셀 저장을 위해 saveToPoi 실행
		saveToPoi(excel);
		
		//화면 Redirect를 위해 AttendanceSerive.AttendanceGET 실행
		List<AttendanceVO> attendance = AService.AttendanceGET(vo.getId(), yearMonth, 0);
		model.addAttribute("attendanceList", attendance);
		
		return "G06-1";
	}
	
	//Excel 저장을 위한 메소드
	public static void saveToPoi(List<ExcelToSaveAttendanceGetDTO> excel) throws Exception {

		// 파일 불러오기
		FileInputStream input_document = new FileInputStream("C:\\勤務表\\本社勤務表.xlsx");
		XSSFWorkbook my_xlsx_workbook = new XSSFWorkbook(input_document);
		XSSFSheet my_worksheet = my_xlsx_workbook.getSheetAt(0);
		
		// 실가동, 총가동, 휴식시간 합계 계산을 위한 변수 선언
		double countRop_time = 0.0;
		double countOp_time = 0.0;
		double countBr_time = 0.0;
		
		// Excel Format 상단 연도, 월, 부서, 이름 변수 선언
		String inputYear = excel.get(0).getKey_year_month().substring(0, 4);
		String inputMonth = excel.get(0).getKey_year_month().substring(4);
		String inputDep = excel.get(0).getDep_name();
		String inputName = excel.get(0).getEmp_name();
		
		//Cell입력을 위한 위치변수 선언
		XSSFCell cell = null;

		//연도 출력 Cell 위치 
		cell = my_worksheet.getRow(3).getCell(3);
		cell.setCellValue(inputYear);

		//월 출력 Cell 위치
		cell = my_worksheet.getRow(3).getCell(5);
		cell.setCellValue(inputMonth);
		
		//부서 출력 Cell 위치
		cell = my_worksheet.getRow(3).getCell(6);
		cell.setCellValue(inputDep);
				
		//이름출력 Cell 위치
		cell = my_worksheet.getRow(3).getCell(10);
		cell.setCellValue(inputName);
		
		//근무표 작성을 위해 필요한 행의 열 변환
		for (int rowNum = 0; rowNum < excel.size(); rowNum++) {
			
			//Excel Format 메인Cell 날짜, 요일, 근무상태 변수 선언 및 예외처리
			String inputDay = excel.get(rowNum).getKey_day();
			String inputDayOfWeek = getWeek(inputYear, inputMonth, inputDay);
			String inputWco_name = excel.get(rowNum).getWco_name();
			String forInputS_time = ""; 
			
			//출근시간 DB초기값이 Null일 경우 "00:00:00" 값으로 변환
			if(excel.get(rowNum).getS_time() == null) {
				forInputS_time = "00:00:00";
			} else {
				forInputS_time = String.valueOf(excel.get(rowNum).getS_time());
			}
			String forInputE_time = ""; 
			
			//퇴근시간 DB초기값이 Null일 경우 "00:00:00" 값으로 변환
			if(excel.get(rowNum).getE_time() == null) {
				forInputE_time = "00:00:00";
			} else {
				forInputE_time = String.valueOf(excel.get(rowNum).getE_time());
			}
			
			//출근시간, 퇴근시간, 휴식시간, 실가동시간 변수 선언 및 예외처리
			String inputS_time = forInputS_time.substring(0, 5);
			String inputE_time = forInputE_time.substring(0, 5);
			double inputBr_time = excel.get(rowNum).getBr_time()/60;
			double inputOp_time = excel.get(rowNum).getOp_time()/60;
			double inputRop_time = inputOp_time + inputBr_time;
			
			// 날짜 Cell 위치
			cell = my_worksheet.getRow(9 + rowNum).getCell(2);
			cell.setCellValue(inputDay);

			// 요일 Cell 위치
			cell = my_worksheet.getRow(9 + rowNum).getCell(3);
			cell.setCellValue(inputDayOfWeek);

			// 사업내용 Cell 위치
			cell = my_worksheet.getRow(9 + rowNum).getCell(4);
			cell.setCellValue(inputWco_name);

			// 업무 시작시간 Cell 위치
			cell = my_worksheet.getRow(9 + rowNum).getCell(6);
			cell.setCellValue(inputS_time);

			// 업무 종료시간 Cell 위치
			cell = my_worksheet.getRow(9 + rowNum).getCell(8);
			cell.setCellValue(inputE_time);

			// 실가동시간 Cell 위치
			cell = my_worksheet.getRow(9 + rowNum).getCell(27);
			cell.setCellValue(inputOp_time);

			// 휴식시간 Cell 위치
			cell = my_worksheet.getRow(9 + rowNum).getCell(28);
			cell.setCellValue(inputBr_time);

			// 총 시간 Cell 위치
			cell = my_worksheet.getRow(9 + rowNum).getCell(31);
			cell.setCellValue(inputRop_time);
			
			//휴식시간, 실가동시간, 총가동시간 합계 변수 선언
			countBr_time += inputBr_time;
			countOp_time += inputOp_time;
			countRop_time += inputRop_time;

		}
		
		// 총 실가동 시간 Cell 위치
		cell = my_worksheet.getRow(41).getCell(27);
		cell.setCellValue(countOp_time);
		
		// 총 휴식 시간 Cell 위치
		cell = my_worksheet.getRow(41).getCell(28);
		cell.setCellValue(countBr_time);
		
		// 총 가동 시간 Cell 위치
		cell = my_worksheet.getRow(41).getCell(31);
		cell.setCellValue(countRop_time);
		

		input_document.close();

		// 파일 저장 위치 설정
		String path = "C:\\勤務表";
        String fileName = "本社勤務表_" + excel.get(0).getKey_year_month() + ".xlsx";
        File file = new File(path);
        
        if (!file.exists()) file.mkdir();
    
        FileOutputStream output_file = new FileOutputStream(new File(path + "\\" + fileName));
        my_xlsx_workbook.write(output_file);

	}
	
	//요일 계산 메소드
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
