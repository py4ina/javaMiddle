<%@ page import="com.learn.servlet.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <b>PRODUCT PAGE</b>
        <br/>id: ${product.id}
        <br/>id: <%= ((Product)request.getAttribute("product")).getId()%>
        <br/>name: ${product.name}
        <br/><a href="/Middle/index.jsp">main page</a>
    </body>
</html>