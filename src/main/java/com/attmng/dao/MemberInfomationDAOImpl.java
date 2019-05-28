package com.attmng.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.attmng.dto.MemberInfomationDTO;

@Repository
public class MemberInfomationDAOImpl implements MemberInfomationDAO {

	private static final String namespace = "com.attmng.atms.mappers.member";

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<MemberInfomationDTO> getMembersInfo() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".get_membersInfo");
	}

	@Override
	public List<MemberInfomationDTO> getMemberInfo(String name) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> infoMap = new HashMap<String, Object>();
		infoMap.put("name", name);

		return sqlSession.selectList(namespace + ".get_memberInfo", infoMap);
	}
}
