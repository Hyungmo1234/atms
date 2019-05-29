package com.attmng.dao;

import java.util.ArrayList;
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
	public List<MemberInformationDTO> getMembersInfo(String Adm_code, String ComName_ryak) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> infoMap1 = new HashMap<String, Object>();
		List<String> comNameList = new ArrayList<>();
		if (Adm_code != null) {
			switch (Adm_code) {
			case "0000":
				comNameList.add("GCS");
				comNameList.add("NUVO");
				comNameList.add("CSS");
				comNameList.add("FOS");
				comNameList.add("PSS");
				comNameList.add("ISS");
				break;
			case "0100":
				comNameList.add("GCS");
				comNameList.add("NUVO");
				comNameList.add("CSS");
				break;
			case "0200":
				comNameList.add("FOS");
				comNameList.add("PSS");
				comNameList.add("ISS");
				break;
			case "1000":
				comNameList.add("GCS");
				break;
			case "2000":
				comNameList.add("NUVO");
				break;
			case "3000":
				comNameList.add("CSS");
				break;
			case "4000":
				comNameList.add("FOS");
				break;
			case "5000":
				comNameList.add("PSS");
				break;
			case "6000":
				comNameList.add("ISS");
				break;
			default:break;
			}
		}
		infoMap1.put("comNameList", comNameList);
		return sqlSession.selectList(namespace + ".get_membersInfo", infoMap1);
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
