package com.attmng.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.dao.JoinDAO;
import com.attmng.domain.EmployeeVO;
import com.attmng.domain.JoinVO;

@Repository
public class JoinServiceImpl implements JoinService {

	@Autowired
	private JoinDAO dao;

	@Override
	public void JoinPOST(JoinVO vo) throws Exception {
		// TODO Auto-generated method stubb
	    dao.JoinPOST(vo);
	}
	
	@Override
	public List<EmployeeVO> EmployeeGET(String vo) throws Exception {
		// TODO Auto-generated method stubb
		return dao.EmployeeGET(vo);
	}

	public List<JoinVO> JoinGET(String com_code) throws Exception {
		return dao.JoinGET(com_code);
	}
	
	public List<JoinVO> Idcheck(String id) throws Exception{
		return dao.Idcheck(id);
	}

}