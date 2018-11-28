package com.xt.wechat.sign.student.entity;

public class Course {
	
	private Integer courseId;
	
	private String courseNo;
	
	private String teacherNo;
	
	private String classNo;
	
	private String courseName;
	
	private Integer courseTime;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(Integer courseTime) {
		this.courseTime = courseTime;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseNo=" + courseNo + ", teacherNo=" + teacherNo + ", classNo="
				+ classNo + ", courseName=" + courseName + ", courseTime=" + courseTime + "]";
	}
	
}
