package com.attmng.dao;

import org.springframework.stereotype.Service;

import com.attmng.dto.MemberPasswordChangeDTO;

@Service
public interface MemberPasswordChangeDAO {

	public MemberPasswordChangeDTO User_read(MemberPasswordChangeDTO dto) throws Exception;
	
	public void G05_Update(String id, String password) throws Exception;
}
