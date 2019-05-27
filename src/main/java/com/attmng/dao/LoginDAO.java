package com.attmng.dao;



import org.springframework.stereotype.Service;

import com.attmng.domain.EmployeeVO;
import com.attmng.dto.EmployeeDTO;

@Service
public interface LoginDAO {
	/*
	 * public List getLoginInfo() throws Exception;
	 */
	public EmployeeVO LoginPOST(EmployeeDTO dto) throws Exception;
}