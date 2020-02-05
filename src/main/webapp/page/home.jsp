<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addEmp"method = "post" enctype="multipart/form-data"  >

Name : <input type = "text" name="name"><br> 
Roll :  <input type = "text" name="roll"><br> 
Salary : <input type = "text" name="salary"><br>
Profile : <input type="file" name ="file"><br>
<input type="submit"><br>


</form>
${status}

<form action="profile"method = "post"   >

id : <input type = "text" name="id"><br> 

<input type="submit"><br>


</form>

<img alt="ff" src="${pic }">

</body>
</html>