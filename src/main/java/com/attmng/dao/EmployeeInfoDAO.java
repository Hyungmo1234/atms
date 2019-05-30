package com.attmng.dao;

import org.springframework.stereotype.Service;

import com.attmng.dto.EmployeeInfoDTO;

@Service
public interface EmployeeInfoDAO {

	public EmployeeInfoDTO User_read(EmployeeInfoDTO dto) throws Exception;
	

	
	
}
