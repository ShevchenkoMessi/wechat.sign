package com.xt.wechat.sign.manager.serviceImp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.wechat.sign.manager.dao.WorkerMapper;
import com.xt.wechat.sign.manager.entity.Announcement;
import com.xt.wechat.sign.manager.entity.Worker;
import com.xt.wechat.sign.manager.service.ManagerService;
import com.xt.wechat.sign.student.entity.Course;
import com.xt.wechat.sign.student.entity.Student;
import com.xt.wechat.sign.teacher.entity.SignMessage;
import com.xt.wechat.sign.teacher.entity.Teacher;

@Service
public class ManagerServiceImp implements ManagerService{
	
	@Autowired
	private WorkerMapper wm;

	@Override
	public Worker getWorkerInfo(String workerNo) {
		return wm.getWorkerInfo(workerNo);
	}

	@Override
	public void insertAnnouncement(String item, String text) {
		wm.insertAnnouncement(item, text);
	}

	@Override
	public List<Announcement> getAnnouncement() {
		return wm.getAnnouncement();
	}

	@Override
	public List<Teacher> getTeachersBySub(String courseName) {
		Set<String> teacherNos = wm.getTeacherNoByCourse(courseName);
		System.out.println("++++++++++++++++++++++++++>" + teacherNos);
		if(teacherNos.size() != 0){
			return wm.getTeachersBySub(teacherNos);
		}
		return null;
	}

	@Override
	public List<Teacher> getTeachersByName(String teacherName) {
		return wm.getTeachersByName(teacherName);
	}

	@Override
	public Set<String> getCollegeNames() {
		return wm.getCollegeNames();
	}

	@Override
	public List<Student> getStudentByClassIds(String collegeName) {
		return wm.getStudentByClassIds(wm.getClassIds(collegeName));
	}

	@Override
	public List<Student> getStudentsByName(String studentName) {
		return wm.getStudentsByName(studentName);
	}

	@Override
	public List<Course> getCourseByClassNo(Integer classNo) {
		return wm.getCourseByClassNo(classNo);
	}

	@Override
	public List<SignMessage> getSignMSGOne(String stuNo, String courseNo) {
		return wm.getSignMSGOne(stuNo, courseNo);
	}

	@Override
	public void updateTeacherAndCourse(String teacherName, String teacherWork, String teacherNo, String courseName,String courseNo) {
		wm.updateTeacher(teacherName, teacherWork, teacherNo);
		wm.updateCourse(teacherNo, courseName,courseNo);
	}

	@Override
	public void deleteTeacher(String teacherNo) {
		wm.deleteTeacher(teacherNo);
	}

	@Override
	public void deleteStudent(String stuNo) {
		wm.deleteStudent(stuNo);
	}

}
