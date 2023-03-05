<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 28.02.2023
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>

<h1>This is start page for game</h1>
<h3>${requestScope.question.questionText}</h3>

<form class="form-horizontal" method="post">
    <fieldset>

        <!-- Textarea -->
        <div class="form-group">
            <div class="col-md-4">
                <textarea class="form-control" id="textarea" name="textarea">default text</textarea>

                <h3>Questions</h3>
<%--                <c:forEach var="question" items="${requestScope.}">--%>
<%--                    <form class="row row-cols-lg-auto g-3 align-items-center"--%>
<%--                          action="book"--%>
<%--                          method="post" enctype="multipart/form-data"--%>
<%--                          id="form${book.id}">--%>
<%--                        <input name="text" type="text" value="${book.name}">--%>
<%--                        <input name="text" type="text" value="${book.author}">--%>
<%--                        <input name="text" type="text" value="${book.description}">--%>

<%--                    </form>--%>

<%--                </c:forEach>--%>
            </div>
        </div>

        <!-- Multiple Radios -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Answers">Answer Text</label>
            <div class="col-md-4">
                <div class="radio">
                    <label for="Answers-0">
                        <input type="radio" name="Answers" id="Answers-0" value="1" checked="checked">
                        Answer 1
                    </label>
                </div>
                <div class="radio">
                    <label for="Answers-1">
                        <input type="radio" name="Answers" id="Answers-1" value="2">
                        Answer 2
                    </label>
                </div>
            </div>
        </div>


    </fieldset>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous">
</script>
</body>
</html>
