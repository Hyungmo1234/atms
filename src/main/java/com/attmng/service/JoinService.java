package com.attmng.service;

import org.springframework.stereotype.Service;

import com.attmng.domain.JoinVO;

@Service
public interface JoinService {
	
	//public EmployeeVO JoinPOST(EmployeeDTO dto) throws Exception;g
	public void JoinPOST(JoinVO vo) throws Exception;

	

}