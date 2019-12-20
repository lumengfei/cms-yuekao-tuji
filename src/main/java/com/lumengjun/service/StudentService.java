package com.lumengjun.service;

import java.util.List;

import javax.validation.Valid;

import com.github.pagehelper.PageInfo;
import com.lumengjun.entity.City;
import com.lumengjun.entity.Course;
import com.lumengjun.entity.Provinces;
import com.lumengjun.entity.Student;


public interface StudentService {

	PageInfo<Student> getStudentpage(int page);

	List<Provinces> getProvinces();

	List<Course> getCourse();

	List<City> getcity(int id);

	Student getIdNumber(String idNumber);

	void addStudent(@Valid Student student, int[] cid);

	Student getStudentId(int id);

	void updateStudent(@Valid Student student, int[] cid);

}
