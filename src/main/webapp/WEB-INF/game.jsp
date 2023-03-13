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

<%--<h1>Hello</h1>--%>
<%--<h3>Enter your book</h3>--%>
<%--<form action="/game" method="post">--%>
<%--    <label>Name</label><br>--%>
<%--    <input type="text" name="bookName">--%>
<%--    <label>Author</label><br>--%>
<%--    <input type="text" name="bookAuthor">--%>
<%--    <label>Desc</label><br>--%>
<%--    <input type="text" name="bookDescription"><br>--%>
<%--    <input type="submit" value="Submit">--%>
<%--</form>--%>

<div class="container">
    <h1>${requestScope.questions.getId}</h1>
    <form action="" class="form-horizontal" method="post">
        <div>
            <p>${questionText}</p>
        </div>
        <ul>
            <form action="/game" method="post">
                <label>Answer 1</label>
                <input type="radio" name="answer" onclick="getAnswer('answer-1')" value="answer-1">
                <label>Answer 2</label>
                <input type="radio" name="answer" onclick="getAnswer('answer-2')" value="answer-2">
                <label class="col-md-4 control-label" for="submit"></label>
                <button id="submit" class="btn btn-success">Submit</button>
            </form>

            <div class="w3-content" style="max-width:2000px;margin-top:46px">
                <div class="w3-container w3-content w3-left w3-padding-64" style="max-width:800px" id="band">
                    <h1 class="w3-wide"><c:out value="${questionText}"></c:out></h1>
                    <form name="answers" action="question?id=${questionId}" method="post">
                        <c:forEach items="${requestScope.answerList}" var="answer">
                            <div class="w3-container w3-white">
                                <input type="radio" id="answer_${answer.id}" name="userAnswer" value="${answer.id}">
                                <label for="answer_${answer.id}">${answer.text}</label><br>
                            </div>
                        </c:forEach>
                        <input class="w3-button w3-black w3-section" type="submit" value="Ответить">
                    </form>
                </div>
            </div>
<%--            <c:forEach var="answer" items="questions.answers">--%>
<%--                <div class="form-check">--%>
<%--                    <input class="form-check-input" type="radio" name="answer" value="${answer.id}"--%>
<%--                    id="answer${answer.id}">--%>
<%--                    <label class="form-check-label" for="answer${answer.id}">--%>
<%--                            ${answer.text}--%>
<%--                    </label>--%>

<%--                </div>--%>

<%--            </c:forEach>--%>
        </ul>

    </form>
</div>

<%--<p>${requestScope.questions}</p><br>--%>
<%--<c:forEach var="question" items="${requestScope.questions}">--%>
<%--    <p>Question : ${question.getText()}</p><br>--%>

<%--</c:forEach>--%>


<%--<c:forEach var="answer" items="${requestScope.answers}">--%>
<%--    <p>Answer: ${answer.getText()}</p>--%>

<%--</c:forEach>--%>




<%--<form class="form-horizontal" method="post">--%>
<%--    <fieldset>--%>

<%--        <!-- Textarea -->--%>
<%--        <div class="form-group">--%>
<%--            <div class="col-md-4">--%>
<%--&lt;%&ndash;                <textarea class="form-control" id="textarea" name="textarea">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    ${requestScope.questionText}&ndash;%&gt;--%>
<%--&lt;%&ndash;                </textarea>&ndash;%&gt;--%>

<%--                <h3>Questions</h3>--%>
<%--                <c:forEach var="question" items="${requestScope.questions}">--%>
<%--                    <form class="row row-cols-lg-auto g-3 align-items-center"--%>
<%--                          action="question"--%>
<%--                          method="post" enctype="multipart/form-data"--%>
<%--                          id="form${question.id}">--%>
<%--                        <input name="text" type="text" value="${question.id}">--%>
<%--                        <input name="text" type="text" value="${question.text}">--%>
<%--                        <input name="text" type="text" value="${question.answers}">--%>
<%--                    </form>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <!-- Multiple Radios -->--%>
<%--&lt;%&ndash;        <div class="form-group">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <label class="col-md-4 control-label" for="answers">Answer Text</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <div class="col-md-4">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <div class="radio">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <label for="Answers-0">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <input type="radio" name="Answers" id="Answers-0" value="1" checked="checked">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        ${requestScope.answers}&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <div class="radio">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <label for="Answers-1">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <input type="radio" name="Answers" id="Answers-1" value="2">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        Answer 2&ndash;%&gt;--%>
<%--&lt;%&ndash;                    </label>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>

<%--    </fieldset>--%>
<%--</form>--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous">
</script>
</body>
</html>
