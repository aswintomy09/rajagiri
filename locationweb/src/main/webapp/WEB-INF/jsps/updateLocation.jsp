<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Location</title>
</head>
<body>
	<form action="saveLoc" method="post">
	<pre>
	Id:<input type="text" name="id" value="${location.id}"/>
	Code:<input type="text" name="code" value="${location.code}"/>
	Name:<input type="text" name="name" value="${location.name}"/>
	Type:Urban<input type="radio" name="type" value="Urban" ${location.type=='Urban'?'checked':''}/>
		Rural<input type="radio" name="type" value="Rural" ${location.type=='Rural'?'checked':''}/>
	<input type="submit" value="Save"/>
	</pre>
	</form>

</body>
</html>