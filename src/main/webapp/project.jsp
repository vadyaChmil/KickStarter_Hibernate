<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>Project</title>
</head>
<body>
	<div id="menu">
		<p>
			<a href="categories">Home</a>
			<a href="category?id=${project.category.id}">Back</a>
			<a href="donation?id=${project.id}">Donation</a>
		</p>
	</div>
	<div id="quote">
		<p>${quote.quote}</p>
		<p>${quote.autor.name}</p>
	</div>
	<ul>
		<li>
			<h4><a href="project?id=${project.id}">${project.name}</a></h4>
		</li>
		<p>Project needs <span class="element">${project.needMoney/100}</span> dollars</p>
		<p>Project has <span class="element">${project.currentMoney/100}</span> dollars</p>
		<p>Days to go - <span class="element">${project.daysLeft}</span></p>
		<p>Description: <span class="description">${project.description}</span></p>
		<p>History of project: <span class="description">${project.history}</span></p>
		<p class="element"><a href="${project.urlVideo}" target="youtube">Video</a></p>
	</ul>
	<table>
		<c:if test='${not empty project.questions}'>
			<tr>
				<th id="table">Question</th>
				<th id="table">Answer</th>
			</tr>
			<c:forEach var="question" items="${project.questions}">
				<tr>
					<td>${question.question}</td>
					<td>${question.answer}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div id="question">
	<form method="get" action="question">
		<textarea cols="50" rows="6" placeholder="Input question..."></textarea>
		<p>
			<input type="reset" value="Reset">
			<input type="submit" value="Send">
		</p>
	</form>
	</div>
</body>
</html>