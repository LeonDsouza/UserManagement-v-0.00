<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
</head>
<body>
	<form action="/UserManagement_WebServer/SubmitCreateUser" method="post">
		<fmt:formatDate value="${user.userDob}" var="formattedDate"
			type="date" pattern="dd/MM/yyyy" />
		<table border="1">
			<tr>
				<th>Name</th>
				<td><input type="text" name="userName" value="${user.userName}"></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><input type="text" name="userGender"
					value="${user.userGender}"></td>
			</tr>
			<tr>
				<th>Roll No.</th>
				<td><input type="number" name="userRollno"
					value="${user.userRollno}"></td>
			</tr>
			<tr>
				<th>Address</th>
				<td><input type="text" name="userAddress"
					value="${user.userAddress}"></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="text" name="userEmail"
					value="${user.userEmail}"></td>
			</tr>
			<tr>
				<th>Date Of Birth</th>
				<td><input type="text" name="userDob" value="${formattedDate}"></td>
			</tr>
			<tr>
				<th>Skills</th>
				<td><input type="textarea" name="userSkills"
					value="${user.userSkills}"></td>
			</tr>
			<tr>
				<th>Phone Number.</th>
				<td><input type="number" name="userPhno"
					value="${user.userPhno}"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>