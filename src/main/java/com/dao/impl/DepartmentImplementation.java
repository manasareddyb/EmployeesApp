package com.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.inf.DepartmentDAO;
import com.dto.Department;
import com.dto.Employee;
import com.utility.Connector;

public class DepartmentImplementation implements DepartmentDAO {
	
	private Connection con;
	public DepartmentImplementation(){
		this.con=Connector.requestConnection();
	}
    
	@Override
	public void adddept(Department d) {
		// TODO Auto-generated method stub
		String query="insert into department values(0,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,d.getDept_name());
			ps.setString(2,d.getLocation());
			ps.executeUpdate();
			System.out.println("Data added SuccessFully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Filed to add Data");
		}
	}



	@Override
	public List<Department> findAll() {
		 String query="select * from department";
		 List<Department> l=new ArrayList<>();
		 Department d=null;
		 try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
		    while(rs.next()) {
		    	d=new Department();
		    	d.setDept_no(rs.getInt("dept_no"));
		    	d.setDept_name(rs.getString("dept_name"));
		    	d.setLocation(rs.getString("location"));
		    	l.add(d);
		    }
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}


	@Override
	public void updateDept(Department d) {
		String query="update Department set dept_Name=?,location=? where dept_no=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, d.getDept_name());
			ps.setString(2, d.getLocation());
			ps.setInt(3, d.getDept_no());
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void deleteDept(Integer dno) {
		String query="delete from department where dept_no=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,dno);
			ps.executeUpdate();
			System.out.println("data deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to delete Data");
		}
		
	}

	@Override
	public Department findbyId(Integer dno) {
		Department d=null;
		String query="Select * from department where dept_no=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, dno);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				d=new Department();
				d.setDept_no(rs.getInt("dept_no"));
				d.setDept_name(rs.getString("dept_name"));
				d.setLocation(rs.getString("Location"));		
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return d;	
	}

}
