package com.attmng.dto;


/*
 * table�뜝�럡愿닷뜝�럡苡밧뜝�럡苡폛TO�뜝�럡�럩岳묒빘裕�占쎈빋�뜝�럡愿쇔뜝�럡苡룟뜝�럡愿쒎뜝�럡援드뜝�럡愿드뜝�럡肄℡뜝�룞�삕
 */
public class EmployeeDTO {
   private String id;
    private String password;
    private String emp_name;
    private String dep_name;
    private String pos_name;
    private String comName_ryak;
    private String adm_code;
    private String mail;
    private int gender;
    private String entry_date;
    private String cellphone;
    private String address;
    
   public String getMail() {
      return mail;
   }
   public void setMail(String mail) {
      this.mail = mail;
   }
   public int getGender() {
      return gender;
   }
   public void setGender(int gender) {
      this.gender = gender;
   }
   public String getEntry_date() {
      return entry_date;
   }
   public void setEntry_date(String entry_date) {
      this.entry_date = entry_date;
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
   public String getAdm_code() {
      return adm_code;
   }
   public void setAdm_code(String adm_code) {
      this.adm_code = adm_code;
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
   public String getDep_name() {
      return dep_name;
   }
   public void setDep_name(String dep_name) {
      this.dep_name = dep_name;
   }
}