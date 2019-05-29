package com.attmng.dao;



import org.springframework.stereotype.Service;

import com.attmng.domain.JoinVO;

@Service
public interface JoinDAO {
	/*
	 * public List getLoginInfo() throws Exception;;
	 */
	//public JoinVO insertMember(EmployeeDTO dto) throws Exception;
	public void JoinPOST(JoinVO vo) throws Exception;
}