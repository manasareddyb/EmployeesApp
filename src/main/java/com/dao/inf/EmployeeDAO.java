package com.dao.inf;

import java.util.List;

import com.dto.Employee;

public interface EmployeeDAO {
      void addEmployee(Employee e);
      Employee findById(Integer id);
      List<Employee> findAll();
      Employee findByMailAndPassword(String mail,String password);
      Employee findbyMail(String mail);
      void updateEmployee(Employee e);
      void deleteEmployee(Integer id);
}
