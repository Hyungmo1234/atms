package com.attmng.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.attmng.dto.MemberAttendanceDTO;
import com.attmng.dto.MemberInformationDTO;

@Repository
public class MemberInformationDAOImpl implements MemberInformationDAO {

	private static final String namespace = "com.attmng.atms.mappers.member";

	@Inject
	private SqlSession sqlSession;

	@Override
	public List<MemberInformationDTO> getMembersInfo() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".get_membersInfo");
	}

	@Override
	public List<MemberInformationDTO> getMemberInfo(String name) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> infoMap = new HashMap<String, Object>();
		infoMap.put("name", name);

		return sqlSession.selectList(namespace + ".get_memberInfo", infoMap);
	}

	@Override
	public List<MemberAttendanceDTO> getMemberAttendance(Map<String, Object> sqlData) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList(namespace + ".get_memberAttendance", sqlData);
	}
}
