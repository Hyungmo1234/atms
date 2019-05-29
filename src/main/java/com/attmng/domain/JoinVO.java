package com.attmng.domain;

public class JoinVO {
	//join
	private String id;
    private String password;
    private String emp_name;
    private String gender;
    
    private String entry_date;
    private String com_code;
    private String dep_code;
    private String pos_code;
    private String mail;
    private String cellphone;
    private String address;
    private String del_cd;

	public String getId() {
		return id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}
	public String getCom_code() {
		return com_code;
	}
	public void setCom_code(String com_code) {
		this.com_code = com_code;
	}
	public String getDep_code() {
		return dep_code;
	}
	public void setDep_code(String dep_code) {
		this.dep_code = dep_code;
	}
	public String getPos_code() {
		return pos_code;
	}
	public void setPos_code(String pos_code) {
		this.pos_code = pos_code;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getDel_cd() {
		return del_cd;
	}
	public void setDel_cd(String del_cd) {
		this.del_cd = del_cd;
	}
	
}
