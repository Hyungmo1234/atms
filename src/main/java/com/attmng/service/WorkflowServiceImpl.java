package com.attmng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.attmng.dao.WorkflowDAO;


@Repository
public class WorkflowServiceImpl implements WorkflowService {

  @Autowired
  private WorkflowDAO dao;

  @Override
  public void WorkflowUpdate(String id, String key_year_month, String commit_date,
      String commit_name, int status, String memo) throws Exception {
    dao.workflowUpdate(id, key_year_month, commit_date, commit_name, status, memo);
  }

  @Override
  public int WorkflowGET(String sessionID, String key_year_month, int status) throws Exception {
    return dao.WorkflowGET(sessionID, key_year_month, status);
  }


  @Override
  public int workflowcheck(String id) throws Exception {
    return dao.workflowcheck(id);
  }

  @Override
  public String workflowfeedback(String id) throws Exception {
    return dao.workflowfeedback(id);
  }

  @Override
  public int Workflow_ok(String commit_name, String commit_date, int status, String id)
      throws Exception {

    return dao.Workflow_ok(commit_name, commit_date, status, id);

  }

  @Override
  public int Workflow_cancel(String commit_name, String commit_date, int status, String id)
      throws Exception {
    return dao.Workflow_cancel(commit_name, commit_date, status, id);
  }
  
}
