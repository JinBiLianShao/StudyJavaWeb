package com.study.mod;
/*
 * VO类(学生数据)
 */
import java.io.Serializable;
public class Mod implements Serializable{
	private String id; //学号
	private String name; //姓名
	private String sex; //性别
	private String dept; //班级
	
	public Mod(){}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
