package com.attmng.domain;

public class VacationManagementVO {

	private String id           ;
	private String yearmonth    ;
	private String index        ;
	private String vac_startdate;
	private String vac_enddate  ;
	private String division     ;
	private String detail       ;
	private String holi_work    ;
	private String con_time     ;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYearmonth() {
		return yearmonth;
	}
	public void setYearmonth(String yearmonth) {
		this.yearmonth = yearmonth;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getVac_startdate() {
		return vac_startdate;
	}
	public void setVac_startdate(String vac_startdate) {
		this.vac_startdate = vac_startdate;
	}
	public String getVac_enddate() {
		return vac_enddate;
	}
	public void setVac_enddate(String vac_enddate) {
		this.vac_enddate = vac_enddate;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getHoli_work() {
		return holi_work;
	}
	public void setHoli_work(String holi_work) {
		this.holi_work = holi_work;
	}
	public String getCon_time() {
		return con_time;
	}
	public void setCon_time(String con_time) {
		this.con_time = con_time;
	}
}
