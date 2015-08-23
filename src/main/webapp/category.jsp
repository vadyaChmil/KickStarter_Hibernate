<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>Category</title>
</head>
<body>
	<div id="menu">
		<p>
			<a href="categories">Home</a>
			<a href="categories">Back</a>
		</p>
	</div>
	<div id="quote">
		<p>${quote.quote}</p>
		<p>${quote.autor.name}</p>
	</div>
	<ul>
		<c:forEach items="${projects}" var="project">
			<li>
				<h4><a href="project?id=${project.id}">${project.name}</a></h4>
			</li>
			<p>Project needs <span class="element">${project.needMoney/100}</span> dollars</p>
			<p>Project has <span class="element">${project.currentMoney/100}</span> dollars</p>
			<p>Days to go - <span class="element">${project.daysLeft}</span></p>
			<p>Description: <span class="description">${project.description}</span></p>
		</c:forEach>
	</ul>
</body>
</html>