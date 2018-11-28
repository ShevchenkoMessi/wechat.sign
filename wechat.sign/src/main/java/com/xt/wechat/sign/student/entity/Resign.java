package com.xt.wechat.sign.student.entity;

public class Resign {

	private Integer resignId;
	
	private String stuNo;
	
	private String courseNo;
	
	private String classId;
	
	private String reason;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getResignId() {
		return resignId;
	}

	public void setResignId(Integer resignId) {
		this.resignId = resignId;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Resign [resignId=" + resignId + ", stuNo=" + stuNo + ", courseNo=" + courseNo + ", classId=" + classId
				+ ", reason=" + reason + "]";
	}

	
}
