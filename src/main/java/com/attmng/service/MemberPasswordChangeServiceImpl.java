package com.attmng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.dao.MemberPasswordChangeDAO;
import com.attmng.dto.MemberPasswordChangeDTO;

@Repository
public class MemberPasswordChangeServiceImpl implements MemberPasswordChangeService{
	
	@Autowired
	   private MemberPasswordChangeDAO dao;

	@Override
	public MemberPasswordChangeDTO User_read(MemberPasswordChangeDTO dto) throws Exception {

		return dao.User_read(dto);
	}
	
	@Override
	public void G05_Update(String id, String password) throws Exception{
		
		dao.G05_Update(id, password);		
	}

	

	
}
