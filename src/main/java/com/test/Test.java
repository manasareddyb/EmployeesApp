package com.test;
import java.util.List;
import java.sql.SQLException;
import java.util.Scanner;

import com.dao.impl.DepartmentImplementation;
import com.dao.impl.EmployeeImplementation;
import com.dto.Department;
import com.dto.Employee;
import com.dao.inf.DepartmentDAO;
import com.dao.inf.EmployeeDAO;

public class Test {

	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			  Employee e=new Employee();
			  EmployeeDAO EDAO=new EmployeeImplementation();
			  DepartmentDAO EDAO1=new DepartmentImplementation();
			  System.out.println("welcome to Employee portal");
			  System.out.println("enter your mail Id");
			  String mail=sc.next();
			  System.out.println("enter your password");
			  String password=sc.next();
			  e=EDAO.findByMailAndPassword(mail,password);
			  if(e!=null) {
				  
				  if(e.getId()==1) {
					  System.out.println("1. Add Employee");
					  System.out.println("2. Delete Employee");
					  System.out.println("3. veiw all Employees");
					  System.out.println("4. Add Deparment");
					  System.out.println("5. Delete Department");
					  System.out.println("6. veiw all Departments");
					  System.out.println("7.Exit");
					 
					  int choice1=sc.nextInt();
					  switch(choice1) {
					  case 1:     Employee e1=new Employee();
								  System.out.println("enter the Name");
								  e1.setName(sc.next());
								  System.out.println("enter the job");
								  e1.setJob(sc.next());
								  System.out.println("enter the salary");
								  e1.setSalary(sc.nextDouble());
								  System.out.println("enter the Dept No");
								  e1.setDept_no(sc.nextInt());
								  System.out.println("enter the mail");
								  e1.setMail(sc.next());
								  System.out.println("enter the password");
								  e1.setPassword(sc.next()); 
								  EDAO.addEmployee(e1);
					              break;
					  case 2:  System.out.println("enter the id");
								  int id1=sc.nextInt();
								  EDAO.deleteEmployee(id1);
			                      break;
			                   
					  case 3:  List<Employee> res=EDAO.findAll();
							     for(Employee e4:res) {
									  System.out.println(e4);		  } 
					              break;
					  case 4:     Department d1=new Department();
								  System.out.println("enter the Name");
								  d1.setDept_name(sc.next());
								  System.out.println("enter the location");
								  d1.setLocation(sc.next());
					 
								  EDAO1.adddept(d1);
					              break;
					  case 5:  System.out.println("enter the id");
								  int did=sc.nextInt();
								  EDAO1.deleteDept(did);
			                      break;
                   
					  case 6:  List<Department> dres=EDAO1.findAll();
							     for(Department d:dres) {
									  System.out.println(d);		  } 
					              break;
					  case 7:  System.out.println("exit");
					            break;
					  default:  System.out.println("enter proper valid input");
					  
					  }
				  }
				  else {
					  System.out.println("1.view your profile");
					  System.out.println("2.Update your profile"); 
					  System.out.println("3.reset your password");
					  System.out.println("4.Exit");
					  int i=sc.nextInt();
					  switch(i) {
					     case 1: int id=e.getId();
							       Employee e3=EDAO.findById(id);
								   System.out.println(e3);
			                       break;
					     case 2:
						  int id1=e.getId();
						  Employee e5=EDAO.findById(id1);
						  System.out.println("1. Name");
						  System.out.println("2. job");
						  System.out.println("3. salary");
						  System.out.println("4. Dept_no");
						  System.out.println("5. mail");
						  System.out.println("6. Password");
						  int choice=sc.nextInt();
						  switch(choice) {
						  case 1:  System.out.println("enter the name need to be updated");
						            e5.setName(sc.next());
						            break;
						  case 2:  System.out.println("enter the job need to be updated");
				                   e5.setJob(sc.next());
				                   break;
						  case 3:  System.out.println("enter the salary need to be updated");
				                   e5.setSalary(sc.nextDouble());
				                   break;
				                   
						  case 4:  System.out.println("enter the Dept_No need to be updated");
						            e5.setDept_no(sc.nextInt());
						            break;
						  case 5:  System.out.println("enter the mail need to be updated");
						            e5.setMail(sc.next());
						            break;
						  case 6:  System.out.println("enter the password need to be updated");
						            e5.setPassword(sc.next());
						            break;
						  default:  System.out.println("enter proper valid input");
						  
						  }
						  EDAO.updateEmployee(e5);
						  System.out.println(e5);
						  break;
					     case 3:  int id3=e.getId();
						         Employee e6=EDAO.findById(id3);
						         System.out.println("Enter the password need to be updated");
						         String newPassword=sc.next();
						         e6.setPassword(newPassword);
						         EDAO.updateEmployee(e6);
								 System.out.println(e6);
								 break;
					     case 4: System.out.println("Exit");	
					             break;
					     default:  System.out.println("enter proper input"); 	  
	                       
					  }
					  
				  }
				  
			
			  }
			  else {
				  System.out.println("Failed to Login");
			  }
			  
	
			  
		
		  
		  

	}

}
