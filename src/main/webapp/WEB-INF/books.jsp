<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 25.02.2023
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="com.example.servletproject.entity.Book" %>
<%@page import="java.util.List" %>

<html>
<head>
    <title>Books</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>

    <h3>TEST</h3>
    <c:forEach var="book" items="${requestScope.books}">
        <form class="row row-cols-lg-auto g-3 align-items-center"
        action="book"
        method="post" enctype="multipart/form-data"
        id="form${book.id}">
            <input name="text" type="text" value="${book.name}">
            <input name="text" type="text" value="${book.author}">
            <input name="text" type="text" value="${book.description}">

        </form>

    </c:forEach>

</body>
</html>
