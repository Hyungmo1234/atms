package com.attmng.service;

import java.util.List;

import com.attmng.dto.MemberInfomationDTO;

public interface MemberInfomationService {
	public List<MemberInfomationDTO> getMembersInfomation() throws Exception;
	public List<MemberInfomationDTO> getMemberInfomation(String name) throws Exception;
}
