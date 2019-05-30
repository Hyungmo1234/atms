package com.attmng.service;

import org.springframework.stereotype.Service;

import com.attmng.dto.MemberPasswordChangeDTO;

@Service
public interface MemberPasswordChangeService {

	public MemberPasswordChangeDTO User_read(MemberPasswordChangeDTO dto) throws Exception;

	public void G05_Update(String id, String password) throws Exception;
}
