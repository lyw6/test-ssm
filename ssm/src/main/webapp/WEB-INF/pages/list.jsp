<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/8 0008
  Time: 下午 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>查询所有账号信息</h3>
    <c:forEach items="${list}" var="account">
        ${account.name}
    </c:forEach>

</body>
</html>
