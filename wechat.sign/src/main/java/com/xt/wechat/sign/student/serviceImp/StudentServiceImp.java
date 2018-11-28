package com.xt.wechat.sign.student.serviceImp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.wechat.sign.student.dao.StudentMapper;
import com.xt.wechat.sign.student.entity.Classes;
import com.xt.wechat.sign.student.entity.Course;
import com.xt.wechat.sign.student.entity.Resign;
import com.xt.wechat.sign.student.entity.Sign;
import com.xt.wechat.sign.student.entity.Student;
import com.xt.wechat.sign.student.service.StudentService;
import com.xt.wechat.sign.teacher.dao.TeacherMapper;
import com.xt.wechat.sign.teacher.entity.Location;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentMapper sm;
	
	@Autowired
	private TeacherMapper tm;
	
	public Student getStudentByStuNo(String stuNo) {

		return sm.getStudentByStuNo(stuNo);
	}

	public Classes getClass(Integer classId) {
		return sm.getClass(classId);
	}

	public void updateStuAndClass(Student stu, Classes cla) {
		sm.updateStudent(stu);	
		sm.updateClass(cla);
	}

	public void doSign(Integer courseId, String stuNo, String monthTime, Course course) {
//		Course course = sm.getCouerseById(courseId);
		Sign sign = sm.getSignByCourseNo(course.getCourseNo(), stuNo, monthTime);
		System.out.println("------------------------------------->"+sign);
		if(sign == null){
			sm.insertRegister(new Sign(stuNo,course.getCourseNo(),monthTime,1));
		}else if(sign.getMonthTime().equals(monthTime)){
			sign.setTimes(sign.getTimes() + 1);
			sm.doSign(sign);
		}else{
			sign.setMonthTime(monthTime);
			sm.insertRegister(sign);
		}
	}

	public void addSign(Integer courseId, String stuNo, String reason) {
		sm.addSign(stuNo, sm.getCouerseById(courseId).getCourseNo(), sm.getStudentByStuNo(stuNo).getStuClassId(), reason);
	}

	public List<Sign> getSignDetail(Integer courseId, String stuNo) {
		return sm.getSignDetail(sm.getCouerseById(courseId).getCourseNo(), stuNo);
	}

	public Set<String> getStuNoByCourseNo(String courseNo) {
		return sm.getStuNoByCourseNo(courseNo);
	}

	public List<Student> getStudentsByStuNos(Set<String> stuNos) {
		return sm.getStudentsByStuNo(stuNos);
	}

	public List<Resign> getStuNoByResign(String courseNo, Integer classId) {
		return sm.getStuNoByResign(courseNo, classId);
	}

	public List<Student> getStuNoByStuNos(List<String> stuNos) {
		return sm.getStudentsByStuNos(stuNos);
	}

	public Location getLocationByTeacherNo(String teacherNo) {
		return tm.getLocationByTeacherNo(teacherNo);
	}

	@Override
	public Course getCourseById(Integer courseId) {
		return sm.getCouerseById(courseId);
	}

	@Override
	public String getRegByStuNo(String stuNo) {
		return sm.getRegByStuNo(stuNo);
	}

	@Override
	public void insertRegByStuNo(String courseNo, String stuNo,String teacherNo) {
		sm.insertRegByStuNo(courseNo, stuNo, teacherNo);
	}

	@Override
	public void deleteRegByStuNo(String teacherNo) {
		sm.deleteRegByStuNo(teacherNo);
	}

}
