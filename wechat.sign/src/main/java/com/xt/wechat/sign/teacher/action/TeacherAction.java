package com.xt.wechat.sign.teacher.action;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xt.wechat.sign.student.entity.Classes;
import com.xt.wechat.sign.student.entity.Course;
import com.xt.wechat.sign.student.entity.Resign;
import com.xt.wechat.sign.student.entity.Student;
import com.xt.wechat.sign.student.service.StudentService;
import com.xt.wechat.sign.teacher.entity.SignMessage;
import com.xt.wechat.sign.teacher.entity.Teacher;
import com.xt.wechat.sign.teacher.serviceImp.TeacherServiceImp;


@SuppressWarnings({ "unused" })
@Controller
public class TeacherAction {
	
	@Autowired
	private TeacherServiceImp tsi;
	
	@Autowired
	private StudentService ss;
	
	ObjectMapper om = null;

	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private Writer out;

	List<Integer> timesList = null; 

	private Map<String, String> map;
		
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
	
	@RequestMapping("/getTeacherInfo")
	public void getTeacherByTeacherNo(@RequestParam(name="userNo")String teacherNo, @RequestParam(name="password")String passwd) throws JsonProcessingException, IOException{
		Teacher teacher = tsi.getTeacherByTeacherNo(teacherNo);
		if(teacher == null){
			out.write("账号或密码错误");
		}else if(teacher.getTeacherPasswd().equals(passwd)){
				List<Course> course = tsi.getCourseByTeacherNo(teacher.getTeacherNo());
				Classes classes = tsi.getClassByClassNo(course.get(0).getClassNo());
				this.om = new ObjectMapper();
				this.out.write("[" + om.writeValueAsString(teacher) + "," + om.writeValueAsString(classes) +"," + om.writeValueAsString(course) + "]");
		}else{
			out.write("账号或密码错误");
		}
		this.closeOut();
	}
	
	@RequestMapping("/getClassesByCourseNo")
	public void getClassesByCourseNo(String courseNo) throws JsonProcessingException, IOException{
		List<Classes> classes = tsi.getClassesByCourseNo(courseNo);
		this.om = new ObjectMapper();
		this.out.write(om.writeValueAsString(classes));
		this.closeOut();
	}
	
	@RequestMapping("/getMessageHistory")
	public void getMessageHistory(String courseNo, Integer classId) throws IOException{
		System.out.println(courseNo+"+++++++++++++++"+classId);
		Set<String> stuNos = ss.getStuNoByCourseNo(courseNo);
		if(stuNos.size() == 0){
			out.write("无信息");
		}else if(stuNos != null){
			List<Student> stus = ss.getStudentsByStuNos(stuNos);
			List<SignMessage> msgs = tsi.getMessageHistory(stuNos,courseNo);
			if(msgs.size()==0)
				out.write("无信息");
			this.timesList = new LinkedList<>();
			for(int i=0; i<stuNos.size(); i++){
				int times = 0;
				for(int i1=0; i1<msgs.size(); i1++){
					if(stus.get(i).getStuNo().equals(msgs.get(i1).getStuNo())){
						times = times + msgs.get(i1).getTimes();
					}
				}
				timesList.add(times);
			}
			for(int index=0;index<stus.size();index++){
				if(stus.get(index).getStuClassId()!=classId){
					stus.remove(index);
					timesList.remove(index);
				}
			}
			this.om = new ObjectMapper();
			this.map = new HashMap<>();
			map.put("stus", om.writeValueAsString(stus));
			map.put("msgs", om.writeValueAsString(timesList));
			this.out.write(om.writeValueAsString(map));
		}else{
			this.out.write("无签到信息");
		}
		this.closeOut();
	}
	
	@RequestMapping("/getMessageMonth")
	public void getMessagesMonthTime(String courseNo, Integer monthTime, Integer classId) throws Exception{
		System.out.println(courseNo+"+++++++++++++++"+monthTime+"+++++++++++++++"+classId);
		Set<String> stuNos = ss.getStuNoByCourseNo(courseNo);
		if(stuNos.size() == 0){
			out.write("");
		}else if(stuNos != null){
			List<Student> stus = ss.getStudentsByStuNos(stuNos);
			List<SignMessage> msgs = tsi.getMessageMonthTime(stuNos, monthTime, courseNo);
			List<Student> stus1 = new LinkedList<>();
			List<SignMessage> msgs1 = new LinkedList<>();
			System.out.println(stus);
			System.out.println(msgs);
			if(msgs.size()==0)
				out.write("");
			for(int i=0;i<msgs.size();i++){
				for(int j=0;j<stus.size();j++){
					if(msgs.get(i).getStuNo().equals(stus.get(j).getStuNo())){
						stus1.add(stus.get(j));
						msgs1.add(msgs.get(i));
					}
				}
			}
			for(int index=0;index<stus1.size();index++){
				if(stus1.get(index).getStuClassId()!=classId){
					stus1.remove(index);
					msgs1.remove(index);
				}
			}
			System.out.println(stus1);
			System.out.println(msgs1);
			this.om = new ObjectMapper();
			this.map = new HashMap<>();
			map.put("stus", om.writeValueAsString(stus1));
			map.put("msgs", om.writeValueAsString(msgs1));
			this.out.write(om.writeValueAsString(map));
		}else{
			this.out.write("无签到信息");
		}
		this.closeOut();
	}
	
	@RequestMapping("/getAddMSG")
	public void getResignMSG(@RequestParam(name="courseNo")String courseNo, @RequestParam(name="classId")Integer classId) throws Exception{
		List<String> stuNos = new LinkedList<>();
		List<Resign> resigns = ss.getStuNoByResign(courseNo, classId);
		if(resigns != null && resigns.size() != 0){
			for(int index=0;index<resigns.size();index++){
				stuNos.add(resigns.get(index).getStuNo());
			}
			List<Student> stus = ss.getStuNoByStuNos(stuNos);
			map = new HashMap<>();
			om = new ObjectMapper();
			map.put("stus", om.writeValueAsString(stus));
			map.put("megs", om.writeValueAsString(resigns));
			this.out.write(om.writeValueAsString(map));
		}else{
			this.out.write("无信息");
		}
		this.closeOut();
	}
	
	@RequestMapping("/agreeOne")
	public void agreeOne(String stuNo, Integer monthTime, String courseNo){
		System.out.println(monthTime.toString() + "============>" + courseNo + "--------------->" +stuNo);
		tsi.doRegister(stuNo, monthTime.toString(), courseNo);
	}
	
	@RequestMapping("/agreeAll")
	public void agreeAll(@RequestParam(name = "stuNos")Set<String> stuNos, Integer monthTime, String courseNo){
		tsi.doAllRegister(stuNos, monthTime.toString(), courseNo);
	}

	@RequestMapping("/refuseOne")
	public void refuseOne(String stuNo, String courseNo){
		tsi.refuseOne(stuNo, courseNo);
	}
	
	@RequestMapping("/getTeacherLocation")
	public void getTeacherLocation(String teacherNo, double latitude, double longitude){
		System.out.println(teacherNo + "------------" + latitude + "==========" + longitude);
		tsi.insertLocationByTeacherNo(teacherNo, latitude, longitude);
	}
	
	@RequestMapping("deleteLocation")
	public void deleteLocation(String teacherNo){
		tsi.deleteLocation(teacherNo);
		ss.deleteRegByStuNo(teacherNo);
	}
	
}
