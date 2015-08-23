<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>Home page</title>
</head>
<body>
	<div id="quote">
		<p>${quote.quote}</p>
		<p>${quote.autor.name}</p>
	</div>
	<ul>
		<c:forEach items="${categories}" var="category">
			<li>
				<h4><a href="category?id=${category.id}">${category.name}</a></h4>
			</li>
		</c:forEach>
	</ul>
</body>
</html>