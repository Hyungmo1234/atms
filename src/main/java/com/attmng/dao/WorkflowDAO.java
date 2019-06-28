package com.attmng.dao;

import org.springframework.stereotype.Service;

@Service
public interface WorkflowDAO {
  
  public void workflowUpdate(String id, String key_year_month, String commit_date, String commit_name, int status, String memo) throws Exception;
  public int WorkflowGET(String sessionID, String key_year_month, int status) throws Exception;
  public void workflowInput(String id, String key_year_month, int status) throws Exception;
  
  public int workflowcheck(String id) throws Exception;
  public int Workflow_ok(String commit_name, String commit_date, int status, String id) throws Exception;
  public int Workflow_cancel(String commit_name, String commit_date, int status, String id) throws Exception;

  public String workflowfeedback(String id) throws Exception;
}
