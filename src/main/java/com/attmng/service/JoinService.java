package com.attmng.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.attmng.domain.AttendanceVO;
import com.attmng.domain.EmployeeVO;
import com.attmng.domain.JoinVO;

@Service
public interface JoinService {
	
	//public EmployeeVO JoinPOST(EmployeeDTO dto) throws Exception;g
	public void JoinPOST(JoinVO vo) throws Exception;

	public List<EmployeeVO> EmployeeGET(String vo) throws Exception;

	public List<JoinVO> JoinGET(String com_code) throws Exception;

}