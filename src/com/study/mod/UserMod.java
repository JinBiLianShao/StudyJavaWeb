package com.study.mod;
/*
 * 管理员模板
 */
import java.io.Serializable;
public class UserMod implements Serializable{
	private String username; //用户名
	private String password; //密码
	private String name; //管理员姓名
	
	public UserMod(){}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}
