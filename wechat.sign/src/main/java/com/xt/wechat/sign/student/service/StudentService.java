package com.xt.wechat.sign.student.service;

import java.util.List;
import java.util.Set;


import com.xt.wechat.sign.student.entity.Classes;
import com.xt.wechat.sign.student.entity.Course;
import com.xt.wechat.sign.student.entity.Resign;
import com.xt.wechat.sign.student.entity.Sign;
import com.xt.wechat.sign.student.entity.Student;
import com.xt.wechat.sign.teacher.entity.Location;

public interface StudentService {

	public Student getStudentByStuNo(String stuNo);
	
	public Classes getClass(Integer classId);
	
	public void updateStuAndClass(Student stu, Classes cla);
	
	public void doSign(Integer courseId, String stuNo, String monthTime, Course course);
	
	public void addSign(Integer courseId,String stuNo, String reason);
	
	public List<Sign> getSignDetail(Integer courseId, String stuNo);
	
	public Set<String> getStuNoByCourseNo(String courseNo);
	
	public List<Student> getStudentsByStuNos(Set<String> stuNos);

	public List<Resign> getStuNoByResign(String courseNo, Integer classId);
	
	public List<Student> getStuNoByStuNos(List<String> stuNos);
	
	public Location getLocationByTeacherNo(String teacherNo);
	
	public Course getCourseById(Integer courseId);
	
	public String getRegByStuNo(String stuNo);

	public void insertRegByStuNo(String courseNo,String stuNo,String teacherNo);
	
	public void deleteRegByStuNo(String teacherNo);
	
}
