package com.xt.wechat.sign.teacher.entity;

public class Location {

	private Integer id;

	private String teacherNo;
	
	private double teacherLatitude;
	
	private double teacherLongitude;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public double getTeacherLatitude() {
		return teacherLatitude;
	}

	public void setTeacherLatitude(double teacherLatitude) {
		this.teacherLatitude = teacherLatitude;
	}

	public double getTeacherLongitude() {
		return teacherLongitude;
	}

	public void setTeacherLongitude(double teacherLongitude) {
		this.teacherLongitude = teacherLongitude;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", teacherNo=" + teacherNo + ", teacherLatitude=" + teacherLatitude
				+ ", teacherLongitude=" + teacherLongitude + "]";
	}

}
