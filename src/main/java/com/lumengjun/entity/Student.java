package com.lumengjun.entity;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * 学生表
 * @author ASUS
 *
 */
public class Student implements Serializable{
         /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String  id   ;
		 @NotBlank(message="姓名不可为空")
	     private String   name  ;//姓名
	     private int  gender  ;//性别
	     private Provinces   provinces =new Provinces();//所属省
	     private City   city =new  City();// 所属市
	     private County   county=new  County() ;//所属县
	     private String    birth ;//出生年份
	     private String    date ;//入学日期
	     private String    hobby ;//爱好
	     @NotNull(message="身高不可为空")
	    // @Size(max=250,min=85,message="身高必须大于85且小于250")
	     @Max(200)
	     @Min(20)
	     private Integer    height ;//身高
	     
	     @NotNull(message="体重不可为空")
	     //@Size(max=200,min=30,message="体重必须大于30 小于200")
	     @Max(200)
	     @Min(20)
	     private Integer   weight ;//体重
	     //@Pattern(regexp="^//d{17}[x|X|0-9]$")
	     private String    idNumber ;//身份证编号
	     private List<Course> courses;
	     
	     
	     
	     
		public List<Course> getCourses() {
			return courses;
		}
		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getGender() {
			return gender;
		}
		public void setGender(int gender) {
			this.gender = gender;
		}
		public Provinces getProvinces() {
			return provinces;
		}
		public void setProvinces(Provinces provinces) {
			this.provinces = provinces;
		}
		public City getCity() {
			return city;
		}
		public void setCity(City city) {
			this.city = city;
		}
		public County getCounty() {
			return county;
		}
		public void setCounty(County county) {
			this.county = county;
		}
		public String getBirth() {
			return birth;
		}
		public void setBirth(String birth) {
			this.birth = birth;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getHobby() {
			return hobby;
		}
		public void setHobby(String hobby) {
			this.hobby = hobby;
		}
		public Integer getHeight() {
			return height;
		}
		public void setHeight(Integer height) {
			this.height = height;
		}
		public Integer getWeight() {
			return weight;
		}
		public void setWeight(Integer weight) {
			this.weight = weight;
		}
		public String getIdNumber() {
			return idNumber;
		}
		public void setIdNumber(String idNumber) {
			this.idNumber = idNumber;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", gender="
					+ gender + ", provinces=" + provinces + ", city=" + city
					+ ", county=" + county + ", birth=" + birth + ", date="
					+ date + ", hobby=" + hobby + ", height=" + height
					+ ", weight=" + weight + ", idNumber=" + idNumber
					+ ", courses=" + courses + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((birth == null) ? 0 : birth.hashCode());
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result
					+ ((county == null) ? 0 : county.hashCode());
			result = prime * result + ((date == null) ? 0 : date.hashCode());
			result = prime * result + gender;
			result = prime * result
					+ ((height == null) ? 0 : height.hashCode());
			result = prime * result + ((hobby == null) ? 0 : hobby.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result
					+ ((idNumber == null) ? 0 : idNumber.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result
					+ ((provinces == null) ? 0 : provinces.hashCode());
			result = prime * result
					+ ((weight == null) ? 0 : weight.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			if (birth == null) {
				if (other.birth != null)
					return false;
			} else if (!birth.equals(other.birth))
				return false;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (county == null) {
				if (other.county != null)
					return false;
			} else if (!county.equals(other.county))
				return false;
			if (date == null) {
				if (other.date != null)
					return false;
			} else if (!date.equals(other.date))
				return false;
			if (gender != other.gender)
				return false;
			if (height == null) {
				if (other.height != null)
					return false;
			} else if (!height.equals(other.height))
				return false;
			if (hobby == null) {
				if (other.hobby != null)
					return false;
			} else if (!hobby.equals(other.hobby))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (idNumber == null) {
				if (other.idNumber != null)
					return false;
			} else if (!idNumber.equals(other.idNumber))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (provinces == null) {
				if (other.provinces != null)
					return false;
			} else if (!provinces.equals(other.provinces))
				return false;
			if (weight == null) {
				if (other.weight != null)
					return false;
			} else if (!weight.equals(other.weight))
				return false;
			return true;
		}
	     
	     
	     
}
