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

        <%--<br/>--%>
        <%--<a href="./productAddToBucket.do?id=1">Add to bucket</a>--%>
        <%--<hr/>--%>
        <%--<h2>Product in bucket</h2>--%>
        <%--<hr/>--%>
        <%--<ul>--%>
            <%--<li>--%>
                <%--<a href="/product.do?id=2">Paper</a>: = 6--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="/product.do?id=3">Paper</a>: = 11--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="/product.do?id=1">Paper</a>: = 18--%>
            <%--</li>--%>
        <%--</ul>--%>
    </body>
</html>