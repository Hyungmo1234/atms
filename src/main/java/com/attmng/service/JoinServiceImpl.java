package com.attmng.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.dao.JoinDAO;
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

}