package com.xt.wechat.sign.teacher.service;

import java.util.List;
import java.util.Set;

import com.xt.wechat.sign.student.entity.Classes;
import com.xt.wechat.sign.student.entity.Course;
import com.xt.wechat.sign.teacher.entity.SignMessage;
import com.xt.wechat.sign.teacher.entity.Teacher;

public interface TeacherService {

	public Teacher getTeacherByTeacherNo(String teacherNo);
	
	public Classes getClassByClassNo(String classNo);
	
	public List<Course> getCourseByTeacherNo(String teacherNo);
	
	public List<Classes> getClassesByCourseNo(String courseNo);
	
	public List<SignMessage> getMessageHistory(Set<String> stuNos, String courseNo);
	
	public List<SignMessage> getMessageMonthTime(Set<String> stuNos, Integer monthTime, String courseNo);
	
	public void doRegister(String stuNo, String monthTime, String courseNo);

	public void doAllRegister(Set<String> stuNos, String monthTime, String courseNo);
	
	public void refuseOne(String stuNo, String courseNo);
	
	public void insertLocationByTeacherNo(String teacherNo, double latitude, double longitude);
	
	public void deleteLocation(String teacherNo);
	
}
