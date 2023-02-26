<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 25.02.2023
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
    <h1>Hello</h1>
    <h3>Enter your book</h3>
    <form action="/bookcontoller" method="post">
        <label>Name</label><br>
        <input type="text" name="bookName">
        <label>Author</label><br>
        <input type="text" name="bookAuthor">
        <label>Desc</label><br>
        <input type="text" name="bookDescription"><br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>
