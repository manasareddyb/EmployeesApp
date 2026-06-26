<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body>
<%String success=(String) request.getAttribute("success");
  if(success!=null){%>
	  <h1 class="text-black"><%=success%></h1>
  <%}%>
    <div class="min-h-screen flex flex-col items-center justify-center bg-orange-300 p-4">
    
       <div class="bg-white p-6 rounded-lg shadow-md w-full max-w-sm border border-gray-200">
           <form action="dept" method="post">   

            <div>
                <label class="block text-sm font-medium text-gray-700 mb-1">Department Number</label>
                <input type="Number" name="number" class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-sm">
            </div>
            <div>
                <label class="block text-sm font-medium text-gray-700 mb-1">Department Name</label>
                <input type="text" name="name" class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-sm">
            </div>
             <div>
                <label class="block text-sm font-medium text-gray-700 mb-1">Location</label>
                <input type="text" name="location" value="1234" class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 text-sm">
            </div>
            <!-- Register Button -->
            <div class="pt-2 flex flex-row px-6">
                <button type="submit" class="w-full bg-blue-600 hover:bg-blue-700 text-white font-medium py-2 px-4 rounded-md transition duration-200 text-sm cursor-pointer shadow-sm">
                    CreateDepartment
                </button>
            </div>
            </form> 
            </div>
  </div>
</body>
</html>