package com.attmng.service;

import org.springframework.stereotype.Service;

import com.attmng.domain.EmployeeVO;
import com.attmng.dto.EmployeeDTO;

@Service
public interface LoginService {
	
	public EmployeeVO LoginPOST(EmployeeDTO dto) throws Exception;

	

}