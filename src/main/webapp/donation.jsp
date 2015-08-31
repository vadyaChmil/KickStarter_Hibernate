<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>Donation</title>
</head>
<body>
	<div id="menu">
		<p>
			<a href="categories">Home</a>
			<a href="project?id=${projectId}">Back</a>
		</p>
	</div>
	<div id="quote">
		<p>${quote.quote}</p>
		<p>${quote.autor.name}</p>
	</div>
	<h4 id="donationText">Write in or choose one of the variant</h4>
	<div id="donation">
		<form method="post" action="donate">
			<p><label for="name">Input name:</label></p>
			<p><input type="text" name="name" id="name" size="30" required></p>
			<p><label for="card">Input card number:</label></p>
			<p><input type="text" name="card" id="card" size="30" maxlength="16"
				onkeypress='return event.charCode >= 48 && event.charCode <= 57' required></p>
			<p><label for="money">Input money (cents):</label></p>
			<c:if test='${not empty money}'>
				<p><input type="text" name="money" id="money" size="30"  value="${money}" readonly></p>
			</c:if>
			<c:if test='${empty money}'>
				<p><input type="text" name="money" id="money" size="30" onkeypress='return event.charCode >= 48 && event.charCode <= 57' required></p>
			</c:if>
			<p>
				<input type="reset" value="Reset">
				<input type="submit" value="Send">
			</p>
		</form>
	</div>
	<div id="pledge">
		<c:if test='${not empty project.donations}'>
			<c:forEach var="donation" items="${project.donations}">
				<p><a href="donation?id=${projectId}&money=${donation.money}">${donation.money/100} dollars</a></p>
				<p>${donation.pledge}</p>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>