package com.attmng.service;

import org.springframework.stereotype.Service;

import com.attmng.dto.EmployeeInfoDTO;

@Service
public interface EmployeeInfoService {
	
    public EmployeeInfoDTO User_read(EmployeeInfoDTO dto) throws Exception;

	
}
