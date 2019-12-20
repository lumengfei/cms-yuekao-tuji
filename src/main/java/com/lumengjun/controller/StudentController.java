package com.lumengjun.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lumengjun.entity.City;
import com.lumengjun.entity.Course;
import com.lumengjun.entity.Provinces;
import com.lumengjun.entity.Student;
import com.lumengjun.service.StudentService;
import com.lumengjun.utils.StudentUtils;

/**
 * 
 * @author ASUS
 *
 */
@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue="1")int page,HttpServletRequest request){
		PageInfo<Student> pageinfostudent =studentService.getStudentpage(page); 
		for (Student student : pageinfostudent.getList()) {
			System.out.println(student);
		} 
		request.setAttribute("pageinfostudent", pageinfostudent);
		return "list";
	}
	
	@RequestMapping("toadd")
	public String toadd(HttpServletRequest request){
		List<Provinces> provinces = studentService.getProvinces();
		request.setAttribute("provinces",provinces);
		List<Course> courses =studentService.getCourse();
		request.setAttribute("courses",courses);
		request.setAttribute("student", new Student());
		return "add";
	}
	
	@RequestMapping("getcity")
	@ResponseBody
	public Object getcity(int id){
		List<City> list =studentService.getcity(id);
		return list;
		
	}
	
	@RequestMapping("add")
	public String add(@Valid @ModelAttribute("student")Student student,BindingResult result,
			int[] cid,
			HttpServletRequest request){
		
		if(cid.length<1){
			
			result.rejectValue("courses", "s", "课程不可为空");
			
		}
		if(student.getCity().getId()==null || student.getCity().getId()==0){
			result.rejectValue("provinces", "s", "市不可为空");
		}
		if(student.getProvinces().getId()==null || student.getProvinces().getId()==0){
			result.rejectValue("provinces", "s", "省份不可为空");
		}
		if(student.getCounty().getId()==null || student.getCounty().getId()==0){
			result.rejectValue("provinces", "s", "县份不可为空");
		}
		if(StudentUtils.isIdNumber(student.getIdNumber())){
			Student stu = studentService.getIdNumber(student.getIdNumber());
			if(stu!=null){
				result.rejectValue("idNumber", "", "身份证号已存在");
			}
		}else{
			result.rejectValue("idNumber", "", "身份证号不符合规则");
		}
		if(result.hasErrors()){
			List<Provinces> provinces = studentService.getProvinces();
			request.setAttribute("provinces",provinces);
			List<Course> courses =studentService.getCourse();
			request.setAttribute("courses",courses);
			request.setAttribute("student", student);
			return "add";
		}
		
		studentService.addStudent(student,cid);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("toupdate")
	public String toupdate(int id,HttpServletRequest request){
		Student studentId = studentService.getStudentId(id);
		List<Provinces> provinces = studentService.getProvinces();
		request.setAttribute("provinces",provinces);
		List<City> citys =studentService.getcity(studentId.getProvinces().getId());
		request.setAttribute("citys",citys);
		List<City> cityc =studentService.getcity(studentId.getCity().getId());
		request.setAttribute("cityc",cityc);
		List<Course> courses =studentService.getCourse();
		request.setAttribute("courses",courses);
		request.setAttribute("student", studentId);
		return "update";
		}
	
	
	@RequestMapping("update")
	public String update(@Valid @ModelAttribute("student")Student student,BindingResult result,
			int[] cid,
			HttpServletRequest request){
		
		if(cid.length<1){
			
			result.rejectValue("courses", "s", "课程不可为空");
			
		}
		if(student.getCity().getId()==null || student.getCity().getId()==0){
			result.rejectValue("provinces", "s", "市不可为空");
		}
		if(student.getProvinces().getId()==null || student.getProvinces().getId()==0){
			result.rejectValue("provinces", "s", "省份不可为空");
		}
		if(student.getCounty().getId()==null || student.getCounty().getId()==0){
			result.rejectValue("provinces", "s", "县份不可为空");
		}
		Student studentcId = studentService.getStudentId(Integer.parseInt(student.getId()));
		if(studentcId.getIdNumber()!=student.getIdNumber()){
		if(student.getIdNumber()!=null){
			if(StudentUtils.isIdNumber(student.getIdNumber())){
				Student stu = studentService.getIdNumber(student.getIdNumber());
				if(stu!=null){
					result.rejectValue("idNumber", "", "身份证号已存在");
				}
			}else{
				result.rejectValue("idNumber", "", "身份证号不符合规则");
			}
			
		}
		}
		
		if(result.hasErrors()){
			List<Provinces> provinces = studentService.getProvinces();
			request.setAttribute("provinces",provinces);
			List<Course> courses =studentService.getCourse();
			request.setAttribute("courses",courses);
			request.setAttribute("student", student);
			return "update";
		}
		
		studentService.updateStudent(student,cid);
		
		return "redirect:list";
	}
	
	
}
