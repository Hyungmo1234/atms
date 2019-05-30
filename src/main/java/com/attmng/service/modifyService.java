package com.attmng.service;

import org.springframework.stereotype.Service;

import com.attmng.domain.EmployeeVO;

@Service
public interface modifyService {
	
	public EmployeeVO EmpData(String id) throws Exception;
	
	public void modifyPOST(EmployeeVO vo) throws Exception;

}