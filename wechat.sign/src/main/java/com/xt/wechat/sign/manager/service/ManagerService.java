package com.xt.wechat.sign.manager.service;

import java.util.List;
import java.util.Set;

import com.xt.wechat.sign.manager.entity.Announcement;
import com.xt.wechat.sign.manager.entity.Worker;
import com.xt.wechat.sign.student.entity.Course;
import com.xt.wechat.sign.student.entity.Student;
import com.xt.wechat.sign.teacher.entity.SignMessage;
import com.xt.wechat.sign.teacher.entity.Teacher;

public interface ManagerService {

	public Worker getWorkerInfo(String workerNo);
	
	public void insertAnnouncement(String item, String text);

	public List<Announcement> getAnnouncement();
	
	public List<Teacher> getTeachersBySub(String courseName);
	
	public List<Teacher> getTeachersByName(String teacherName);
	
	public Set<String> getCollegeNames();

	public List<Student> getStudentByClassIds(String collegeName);

	public List<Student> getStudentsByName(String studentName);
	
	public List<Course> getCourseByClassNo(Integer classNo);
	
	public List<SignMessage> getSignMSGOne(String stuNo, String courseNo);
	
	public void updateTeacherAndCourse(String teacherName,String teacherWork,String teacherNo,String courseName,String courseNo);

	public void deleteTeacher(String teacherNo);

	public void deleteStudent(String stuNo);

}
