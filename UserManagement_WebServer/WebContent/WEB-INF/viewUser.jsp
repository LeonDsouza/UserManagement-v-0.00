<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>
	<c:if test="${!empty users}">

		<table border="1">
			<tr>
				<th>User Name</th>
				<th>User Address</th>
				<th>User Phone No.</th>
				<th>User Roll No.</th>
				<th>User Skills</th>
				<th>User Date Of Birth</th>
				<th>User Email</th>
				<th>User Gender</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<fmt:formatDate value="${user.userDob}" var="formattedDate"
						type="date" pattern="dd/MM/yyyy" />
					<td><c:out value="${user.userName}" /></td>
					<td><c:out value="${user.userAddress}" /></td>
					<td><c:out value="${user.userPhno}" /></td>
					<td><c:out value="${user.userRollno}" /></td>
					<td><c:out value="${user.userSkills}" /></td>
					<td><c:out value="${formattedDate}" /></td>
					<td><c:out value="${user.userEmail}" /></td>
					<td><c:out value="${user.userGender}" /></td>
					<td><a href="/UserManagement_WebServer/EditUser?userRollno=${user.userRollno}">Edit User</a></td>
					<td><a href="/UserManagement_WebServer/SubmitDeleteUser?userRollno=${user.userRollno}">Delete User</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>