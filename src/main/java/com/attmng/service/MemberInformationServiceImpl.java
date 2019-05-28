package com.attmng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.attmng.dao.MemberInformationDAO;
import com.attmng.dto.MemberInformationDTO;

@Service
public class MemberInformationServiceImpl implements MemberInformationService{

	@Autowired
	MemberInformationDAO MemberInformationDAO;
	
	@Override
	public List<MemberInformationDTO> getMembersInformation() throws Exception {
		// TODO Auto-generated method stub
		return MemberInformationDAO.getMembersInfo();
	}

	@Override
	public List<MemberInformationDTO> getMemberInformation(String name) throws Exception {
		// TODO Auto-generated method stub
		
		return MemberInformationDAO.getMemberInfo(name);
	}
}
