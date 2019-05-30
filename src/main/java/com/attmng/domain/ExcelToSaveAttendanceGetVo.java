package com.attmng.domain;

import java.sql.Time;

public class ExcelToSaveAttendanceGetVo {
	
	private String emp_name;
	private String dep_code;
	private String dep_name;
	private String key_year_month;
	private String key_day;
	private Time s_time;
	private Time e_time;
	private double br_time;
	private double op_time;
	private String wco_name;
	
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getDep_code() {
		return dep_code;
	}
	public void setDep_code(String dep_code) {
		this.dep_code = dep_code;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public String getKey_year_month() {
		return key_year_month;
	}
	public void setKey_year_month(String key_year_month) {
		this.key_year_month = key_year_month;
	}
	public String getKey_day() {
		return key_day;
	}
	public void setKey_day(String key_day) {
		this.key_day = key_day;
	}
	public Time getS_time() {
		return s_time;
	}
	public void setS_time(Time s_time) {
		this.s_time = s_time;
	}
	public Time getE_time() {
		return e_time;
	}
	public void setE_time(Time e_time) {
		this.e_time = e_time;
	}
	public double getBr_time() {
		return br_time;
	}
	public void setBr_time(double br_time) {
		this.br_time = br_time;
	}
	public double getOp_time() {
		return op_time;
	}
	public void setOp_time(double op_time) {
		this.op_time = op_time;
	}
	public String getWco_name() {
		return wco_name;
	}
	public void setWco_name(String wco_name) {
		this.wco_name = wco_name;
	}
	
}
