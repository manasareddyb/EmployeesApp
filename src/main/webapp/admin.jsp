<%@page import="com.dto.Employee"%>
<%@page import="com.dto.Department"%>
<%@page import="com.dao.inf.EmployeeDAO"%>
<%@page import="com.dao.impl.EmployeeImplementation"%>
<%@page import="com.dao.inf.DepartmentDAO"%>
<%@page import="com.dao.impl.DepartmentImplementation"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard | Employee Management</title>
    
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body class="bg-gray-100">
    <%EmployeeDAO ed=new EmployeeImplementation();
       List<Employee> l=ed.findAll();
       int no=l.size();
       DepartmentDAO dd=new DepartmentImplementation();
       List<Department> dl=dd.findAll();
       int nod=dl.size();
       Employee e1=(Employee) session.getAttribute("Employee");
       Department s=dd.findbyId(e1.getDept_no());
     
    %>
       
    <nav class="bg-white shadow-md">
        <div class="max-w-7xl mx-auto px-4 py-3 flex justify-between items-center">
            <h1 class="text-xl font-bold text-orange-600">DCL Admin Dashboard</h1>
            <div class="text-sm text-gray-500">
            
            <a href="logout" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">
			<i class="fa-solid fa-arrow-right-from-bracket"></i> Logout
			</a>
              
            </div>
        </div>
    </nav>

    <div class="max-w-7xl mx-auto px-4 py-6">
        
        
        <div class="grid grid-cols-1 md:grid-cols-4 gap-4 mb-8">
            <!-- Employee Count Card -->
            <div class="bg-white rounded-lg shadow p-5 border-l-4 border-orange-500">
                <div class="flex items-center justify-between">
                    <div>
                        <p class="text-black-500 text-sm">Total Employees</p>
                        <p class="text-2xl font-bold" id="empCount"><%=no %></p>
                    </div>
                    <i class="fas fa-users text-3xl text-orange-400"></i>
                </div>
            </div>
            
            
            <div class="bg-white rounded-lg shadow p-5 border-l-4 border-orange-500">
                <div class="flex items-center justify-between">
                    <div>
                        <p class="text-black-500 text-sm">Total Departments</p>
                        <p class="text-2xl font-bold" id="deptCount"><%=nod %>></p>
                    </div>
                    <i class="fas fa-building text-3xl text-orange-400"></i>
                </div>
            </div>
        </div>

        
        <div class="flex flex-wrap gap-3 mb-6">
            <a href="register.jsp" class="bg-orange-600 text-white px-5 py-2 rounded-lg hover:bg-orange-700 transition flex items-center gap-2">
                <i class="fas fa-user-plus"></i> Add Employee
            </a>
            <a href="view.jsp" class="bg-orange-600 text-white px-5 py-2 rounded-lg hover:bg-orange-700 transition flex items-center gap-2">
                <i class="fas fa-eye"></i> View Employees
            </a>
            <a href="dept.jsp" class="bg-orange-600 text-white px-5 py-2 rounded-lg hover:bg-orange-700 transition flex items-center gap-2">
                <i class="fas fa-plus-circle"></i> Add Department
            </a>
            <a href="viewDept.jsp" class="bg-orange-600 text-white px-5 py-2 rounded-lg hover:bg-orange-700 transition flex items-center gap-2">
                <i class="fas fa-list"></i> View Departments
            </a>
        </div>

        
        <div id="contentArea" class="bg-white rounded-lg shadow p-6">
            <!-- Welcome Message -->
            <div class="text-center text-gray-500 py-10">
               
                <p>Welcome to Admin Dashboard</p>
                        <div class="overflow-x-auto">
                            <table class="w-full border text-sm">
                                <thead class="bg-gray-100">
                                        <tbody>
									<tr>
			                            <td class="border p-2">Admin</td>
			                            <td class="border p-2">Job</td>
			                            <td class="border p-2">Salary</td>
			                            <td class="border p-2">HR</td>
			                            <td class="border p-2">Mail</td>
			                        </tr>
                                    <tr>
                                        <th class="border p-2 text-left"><%=e1.getName() %>></th>
                                        <th class="border p-2 text-left"><%=e1.getJob() %>></th>
                                        <th class="border p-2 text-left"><%=e1.getSalary() %>></th>
                                        <th class="border p-2 text-left"><%=s.getDept_name() %>></th>
                                        <th class="border p-2 text-left"><%=e1.getMail() %>></th>
                                    </tr>
                                </thead>
                        
								</tbody>
						</table>
				 </div>
            </div>
        </div>
    </div>
</body>
</html>