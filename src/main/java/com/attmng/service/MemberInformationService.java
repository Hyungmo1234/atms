package com.attmng.service;

import java.util.List;

import com.attmng.dto.MemberInformationDTO;

public interface MemberInformationService {
	public List<MemberInformationDTO> getMembersInformation() throws Exception;
	public List<MemberInformationDTO> getMemberInformation(String name) throws Exception;
}
