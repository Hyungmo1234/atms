package com.attmng.dao;



import org.springframework.stereotype.Service;

import com.attmng.domain.EmployeeVO;

@Service
public interface ModifyDAO {
	/*
	 * public List getLoginInfo() throws Exception;;
	 */
	//public JoinVO insertMember(EmployeeDTO dto) throws Exception;
	public void modifyPOST(EmployeeVO vo) throws Exception;
}