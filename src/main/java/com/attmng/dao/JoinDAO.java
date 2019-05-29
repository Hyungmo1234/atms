package com.attmng.dao;



import java.util.List;

import org.springframework.stereotype.Service;

import com.attmng.domain.EmployeeVO;
import com.attmng.domain.JoinVO;

@Service
public interface JoinDAO {
	/*
	 * public List getLoginInfo() throws Exception;;
	 */
	//public JoinVO insertMember(EmployeeDTO dto) throws Exception;	
	public void JoinPOST(JoinVO vo) throws Exception;
	public List<EmployeeVO> EmployeeGET(String vo) throws Exception;
	
	public List<JoinVO> JoinGET(String com_name) throws Exception;
}