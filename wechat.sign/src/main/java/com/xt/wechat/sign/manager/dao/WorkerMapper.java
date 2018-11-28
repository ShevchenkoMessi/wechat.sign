package com.xt.wechat.sign.manager.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.xt.wechat.sign.manager.entity.Announcement;
import com.xt.wechat.sign.manager.entity.Worker;
import com.xt.wechat.sign.student.entity.Course;
import com.xt.wechat.sign.student.entity.Student;
import com.xt.wechat.sign.teacher.entity.SignMessage;
import com.xt.wechat.sign.teacher.entity.Teacher;

public interface WorkerMapper {

	public Worker getWorkerInfo(String workerNo);
	
	public void insertAnnouncement(@Param("item")String item, @Param("text")String text);

	public List<Announcement> getAnnouncement();
	
	//教师查询
	public Set<String> getTeacherNoByCourse(String courseName);
	
	public List<Teacher> getTeachersBySub(@Param("set")Set<String> teacherNo);

	public List<Teacher> getTeachersByName(String teacherName);
	
	//学生查询
	public Set<String> getCollegeNames();
	
	public Set<Integer> getClassIds(String collegeNames);
	
	public List<Student> getStudentByClassIds(@Param("set")Set<Integer> classIds);

	public List<Student> getStudentsByName(String studentName);
	
	public List<Course> getCourseByClassNo(Integer classNo);
	
	public List<SignMessage> getSignMSGOne(@Param("stuNo")String stuNo, @Param("courseNo")String courseNo); 
	
	public void updateTeacher(@Param("teacherName")String teacherName,@Param("teacherWork")String teacherWork,@Param("teacherNo")String teacherNo);

	public void updateCourse(@Param("teacherNo")String teacherNo,@Param("courseName")String courseName,@Param("courseNo")String courseNo);

	public void deleteTeacher(String teacherNo);

	public void deleteStudent(String stuNo);

}
