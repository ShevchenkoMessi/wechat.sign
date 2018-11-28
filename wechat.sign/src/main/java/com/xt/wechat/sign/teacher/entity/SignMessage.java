package com.xt.wechat.sign.teacher.entity;

public class SignMessage {

	private Integer messageId;
	
	private String stuNo;
	
	private String courseNo;
	
	private String monthTime;
	
	private Integer times;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
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
		return "SignMessage [messageId=" + messageId + ", stuNo=" + stuNo + ", courseNo=" + courseNo + ", monthTime="
				+ monthTime + ", times=" + times + "]";
	}
	
}
