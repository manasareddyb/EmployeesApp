package com.dto;

public class Department {
	 @Override
	public String toString() {
		return "Department [dept_no=" + dept_no + ", dept_name=" + dept_name + ", location=" + location + "]";
	}
	 private Integer dept_no;
     private String dept_name;
     private String location;
     
    public Integer getDept_no() {
		return dept_no;
	}
	public void setDept_no(Integer dept_no) {
		this.dept_no = dept_no;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}	 
}
