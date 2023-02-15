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
    <form:form  action="/edit/${burger.id}" method="post" modelAttribute="burger">
      <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="name">Burger Name</form:label>
            <form:errors path="name"/>
            <form:input path="name" value="${burger.name}"/>
        </p>
        <p>
            <form:label path="restaurant">Restaurant</form:label>
            <form:errors path="restaurant"/>
            <form:textarea path="restaurant" value="${burger.restaurant}"/>
        </p>
        <p>
            <form:label path="notes">Notes</form:label>
            <form:errors path="notes"/>
            <form:input type="textarea" path="notes" value="${burger.notes}"/>
        </p>
        <p>
            <form:label path="rating">Rating</form:label>
            <form:errors path="rating"/>     
            <form:input type="number" path="rating" value="${burger.rating}"/>
        </p>    
        <input type="submit" value="Submit"/>
    </form:form> 
  </body>
</html>