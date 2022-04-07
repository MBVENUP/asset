package com.sprint1.assets.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Table")
public class User implements Serializable {
	@Id
	@Column(name = "user_Id")
	private int userId;
	@Column(name = "user_Name")
	private String userName;
	@Column(name = "role")
	private String role;
	@Column(name = "user_Password")
	private String userPassword;

	public User() {

	}

	public User(int userId, String userName, String role, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.role = role;
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", role=" + role + ", userPassword=" + userPassword
				+ "]";
	}

}
