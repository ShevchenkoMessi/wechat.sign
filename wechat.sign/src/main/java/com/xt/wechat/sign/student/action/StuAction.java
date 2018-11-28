package com.xt.wechat.sign.student.action;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xt.wechat.sign.student.entity.Classes;
import com.xt.wechat.sign.student.entity.Course;
import com.xt.wechat.sign.student.entity.Sign;
import com.xt.wechat.sign.student.entity.Student;
import com.xt.wechat.sign.student.serviceImp.StudentServiceImp;
import com.xt.wechat.sign.teacher.entity.Location;

@Controller
public class StuAction {

	@Autowired
	private StudentServiceImp ssi;
	
	@SuppressWarnings("unused")
	private HttpServletRequest request;
	
	@SuppressWarnings("unused")
	private HttpServletResponse response;
	
	private Writer out;
	
	private double EARTH_RADIUS = 6378.137;  
    
    private double rad(double d) {  
        return d * Math.PI / 180.0;  
    } 
		
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
	
	@RequestMapping("/getStuInfo")
	public void getAllstuInfo(@RequestParam(name="stuNo")String stuNo, @RequestParam(name="password")String passwd) throws IOException{
		System.out.println(stuNo+"-----------------"+passwd);
		Student stuInfo = ssi.getStudentByStuNo(stuNo);
		if(stuInfo == null){
			out.write("账号或密码错误");
		}else if(stuInfo.getStuPasswd().equals(passwd)){
			Classes classInfo = ssi.getClass(stuInfo.getStuClassId());
//		System.out.println("=======>" + classInfo);
			ObjectMapper om = new ObjectMapper();
			System.out.println("+++++++++++++++++>" + om.writeValueAsString(stuInfo));
			out.write("[" + om.writeValueAsString(stuInfo) + "," + om.writeValueAsString(classInfo) + "]");
			//	out.write(om.writeValueAsString(classInfo));
		}else{
			out.write("账号或密码错误");
		}
		this.closeOut();
	}
	
	@RequestMapping("/updateStuInfo")
	public void updateStuInfo(String stu,String classes) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper om = new ObjectMapper();
//		System.out.println(stuAndClass);
		Student student = om.readValue(stu, Student.class);
		Classes cla = om.readValue(classes, Classes.class);
		System.out.println(student);
		System.out.println(cla);
		ssi.updateStuAndClass(student,cla);
	}
	
	public void doSign(Integer courseId, String stuNo, String monthTime, Course course){
		ssi.doSign(courseId, stuNo, monthTime, course);
	}
	
	@RequestMapping("/addSign")
	public void addSign(Integer courseId,String stuNo, String reason){
		ssi.addSign(courseId, stuNo, reason);
	}
	
	@RequestMapping("/querySign")
	public void querySign(Integer courseId,String stuNo) throws Exception{
		System.out.println(courseId + "-----------" + stuNo);
		List<Sign> signDetail = ssi.getSignDetail(courseId, stuNo);
		ObjectMapper om = new ObjectMapper();
//		System.out.println(om.writeValueAsString(signDetail));
		out.write(om.writeValueAsString(signDetail));
		this.closeOut();
	}
	
	@RequestMapping("/getLocationByTeacherNo")
	public void getLocationByTeacherNo(Integer courseId, double stuLatitude, double stuLongitude, String stuNo, String monthTime) throws JsonProcessingException, IOException{
		Course course = ssi.getCourseById(courseId);
		System.out.println("stuLatitude:" +stuLatitude+"stuLongitude"+stuLongitude);
		Location location = ssi.getLocationByTeacherNo(course.getTeacherNo());
		double lam = rad(stuLatitude)-rad(location.getTeacherLatitude());
		double lom = rad(stuLongitude)-rad(location.getTeacherLongitude());
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(lam / 2), 2)  
                + Math.cos(stuLatitude) * Math.cos(location.getTeacherLongitude())  
                * Math.pow(Math.sin(lom / 2), 2)));
		s = s * EARTH_RADIUS;  
        s = Math.round(s * 10000d) / 10000d;  
        s = s*1000; 
//		System.out.println("courseId:"+courseId+" stuLatitude:"+stuLatitude+"stuLongitude: "+stuLongitude+"stuNo: "+stuNo+"monthTime: "+monthTime);
		System.out.println("hahahahahahah" + ssi.getRegByStuNo(stuNo).equals("0"));
		if(s <= 10){
			if(ssi.getRegByStuNo(stuNo).equals("0")){
				ssi.insertRegByStuNo(course.getCourseNo(), stuNo,course.getTeacherNo());
				this.doSign(courseId, stuNo, monthTime, course);
			}else{
				this.out.write("请到教室签到");
			}
		}else{
			this.out.write("请到教室签到");
		}
	}
}
