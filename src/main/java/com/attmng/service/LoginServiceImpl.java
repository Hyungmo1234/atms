package com.attmng.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.dao.LoginDAO;
import com.attmng.domain.EmployeeVO;
import com.attmng.dto.EmployeeDTO;

@Repository
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO dao;

	@Override
	public EmployeeVO LoginPOST(EmployeeDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.LoginPOST(dto);
	}
}