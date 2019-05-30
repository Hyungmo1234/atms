package com.attmng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.dao.EmployeeInfoDAO;
import com.attmng.dto.EmployeeInfoDTO;

@Repository
public class EmployeeInfoServicelmpl implements EmployeeInfoService {

	@Autowired
	private EmployeeInfoDAO dao;

	
	@Override
	public EmployeeInfoDTO User_read(EmployeeInfoDTO dto) throws Exception{
		// TODO Auto-generated method stub
		return dao.User_read(dto);
	}
}