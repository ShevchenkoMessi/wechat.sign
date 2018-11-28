package com.xt.wechat.sign.student.entity;

import java.io.Serializable;

public class Classes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4083896961710299602L;

	private Integer classId;
	
	private Integer classNo;
	
	private String monitorName;
	
	private String monitorTel;
	
	private Integer stuCount;
	
	private String college;
	
	private String profession;
	
	private String university;

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getClassNo() {
		return classNo;
	}

	public void setClassNo(Integer classNo) {
		this.classNo = classNo;
	}

	public String getMonitorName() {
		return monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public String getMonitorTel() {
		return monitorTel;
	}

	public void setMonitorTel(String monitorTel) {
		this.monitorTel = monitorTel;
	}

	public Integer getStuCount() {
		return stuCount;
	}

	public void setStuCount(Integer stuCount) {
		this.stuCount = stuCount;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "Class [classId=" + classId + ", classNo=" + classNo + ", monitorName=" + monitorName + ", monitorTel="
				+ monitorTel + ", stuCount=" + stuCount + ", college=" + college + ", profession=" + profession
				+ ", university=" + university + "]";
	}

}
