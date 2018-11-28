package com.xt.wechat.sign.student.entity;

public class Sign {

	private Integer signId;
	
	private String stuNo;
	
	private String courseNo;
	
	private String monthTime;
	
	private Integer times;
	
	public Sign(){
		super();
	}

	public Sign(String stuNo, String courseNo, String monthTime, Integer times) {
		super();
		this.stuNo = stuNo;
		this.courseNo = courseNo;
		this.monthTime = monthTime;
		this.times = times;
	}

	public Integer getSignId() {
		return signId;
	}

	public void setSignId(Integer signId) {
		this.signId = signId;
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

	public String getMonthTime() {
		return monthTime;
	}

	public void setMonthTime(String monthTime) {
		this.monthTime = monthTime;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	@Override
	public String toString() {
		return "Sign [signId=" + signId + ", stuNo=" + stuNo + ", courseNo=" + courseNo + ", monthTime=" + monthTime
				+ ", times=" + times + "]";
	}
	
}
