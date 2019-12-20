package com.lumengjun.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lumengjun.dao.StudentMapper;
import com.lumengjun.entity.City;
import com.lumengjun.entity.Course;
import com.lumengjun.entity.Provinces;
import com.lumengjun.entity.Student;
import com.lumengjun.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentMapper studentMapper;

	@Override
	public PageInfo<Student> getStudentpage(int page) {
		PageHelper.startPage(page, 3);
		
		return new PageInfo<Student>(studentMapper.getStudentpage());
	}

	@Override
	public List<Provinces> getProvinces() {
		// TODO Auto-generated method stub
		return studentMapper.getProvinces();
	}

	@Override
	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		return studentMapper.getCourse();
	}

	@Override
	public List<City> getcity(int id) {
		// TODO Auto-generated method stub
		return studentMapper.getccity(id);
	}

	@Override
	public Student getIdNumber(String idNumber) {
		// TODO Auto-generated method stub
		return studentMapper.getIdNumber(idNumber);
	}

	@Override
	public void addStudent(@Valid Student student, int[] cid) {
		studentMapper.addStudent(student);
		for (int i : cid) {
			studentMapper.addStudentCourse(student.getId(),i);
		}
	}

	@Override
	public Student getStudentId(int id) {
		// TODO Auto-generated method stub
		return studentMapper.getStudentId(id);
	}

	@Override
	public void updateStudent(@Valid Student student, int[] cid) {
		studentMapper.deleteStudentCourse(student.getId());
		studentMapper.updateStudent(student);
		for (int i : cid) {
			studentMapper.addStudentCourse(student.getId(),i);
		}
		
	}
	
}
