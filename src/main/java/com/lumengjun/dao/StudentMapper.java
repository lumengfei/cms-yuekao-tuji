package com.lumengjun.dao;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lumengjun.entity.City;
import com.lumengjun.entity.Course;
import com.lumengjun.entity.Provinces;
import com.lumengjun.entity.Student;

public interface StudentMapper {

	List<Student> getStudentpage();

	@Select("SELECT * FROM city WHERE parent_id =0")
	List<Provinces> getProvinces();

	
	@Select("SELECT * FROM course")
	List<Course> getCourse();

	@Select("SELECT * FROM city WHERE parent_id=#{value}")
	List<City> getccity(int id);

	@Select("SELECT * FROM student WHERE idNumber=#{value}")
	Student getIdNumber(String idNumber);

	void addStudent(@Valid Student student);

	@Insert("INSERT INTO studentcourse VALUES(null,${id},#{i})")
	void addStudentCourse(@Param("id")String id,@Param("i") int i);

	Student getStudentId(int id);

	@Delete("DELETE FROM studentcourse WHERE student_id=${value}")
	void deleteStudentCourse(String id);

	@Update("UPDATE student SET name=#{name},gender=#{gender},provinces=#{provinces.id},"
			+ "city=#{city.id},county=#{county.id},birth=#{birth},hobby=#{hobby},height=#{height},"
			+ "weight=#{weight},idNumber=#{idNumber} WHERE id=${id}")
	void updateStudent(@Valid Student student);

}
