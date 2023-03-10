<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Burgers</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <h1>New Burger</h1>
    <form:form  action="/burger" method="post" modelAttribute="burger">
        <p>
            <form:label path="name">Burger Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="restaurant">Restaurant</form:label>
            <form:errors path="restaurant"/>
            <form:textarea path="restaurant"/>
        </p>
        <p>
            <form:label path="notes">Notes</form:label>
            <form:errors path="notes"/>
            <form:input type="textarea" path="notes"/>
        </p>
        <p>
            <form:label path="rating">Rating</form:label>
            <form:errors path="rating"/>     
            <form:input type="number" path="rating"/>
        </p>    
        <input type="submit" value="Submit"/>
    </form:form> 
    <table>
      <thead>
        <tr>
          <th>Burger Name</th>
          <th>Restaurant Name</th>
          <th>Notes</th>
          <th>Rating</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="b" items="${burgers}">
        <tr>
          <td><c:out value="${b.name}"></c:out></td>
          <td><c:out value="${b.restaurant}"></c:out></td>
          <td><c:out value="${b.notes}"></c:out></td>
          <td><c:out value="${b.rating}"></c:out></td>
          <td><a href="/burgers/edit/${b.id}">Edit</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  </body>
</html>