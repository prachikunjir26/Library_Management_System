package com.webtools.springproject.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "User")
	public class User {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int userID;
		private String UserName;
		private String UserPass;
		private String userType;
		
		
			
		public String getUserType() {
			return userType;
		}
		public void setUserType(String userType) {
			this.userType = userType;
		}
		public int getUserID() {
			return userID;
		}
		public void setUserID(int userID) {
			this.userID = userID;
		}
		public User() {
//			super();
		}
		public String getUserName() {
			return UserName;
		}
		public void setUserName(String userName) {
			UserName = userName;
		}
		public String getUserPass() {
			return UserPass;
		}
		public void setUserPass(String userPass) {
			UserPass = userPass;
		}
		

}
