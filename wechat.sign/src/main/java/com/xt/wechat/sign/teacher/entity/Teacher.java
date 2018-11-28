package com.xt.wechat.sign.teacher.entity;

import java.io.Serializable;

public class Teacher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6340546043757032112L;

	private Integer teacherId;
	
	private String teacherNo;
	
	private String teacherName;
	
	private String teacherCard;
	
	private String teacherPhone;

	private String teacherEmail;
	
	private String teacherWork;
	
	private String teacherStudy;
	
	private String teacherPath;
	
	private String teacherPasswd;

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherCard() {
		return teacherCard;
	}

	public void setTeacherCard(String teacherCard) {
		this.teacherCard = teacherCard;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getTeacherWork() {
		return teacherWork;
	}

	public void setTeacherWork(String teacherWork) {
		this.teacherWork = teacherWork;
	}

	public String getTeacherStudy() {
		return teacherStudy;
	}

	public void setTeacherStudy(String teacherStudy) {
		this.teacherStudy = teacherStudy;
	}

	public String getTeacherPath() {
		return teacherPath;
	}

	public void setTeacherPath(String teacherPath) {
		this.teacherPath = teacherPath;
	}

	public String getTeacherPasswd() {
		return teacherPasswd;
	}

	public void setTeacherPasswd(String teacherPasswd) {
		this.teacherPasswd = teacherPasswd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherNo=" + teacherNo + ", teacherName=" + teacherName
				+ ", teacherCard=" + teacherCard + ", teacherPhone=" + teacherPhone + ", teacherEmail=" + teacherEmail
				+ ", teacherWork=" + teacherWork + ", teacherStudy=" + teacherStudy + ", teacherPath=" + teacherPath
				+ ", teacherPasswd=" + teacherPasswd + "]";
	}
	
}
