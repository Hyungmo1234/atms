package com.attmng.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attmng.domain.AdminSetVO;
import com.attmng.domain.ExcelToSaveAttendanceGetVo;
import com.attmng.dto.ExcelToSaveAttendanceGetDTO;

@Repository
public class ExcelDAOImpl implements ExcelDAO {
	private static final String namespace = "com.attmng.atms.mappers.excelMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ExcelToSaveAttendanceGetDTO> ExcelGet(String sessionID, String key_year_month) throws Exception {
		
		Map<String, Object> paraMap = new HashMap<String, Object>();

		paraMap.put("id", sessionID);
		paraMap.put("key_year_month", key_year_month);
		
		return sqlSession.selectList(namespace+ ".getExcelInfo", paraMap);
	}

}
