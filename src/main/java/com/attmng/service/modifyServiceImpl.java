package com.attmng.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.dao.ModifyDAO;
import com.attmng.domain.EmployeeVO;

@Repository
public class modifyServiceImpl implements modifyService {

	@Autowired
	private ModifyDAO dao;

	@Override
	public void modifyPOST(EmployeeVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.modifyPOST(vo);
	}

}