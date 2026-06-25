package com.dao.inf;

import java.util.List;

import com.dto.Department;

public interface DepartmentDAO {
	void adddept(Department d);
    List<Department> findAll();
    void updateDept(Department d);
    void deleteDept(Integer dno);
    Department findbyId(Integer dno);
}

