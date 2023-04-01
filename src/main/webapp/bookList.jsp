<%@ page import="com.example.mvcwebapplication.dao.BookDAO" %>
<%@ page import="com.example.mvcwebapplication.model.Book" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
</head>
<body>
<h1>Book List</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Date</th>
        <th>Genres</th>
        <th>Characters</th>
        <th>Synopsis</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.getId()}" /></td>
            <td><c:out value="${book.getTitle()}" /></td>
            <td><c:out value="${book.getAuthor()}" /></td>
            <td><c:out value="${book.getDate()}" /></td>
            <td><c:out value="${book.getGenres()}" /></td>
            <td><c:out value="${book.getCharacters()}" /></td>
            <td><c:out value="${book.getSynopsis()}" /></td>
            <td><a href="${pageContext.request.contextPath}/updateBook?id=${book.getId()}">Edit</a></td>
            <td>
                <form action="${pageContext.request.contextPath}/deleteBook" method="POST" style="display:inline;">
                    <input type="hidden" name="bookId" value="${book.getId()}">
                    <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this book?')">
                </form>
            </td>
            <td><a href="${pageContext.request.contextPath}/view?id=${book.getId()}">Details</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="${pageContext.request.contextPath}/insertBook">Create New Book</a>
</body>
</html>