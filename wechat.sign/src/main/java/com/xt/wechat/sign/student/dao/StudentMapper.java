package com.xt.wechat.sign.student.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.xt.wechat.sign.student.entity.Classes;
import com.xt.wechat.sign.student.entity.Course;
import com.xt.wechat.sign.student.entity.Resign;
import com.xt.wechat.sign.student.entity.Sign;
import com.xt.wechat.sign.student.entity.Student;


public interface StudentMapper {
	
	public Classes getClass(Integer classId);

	public Student getStudentByStuNo(String stuNo);

	public List<Student> getStudentsByStuNo(@Param("set")Set<String> stuNos);
	
	public void updateStudent(Student stu);
	
	public void updateClass(Classes cla);
	
	public Course getCouerseById(Integer courseId);
	
	public Sign getSignByCourseNo(@Param("courseNo")String courseNo, @Param("stuNo")String stuNo, @Param("monthTime")String monthTime);
	
	public void doSign(Sign sign);
	
	public void insertRegister(Sign sign);
	
	public String getTeacherNoByCourseId(Integer courseId);
	
	public void addSign(@Param("stuNo")String stuNo, @Param("courseNo")String courseNo, @Param("classId") Integer classId, @Param("reason")String reason);

	public List<Sign> getSignDetail(@Param("courseNo")String courseNo, @Param("stuNo")String stuNo);

	public Set<String> getStuNoByCourseNo(String courseNo);

	public List<Student> getStudentsByStuNos(List<String> stuNos);

	public List<Resign> getStuNoByResign(@Param("courseNo")String courseNo, @Param("classId")Integer classId);

	public void insertStudent(Sign sign);
	
	public String getRegByStuNo(String stuNo);

	public void insertRegByStuNo(@Param("courseNo")String courseNo,@Param("stuNo")String stuNo,@Param("teacherNo")String teacherNo);
	
	public void deleteRegByStuNo(String teacherNo);

}
 