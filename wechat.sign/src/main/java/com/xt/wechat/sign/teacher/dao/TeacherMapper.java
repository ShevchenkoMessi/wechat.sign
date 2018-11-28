package com.xt.wechat.sign.teacher.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.xt.wechat.sign.student.entity.Classes;
import com.xt.wechat.sign.student.entity.Course;
import com.xt.wechat.sign.student.entity.Sign;
import com.xt.wechat.sign.teacher.entity.Location;
import com.xt.wechat.sign.teacher.entity.SignMessage;
import com.xt.wechat.sign.teacher.entity.Teacher;

public interface TeacherMapper {
	
	public Teacher getTeacherByTeacherNo(String teacherNo);
	
	public Classes getClassByClassNo(String classNo);
	
	public List<Course> getCourseByTeacherNo(String teacherNo);
	
	public List<Classes> getClassesByCourseNo(String courseNo);
	
	public List<SignMessage> getMessageHistory(@Param("set")Set<String> stuNos, @Param("courseNo")String courseNo);
 
	public List<SignMessage> getMessageMonthTime(@Param("set")Set<String> stuNos, @Param("monthTime")Integer monthTime, @Param("courseNo")String courseNo);
	
	//补签功能 ,同意一个
	public void deleteResignByStuNo(@Param("stuNo")String stuNo, @Param("courseNo")String courseNo);
	
	public Sign getSignByStuNoAndMonthTime(@Param("stuNo")String stuNo, @Param("monthTime")String monthTime, @Param("courseNo")String courseNo);

	public void addTimesByStuNo(@Param("stuNo")String stuNo, @Param("times")Integer times, @Param("monthTime")String monthTime, @Param("courseNo")String courseNo);	
	
	//补签功能 ,同意全部
	public void addTimesByStuNos(@Param("list")List<String> stuNos, @Param("monthTime")String monthTime, @Param("courseNo")String courseNo);
	
	public void deleteAll(@Param("list")Set<String> stuNos, @Param("courseNo")String courseNo);

	//获取教师地理位置
	public void insertLocationByTeacherNo(@Param("teacherNo")String teacherNo, @Param("latitude")double latitude, @Param("longitude")double longitude);

	public Location getLocationByTeacherNo(String teacherNo);
	
	public void deleteLocation(String teacherNo);
	
}
