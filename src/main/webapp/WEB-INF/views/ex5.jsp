<%--
  Created by IntelliJ IDEA.
  User: ict05-23
  Date: 2022-11-14
  Time: 오전 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>ex5.jsp View</title>
</head>
<body>
    <h1>${todoDTO}</h1>
    <h1><c:out value="${todoDTO}"></c:out></h1>
</body>
</html>
