package com.attmng.domain;

public class AttendanceVO {

	private String id;
	private String key_year_month;
	private String key_day;
	private String s_time;
	private String e_time;
	private double br_time;
	private double op_time;
	private String notice;
	private String wco_name;
	private String remarks;
	private String reg_id;
	private String reg_date;
	private String upd_id;
	private String upd_date;
	private int del_cd;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey_year_month() {
		return key_year_month;
	}

	public void setKey_year_month(String year_month) {
		this.key_year_month = year_month;
	}

	public String getKey_Day() {
		return key_day;
	}

	public void setKey_Day(String day) {
		this.key_day = day;
	}

	public String getS_time() {
		return s_time;
	}

	public void setS_time(String s_time) {
		this.s_time = s_time;
	}

	public String getE_time() {
		return e_time;
	}

	public void setE_time(String e_time) {
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

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getWco_name() {
		return wco_name;
	}

	public void setWco_name(String wco_name) {
		this.wco_name = wco_name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getUpd_id() {
		return upd_id;
	}

	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}

	public String getUpd_date() {
		return upd_date;
	}

	public void setUpd_date(String upd_date) {
		this.upd_date = upd_date;
	}

	public int getDel_cd() {
		return del_cd;
	}

	public void setDel_cd(int del_cd) {
		this.del_cd = del_cd;
	}

}
