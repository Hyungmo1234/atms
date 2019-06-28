package com.attmng.dao;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WorkflowDAOImpl implements WorkflowDAO {

	private static final String namespace = "com.attmng.atms.mappers.workflow";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void workflowUpdate(String id, String key_year_month, String commit_date, String commit_name, int status, String memo) throws Exception {
		Map<String, Object> paraMap = new HashMap<String, Object>();

		paraMap.put("id", id);
		paraMap.put("key_year_month", key_year_month);
		paraMap.put("commit_date", commit_date);
		paraMap.put("commit_name", commit_name);
		paraMap.put("status", status);
		paraMap.put("memo", memo);

		sqlSession.selectList(namespace + ".workflowUpdate", paraMap);
	}

	@Override
	public int WorkflowGET(String id, String key_year_month, int status) throws Exception {
		
		Map<String, Object> paraMap = new HashMap<String, Object>();

		paraMap.put("id", id);
		paraMap.put("key_year_month", key_year_month);
		paraMap.put("status", status);

		return sqlSession.insert(namespace + ".workflowUpdate", paraMap);
	}
	
	public int Workflow_ok(String commit_name, String commit_date, int status, String id) throws Exception {
		
		Map<String, Object> paraMap = new HashMap<String, Object>();

		paraMap.put("commit_name", commit_name);
		paraMap.put("commit_date", commit_date);
		paraMap.put("status", status);
		paraMap.put("id", id);
		

		return sqlSession.update(namespace + ".workflow_okUpdate", paraMap);
	}
	
    public int Workflow_cancel(String commit_name, String commit_date, int status, String id) throws Exception {
      
      Map<String, Object> paraMap = new HashMap<String, Object>();

      paraMap.put("commit_name", commit_name);
      paraMap.put("commit_date", commit_date);
      paraMap.put("status", status);
      paraMap.put("id", id);

      return sqlSession.update(namespace + ".workflow_CancelUpdate", paraMap);
  }

	public int workflowcheck(String id) {
		
		return sqlSession.selectOne(namespace + ".workflowcheck", id);
		
	}
	
	public String workflowfeedback(String id) {
		
		return sqlSession.selectOne(namespace + ".workflowfeedback", id);
		
	}

	
	@Override
	public void workflowInput(String id, String key_year_month, int status) throws Exception {
		// TODO Auto-generated method stub
	}
	
    public int Workflow_ok(String commit_name, String commit_date, int status) throws Exception {
      // TODO Auto-generated method stub
      return 0;
    }
  
    public int Workflow_cancel(String commit_name, String commit_date, int status) throws Exception{
      return 0;
    }
    
}
