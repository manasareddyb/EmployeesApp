package com.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.inf.EmployeeDAO;
import com.dto.Employee;
import com.utility.Connector;

public class EmployeeImplementation implements EmployeeDAO {
	private Connection con;
	public EmployeeImplementation(){
		this.con=Connector.requestConnection();
	}

	@Override
	public void addEmployee(Employee e) {
		String query="insert into employee values(0,?,?,?,?,SYSDATE(),?,?)";
		 try {
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1,e.getName());
			st.setString(2, e.getJob());
			st.setDouble(3, e.getSalary());
			st.setInt(4, e.getDept_no());
			st.setString(5, e.getMail());
			st.setString(6, e.getPassword());
			st.executeUpdate();
			System.out.println("Data added Successfully");		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("failed to add data");
		}
		
	}

	@Override
	public Employee findById(Integer id) {
		Employee e=null;
		String query="Select * from employee where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				e=new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setJob(rs.getString("job"));
				e.setSalary(rs.getDouble("salary"));
				e.setDept_no(rs.getInt("dept_no"));
				e.setCreatedAt(rs.getString("Created_at"));
				e.setMail(rs.getString("mail"));
				
				e.setPassword(rs.getString("password"));
				
				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
		
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		List<Employee> l=new ArrayList<>();
		Employee e=null;
		String query="Select * from employee ";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				e=new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setJob(rs.getString("job"));
				e.setSalary(rs.getDouble("salary"));
				e.setDept_no(rs.getInt("Dept_no"));
				e.setCreatedAt(rs.getString("Created_at"));
				e.setMail(rs.getString("mail"));
				
				e.setPassword(rs.getString("password"));
				l.add(e);
				
				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return l;
	}

	@Override
	public Employee findByMailAndPassword(String mail, String password) {
		Employee e1=null;
		String query="Select * from Employee where mail=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,mail);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				e1=new Employee();
				e1.setId(rs.getInt("id"));
				e1.setName(rs.getString("name"));
				e1.setJob(rs.getString("job"));
				e1.setSalary(rs.getDouble("salary"));
				e1.setDept_no(rs.getInt("dept_no"));
				e1.setCreatedAt(rs.getString("created"
						+ "_at"));
				e1.setMail(rs.getString("mail"));
				e1.setPassword(rs.getString("password"));
				
				
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		return e1;
	}

	@Override
	public void updateEmployee(Employee e) {
		String query="update Employee set Name=?,Job=?,Salary=?,Dept_no=?,mail=?,password=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, e.getName());
			ps.setString(2, e.getJob());
			ps.setDouble(3, e.getSalary());
			ps.setInt(4, e.getDept_no());
			ps.setString(5, e.getMail());
			ps.setString(6, e.getPassword());
			ps.setInt(7, e.getId());
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee e1=null;
		String query="delete from employee where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			
				
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
	}

	@Override
	public Employee findbyMail(String mail) {
		Employee e1=null;
		String query="Select * from Employee where mail=? ";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,mail);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				e1=new Employee();
				e1.setId(rs.getInt("id"));
				e1.setName(rs.getString("name"));
				e1.setJob(rs.getString("job"));
				e1.setSalary(rs.getDouble("salary"));
				e1.setDept_no(rs.getInt("dept_no"));
				e1.setCreatedAt(rs.getString("created"
						+ "_at"));
				e1.setMail(rs.getString("mail"));
				e1.setPassword(rs.getString("password"));
				
				
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		return e1;
	}

	

}

