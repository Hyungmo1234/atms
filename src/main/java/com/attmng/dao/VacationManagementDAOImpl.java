package com.attmng.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.domain.VacationManagementVO;

@Repository
public class VacationManagementDAOImpl implements VacationManagementDAO {
	private static final String namespace = "com.attmng.atms.mappers.vacationManagement";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Map<String, List<VacationManagementVO>> selectInfo(Map<String, String> info){
		Map<String, List<VacationManagementVO>> selectInfo = new HashMap<String, List<VacationManagementVO>>();

		List<VacationManagementVO> t_vacation_management      = sqlSession.selectList(namespace+".select_vacation_management_t_vacation_management"     , info);
		List<VacationManagementVO> t_vacation_holiday         = sqlSession.selectList(namespace+".select_vacation_management_t_vacation_holiday"        , info);
		List<VacationManagementVO> t_vacation_worktimecontrol = sqlSession.selectList(namespace+".select_vacation_management_t_vacation_worktimecontrol", info);
		
		selectInfo.put("t_vacation_management"     , t_vacation_management     );
		selectInfo.put("t_vacation_holiday"        , t_vacation_holiday        );
		selectInfo.put("t_vacation_worktimecontrol", t_vacation_worktimecontrol);
		
		return selectInfo;
	}
	
	@Override
	public int Save(List<Map<String, Object>> vacationScheduleListMap) throws Exception {
		List<VacationManagementVO> inputListManagementVo      = new ArrayList<VacationManagementVO>();
		List<VacationManagementVO> inputListHoliDayVo         = new ArrayList<VacationManagementVO>();
		List<VacationManagementVO> inputListWorkTimeControlVo = new ArrayList<VacationManagementVO>();
		
		for(int i = 0; i < vacationScheduleListMap.size(); ++i){
			Map<String, Object> vacationScheduleMap = vacationScheduleListMap.get(i);
			
			if(!vacationScheduleMap.get("detail").equals("")) {
				VacationManagementVO vacationManagementVO = new VacationManagementVO();
				
				vacationManagementVO.setId           (String.valueOf(vacationScheduleMap.get("id"           )));
				vacationManagementVO.setYearmonth    (String.valueOf(vacationScheduleMap.get("yearmonth"    )));
				vacationManagementVO.setVac_startdate(String.valueOf(vacationScheduleMap.get("vac_startdate")));
				vacationManagementVO.setVac_enddate  (String.valueOf(vacationScheduleMap.get("vac_enddate"  )));
				vacationManagementVO.setDivision     (String.valueOf(vacationScheduleMap.get("division"     )));
				vacationManagementVO.setDetail       (String.valueOf(vacationScheduleMap.get("detail"       ))); 
				
				inputListManagementVo.add(vacationManagementVO);
			}
			
		}
		
		for(int i = 0; i < vacationScheduleListMap.size(); ++i){
			Map<String, Object> vacationScheduleMap = vacationScheduleListMap.get(i);
			
			if(!vacationScheduleMap.get("holi_work").equals("")){
				VacationManagementVO vacationManagementVO = new VacationManagementVO();
				
				vacationManagementVO.setId       (String.valueOf(vacationScheduleMap.get("id"       )));
				vacationManagementVO.setYearmonth(String.valueOf(vacationScheduleMap.get("yearmonth")));
				vacationManagementVO.setHoli_work(String.valueOf(vacationScheduleMap.get("holi_work")));
				
				inputListHoliDayVo.add(vacationManagementVO);
			}
		}
		
		for(int i = 0; i < vacationScheduleListMap.size(); ++i){
			Map<String, Object> vacationScheduleMap = vacationScheduleListMap.get(i);
			
			if(!vacationScheduleMap.get("con_time").equals("00")) {
				VacationManagementVO vacationManagementVO = new VacationManagementVO();
				
				vacationManagementVO.setId       (String.valueOf(vacationScheduleMap.get("id"       )));
				vacationManagementVO.setYearmonth(String.valueOf(vacationScheduleMap.get("yearmonth")));
				vacationManagementVO.setCon_time (String.valueOf(vacationScheduleMap.get("con_time" )));
				
				inputListWorkTimeControlVo.add(vacationManagementVO);
			}
		}
		
		if(inputListManagementVo.size()!=0) {
			sqlSession.insert(namespace + ".insert_t_vacation_management"     , inputListManagementVo     );
		}
		
		if(inputListHoliDayVo.size()!=0) {
			sqlSession.insert(namespace + ".insert_t_vacation_holiday"        , inputListHoliDayVo        );
		}
		
		if(inputListWorkTimeControlVo.size()!=0) {
			sqlSession.insert(namespace + ".insert_t_vacation_worktimecontrol", inputListWorkTimeControlVo);
		}
		
		return 0;
	}
}
