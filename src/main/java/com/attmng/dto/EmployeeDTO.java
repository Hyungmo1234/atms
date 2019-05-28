package com.attmng.dto;


public class EmployeeDTO {
	private String id;
    private String password;
    private String emp_name;
    private String dep_name;
    private String pos_name1;
    private String com_name3;

	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public String getPos_name1() {
		return pos_name1;
	}
	public void setPos_name1(String pos_name1) {
		this.pos_name1 = pos_name1;
	}
	public String getCom_name3() {
		return com_name3;
	}
	public void setCom_name3(String com_name3) {
		this.com_name3 = com_name3;
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
}
