package com.xt.wechat.sign.student.entity;

import java.io.Serializable;

public class Student implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8603371700587823572L;

	private Integer stuId;
	
	private String stuNo;
	
	private Integer stuClassId;
	
	private String stuName;
	
	private String stuCard;
	
	private String stuPhone;
	
	private String stuEmail;
	
	private String stuPasswd;

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public Integer getStuClassId() {
		return stuClassId;
	}

	public void setStuClassId(Integer stuClassId) {
		this.stuClassId = stuClassId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuCard() {
		return stuCard;
	}

	public void setStuCard(String stuCard) {
		this.stuCard = stuCard;
	}

	public String getStuPhone() {
		return stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public String getStuPasswd() {
		return stuPasswd;
	}

	public void setStuPasswd(String stuPasswd) {
		this.stuPasswd = stuPasswd;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuNo=" + stuNo + ", stuClassId=" + stuClassId + ", stuName=" + stuName
				+ ", stuCard=" + stuCard + ", stuPhone=" + stuPhone + ", stuEmail=" + stuEmail + ", stuPasswd="
				+ stuPasswd + "]";
	}
	
}
