package com.attmng.domain;

public class WorkflowVO {

	   private String id;
	   private String key_year_month;
	   private String commit_date;
	   private String commit_name;
	   private int status;
	   private String memo;
	   
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey_year_month() {
		return key_year_month;
	}
	public void setKey_year_month(String key_year_month) {
		this.key_year_month = key_year_month;
	}
	public String getCommit_date() {
		return commit_date;
	}
	public void setCommit_date(String commit_date) {
		this.commit_date = commit_date;
	}
	public String getCommit_name() {
		return commit_name;
	}
	public void setCommit_name(String commit_name) {
		this.commit_name = commit_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
	   
	   
