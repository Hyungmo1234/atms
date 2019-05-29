package com.attmng.dto;


public class EmployeeDTO {
	private String id;
    private String password;
    private String emp_name;
    private String pos_name;
    private String comName_ryak;
    private String dep_name;
    private String adm_code;
    
	public String getAdm_code() {
		return adm_code;
	}
	public void setAdm_code(String adm_code) {
		this.adm_code = adm_code;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getPos_name() {
		return pos_name;
	}
	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}
	public String getComName_ryak() {
		return comName_ryak;
	}
	public void setComName_ryak(String comName_ryak) {
		this.comName_ryak = comName_ryak;
	}
}
