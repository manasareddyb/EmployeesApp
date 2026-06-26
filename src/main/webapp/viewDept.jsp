<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dto.Employee"%>
<%@page import="com.dto.Department"%>
<%@page import="com.dao.inf.EmployeeDAO"%>
<%@page import="com.dao.impl.EmployeeImplementation"%>
<%@page import="com.dao.inf.DepartmentDAO"%>
<%@page import="com.dao.impl.DepartmentImplementation"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body>
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
                                    <th class="p-3 text-left text-sm font-semibold">Department Number</th>
                                    <th class="p-3 text-left text-sm font-semibold">Department Name</th>
                                    <th class="p-3 text-left text-sm font-semibold">Department Location</th>
                                  
                                 </tr>
                            </thead>
                            <tbody>
                            <% DepartmentDAO d=new DepartmentImplementation();
                              List<Department> l=d.findAll();
                              if(l!=null&&l.size()>0){
                            	    for(Department d1:l){ %>
                            	    	<tr class="border-b hover:bg-gray-50">
                                        <td class="p-3"><%=d1.getDept_no()%></td>
                                        <td class="p-3 font-medium"><%=d1.getDept_name()%></td>
                                        <td class="p-3"><%=d1.getLocation()%></td>
                                   </tr>
                            	    <%}
                            	  
                            	  
                            	  
                            	  
                              }
                            
                            
                            %>
                             
                             </tbody>
          
                        </table>
                    </div>
                </div>
            </div>
            </div>
</body>
</html>