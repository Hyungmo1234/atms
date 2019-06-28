package com.attmng.service;

import java.util.List;


import com.attmng.domain.WorkflowVO;

import com.attmng.dto.WorkflowDTO;

public interface WorkflowService {
	
  public int WorkflowGET(String sessionID, String key_year_month, int status) throws Exception;
  public int Workflow_ok(String commit_name, String commit_date, int status, String id) throws Exception;
  public int Workflow_cancel(String commit_name, String commit_date, int status, String id) throws Exception;
  
  public int workflowcheck(String id) throws Exception;
  public void WorkflowUpdate(String id, String key_year_month, String commit_date, String commit_name, int status, String memo) throws Exception;
  public String workflowfeedback(String id) throws Exception;

}
