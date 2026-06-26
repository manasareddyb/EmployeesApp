package com.servlet;

import java.io.IOException;

import com.dao.impl.DepartmentImplementation;
import com.dao.inf.DepartmentDAO;
import com.dto.Department;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dept")
public class dept extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	DepartmentDAO d=new DepartmentImplementation();
        	Department d1=new Department();
        	d1.setDept_no(Integer.parseInt(req.getParameter("number")));
        	d1.setDept_name(req.getParameter("name"));
        	d1.setLocation(req.getParameter("location"));
        	int res=d.adddept(d1);
        	if(res>=1) {
        		req.setAttribute("success", "Added SuccessFully");
        		RequestDispatcher rd=req.getRequestDispatcher("dept.jsp");
        		rd.forward(req, resp);
        	}
        	else {
        		req.setAttribute("success", "Failed to add");
        		RequestDispatcher rd=req.getRequestDispatcher("dept.jsp");
        		rd.forward(req, resp);
        	}
        	
        	
        	
        }
}
