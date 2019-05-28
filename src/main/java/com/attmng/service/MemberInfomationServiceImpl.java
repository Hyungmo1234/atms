package com.attmng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.attmng.dao.MemberInfomationDAO;
import com.attmng.dto.MemberInfomationDTO;

@Service
public class MemberInfomationServiceImpl implements MemberInfomationService{

	@Autowired
	MemberInfomationDAO MemberInfomationDAO;
	
	@Override
	public List<MemberInfomationDTO> getMembersInfomation() throws Exception {
		// TODO Auto-generated method stub
		return MemberInfomationDAO.getMembersInfo();
	}

	@Override
	public List getMemberInfomation(String name) throws Exception {
		// TODO Auto-generated method stub
		
		return MemberInfomationDAO.getMemberInfo(name);
	}
}
