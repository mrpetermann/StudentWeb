<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="teacher" method="post">
    <label>New word: <input name="newWord" /></label>
    <button type="submit">Add</button>
</form>
<% @SuppressWarnings("unchecked")
    ArrayList<String> words = (ArrayList<String>)request.getSession().getAttribute("words"); %>
<ul>
    <% for(String word : words) { %>
        <li>
            <%= word %>
        </li>
    <% } %>
</ul>
</body>
</html>
