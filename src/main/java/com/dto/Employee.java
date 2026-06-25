package com.dto;

public class Employee {
	private Integer id;
    private String name;
    private String job;
    private Double salary;
    public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	private Integer dept_no;
    private String CreatedAt;
    private String mail;
    private String password;
    
    public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + ", dept_no=" + dept_no
				+ ", CreatedAt=" + CreatedAt + ", mail=" + mail + ", password=" + password + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(String createdAt) {
		CreatedAt = createdAt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public Integer getDept_no() {
		return dept_no;
	}
	public void setDept_no(Integer dept_no) {
		this.dept_no = dept_no;
	}
	   
}
