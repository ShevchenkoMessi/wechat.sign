package com.xt.wechat.sign.teacher.serviceImp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.wechat.sign.student.entity.Classes;
import com.xt.wechat.sign.student.entity.Course;
import com.xt.wechat.sign.student.entity.Sign;
import com.xt.wechat.sign.teacher.dao.TeacherMapper;
import com.xt.wechat.sign.teacher.entity.SignMessage;
import com.xt.wechat.sign.teacher.entity.Teacher;
import com.xt.wechat.sign.teacher.service.TeacherService;

@Service
public class TeacherServiceImp implements TeacherService{
	
	@Autowired
	private TeacherMapper tm;

	public Teacher getTeacherByTeacherNo(String teacherNo) { 
		return tm.getTeacherByTeacherNo(teacherNo);
	}

	public Classes getClassByClassNo(String classNo) {
		return tm.getClassByClassNo(classNo);
	}

	public List<Course> getCourseByTeacherNo(String teacherNo) {
		return tm.getCourseByTeacherNo(teacherNo);
	}

	public List<Classes> getClassesByCourseNo(String courseNo) {
		return tm.getClassesByCourseNo(courseNo);
	}

	public List<SignMessage> getMessageHistory(Set<String> stuNos, String courseNo) {
		return tm.getMessageHistory(stuNos,courseNo);
	}

	public List<SignMessage> getMessageMonthTime(Set<String> stuNos, Integer monthTime, String courseNo) {
		return tm.getMessageMonthTime(stuNos, monthTime,courseNo);
	}

	public void doRegister(String stuNo, String monthTime, String courseNo) {
		Sign sign = tm.getSignByStuNoAndMonthTime(stuNo, monthTime,courseNo);
		System.out.println("sign: " + sign);
		if(sign != null){
			tm.addTimesByStuNo(stuNo, sign.getTimes()+1, monthTime,courseNo);
		}
		tm.deleteResignByStuNo(stuNo, courseNo);
	}

	public void doAllRegister(Set<String> stuNos, String monthTime, String courseNo) {
		tm.deleteAll(stuNos, courseNo);
	}

	public void refuseOne(String stuNo, String courseNo) {
		tm.deleteResignByStuNo(stuNo, courseNo);
	}

	public void insertLocationByTeacherNo(String teacherNo, double latitude, double longitude) {
		tm.insertLocationByTeacherNo(teacherNo, latitude, longitude);
	}

	public void deleteLocation(String teacherNo){
		tm.deleteLocation(teacherNo);
	}

}
