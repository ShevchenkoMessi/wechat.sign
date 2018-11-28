package com.xt.wechat.sign.manager.action;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xt.wechat.sign.manager.entity.Worker;
import com.xt.wechat.sign.manager.service.ManagerService;
import com.xt.wechat.sign.student.entity.Classes;
import com.xt.wechat.sign.student.entity.Course;
import com.xt.wechat.sign.student.entity.Student;
import com.xt.wechat.sign.student.service.StudentService;
import com.xt.wechat.sign.teacher.entity.Teacher;
import com.xt.wechat.sign.teacher.service.TeacherService;

@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService ms;

	@Autowired
	private TeacherService ts;

	@Autowired
	private StudentService ss;
	
	ObjectMapper om = null;
	
	List<Teacher> teachers;

	List<Student> students;

	@SuppressWarnings("unused")
	private HttpServletRequest request;
	
	@SuppressWarnings("unused")
	private HttpServletResponse response;
	
	private Writer out;
		
	public void closeOut() throws IOException{
		this.out.flush(); 
		this.out.close();
	}
	
	@ModelAttribute
	public void before(HttpServletRequest request, HttpServletResponse response) throws IOException{
		this.request =request;
		this.response =response;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setCharacterEncoding("UTF-8");
		this.out = response.getWriter(); 
	}
	
	@RequestMapping("/getWorkerInfo")
	public void getWorkerInfo(String workerNo, @RequestParam(name="password")String workerPasswd) throws Exception{
		System.out.println(workerNo+"-----------------"+workerPasswd);
//		Student stuInfo = ssi.getStudentByStuNo(stuNo);
		Worker workerInfo = ms.getWorkerInfo(workerNo);
		System.out.println("------------------->" + workerInfo);
		if(workerInfo == null){
			out.write("账号或密码错误");
		}else if(workerInfo.getWorkerPasswd().equals(workerPasswd)){
			om = new ObjectMapper();
			out.write(om.writeValueAsString(workerInfo));
		}else{
			out.write("账号或密码错误");
		}
		this.closeOut();
	}
	
	@RequestMapping("/insertAnnouncement")
	public void insertAnnouncement(String item, String text){
		System.out.println(item +"<--------------->"+ text);
		ms.insertAnnouncement(item, text);
	}
	
	@RequestMapping("/getAnnouncement")
	public void getAnnouncement() throws IOException{
		try {
			out.write(new ObjectMapper().writeValueAsString(ms.getAnnouncement()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.closeOut();
	}
	
	@RequestMapping("/getTeachersBySub")
	public void getTeachersBySub(String courseName) throws Exception{
		List<Teacher> teachers = ms.getTeachersBySub(courseName);
		if(teachers == null){
			out.write("无信息");
		}else{
			out.write(new ObjectMapper().writeValueAsString(teachers));
		}
		this.closeOut();
	}
	
	@RequestMapping("/getTeachers")
	public void getTeachers(String teacherNo, String teacherName) throws Exception{
		System.out.println(teacherNo +"==========="+teacherName );
		teachers = new LinkedList<>();
		if(!teacherNo.equals("")){
			Teacher teacher = ts.getTeacherByTeacherNo(teacherNo);
			if(teacher != null){
				teachers.add(teacher);
				out.write(new ObjectMapper().writeValueAsString(teachers));
			}else{
				out.write("无信息");
			}
		}else{
			teachers = ms.getTeachersByName(teacherName);
			if(teachers.size() == 0)
				out.write("无信息");
			else
				out.write(new ObjectMapper().writeValueAsString(teachers));
		}
		this.closeOut();
	}
	
	@RequestMapping("/getColleges")
	public void getColleges() throws JsonProcessingException, IOException{
		out.write(new ObjectMapper().writeValueAsString(ms.getCollegeNames()));
		this.closeOut();
	}

	@RequestMapping("/getStudentsByCollegeName")
	public void getStudentsByCollegeName(String collegeName) throws JsonProcessingException, IOException{
		System.out.println("------------------》" + collegeName);
		out.write(new ObjectMapper().writeValueAsString(ms.getStudentByClassIds(collegeName)));
		this.closeOut();
	}
	
	@RequestMapping("/getStudents")
	public void getStudents(String studentNo, String studentName) throws Exception{
		System.out.println(studentNo +"==========="+studentName );
		students = new LinkedList<>();
		if(!studentNo.equals("")){
			Student student = ss.getStudentByStuNo(studentNo);
			if(student != null){
				students.add(student);
				out.write(new ObjectMapper().writeValueAsString(students));
			}else{
				out.write("无信息");
			}
		}else{
			students = ms.getStudentsByName(studentName);
			if(students.size() == 0)
				out.write("无信息");
			else
				out.write(new ObjectMapper().writeValueAsString(students));
		}
		this.closeOut();
	}
	
	@RequestMapping("/getTeacherdetails")
	public void getTeacherdetails(String teacherNo) throws JsonProcessingException, IOException{
		Teacher teacher = ts.getTeacherByTeacherNo(teacherNo);
		List<Course> course = ts.getCourseByTeacherNo(teacherNo);
		Classes classes = ts.getClassByClassNo(course.get(0).getClassNo());
		Map<String, Object> map = new HashMap<>();
		map.put("teacher", teacher);
		map.put("course", course);
		map.put("classes", classes);
		out.write(new ObjectMapper().writeValueAsString(map));
		this.closeOut();
	}

	@RequestMapping("/getStudentdetails")
	public void getStudentdetails(String stuNo) throws JsonProcessingException, IOException{
		Student stu = ss.getStudentByStuNo(stuNo);
		Classes classes = ss.getClass(stu.getStuClassId());
		List<Course> courses = ms.getCourseByClassNo(classes.getClassNo());
		Map<String, Object> map = new HashMap<>();
		map.put("stu", stu);
		map.put("course", courses);
		map.put("classes", classes);
		out.write(new ObjectMapper().writeValueAsString(map));
		this.closeOut();
	}

	@RequestMapping("/getSubDetails")
	public void getSubDetails(String stuNo, String courseNo) throws JsonProcessingException, IOException{
		System.out.println(ms.getSignMSGOne(stuNo, courseNo));
		this.out.write(new ObjectMapper().writeValueAsString(ms.getSignMSGOne(stuNo, courseNo)));
		this.closeOut();
	}

	@RequestMapping("/updateTeacherByWorker")
	public void updateTeacherByWorker(String teacherName,String teacherWork,String teacherNo,String courseName,String courseNo){
		System.out.println(teacherName+"------"+teacherWork+"========"+teacherNo+"========="+ courseName+"========="+ courseNo);
		ms.updateTeacherAndCourse(teacherName, teacherWork, teacherNo, courseName,courseNo);
	}

	@RequestMapping("/deleteTeacher")
	public void deleteTeacher(String teacherNo){
		ms.deleteTeacher(teacherNo);
	}

	@RequestMapping("/deleteStudent")
	public void deleteStudent(String stuNo){
		ms.deleteStudent(stuNo);
	}

}
