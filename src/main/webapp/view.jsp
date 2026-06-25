<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dto.Department"%>
<%@page import="com.dao.impl.DepartmentImplementation"%>
<%@page import="com.dao.inf.DepartmentDAO"%>
<%@page import="com.dto.Employee"%>
<%@page import="com.dao.impl.EmployeeImplementation"%>
<%@page import="com.dao.inf.EmployeeDAO"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body class="bg-gray-100 min-h-screen">
	<%Employee emp=(Employee) session.getAttribute("Employee");%>
             <%if(emp!=null){ %>

 <!-- Co-workers Section -->
        <div class="coworkers-section">
            <div class="max-w-5xl mx-auto px-4 py-8">
                <div class="bg-white rounded-lg shadow-md p-6">
                    <div class="bg-green-600 -m-6 mb-6 rounded-t-lg p-4">
                    <a href="dashboard.jsp" class="top-0 left-0 bg-blue-500 text-white py-2 px-4">Back</a>
                        <h2 class="text-xl font-bold text-white">My Co-workers</h2>
                    </div>
                    <div class="overflow-x-auto mt-4">
                    
                        <table class="w-full border-collapse">
                            <thead>
                                <tr class="bg-gray-100">
                                    <th class="p-3 text-left text-sm font-semibold">ID</th>
                                    <th class="p-3 text-left text-sm font-semibold">Name</th>
                                    <th class="p-3 text-left text-sm font-semibold">Job Position</th>
                                    <th class="p-3 text-left text-sm font-semibold">Email</th>
                                    <th class="p-3 text-left text-sm font-semibold">Department</th>
                                 </tr>
                            </thead>
                            <tbody>
                             <%  EmployeeDAO E=new EmployeeImplementation();%>
                             <%List<Employee> l=E.findAll();%>
                             <% DepartmentDAO D=new DepartmentImplementation();%>     
                                 <%if(l!=null&&!l.isEmpty()){%>
                                 <%for(Employee e:l){%>
                                 <%Department d=D.findbyId(e.getDept_no()); %>
                                
                                 <tr class="border-b hover:bg-gray-50">
                                  <td class="p-3"><%=e.getId()%></td>
                                  <td class="p-3 font-medium"><%=e.getName()%></td>
                                  <td class="p-3"><%=e.getJob()%></td>
                                  <td class="p-3"><%=e.getMail()%></td>
                                  <td class="p-3"><%=d.getDept_name()%></td>
                                  </tr>
                                 <%}%>
                                 <%}%>
                                
                            </tbody>
          
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%}else{%>
                    <%request.setAttribute("error","Already session Expired");%>
                    <%request.getRequestDispatcher("login.jsp").forward(request,response);%>
                    <%}%>
</body>
</html>