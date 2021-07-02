<%--
  Created by IntelliJ IDEA.
  User: zyp
  Date: 2020/3/3
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="<%=basePath %>"/>
    <title>Title</title>
</head>
<body>
    <%--创建用户登录--%>
    <h3>欢迎访问502班级</h3>
    <hr>
    <c:if test="${sessionScope.flag=='loginFail'}">
        <font size="20px" color="red">用户名或密码错误</font>
    </c:if>
    <c:remove var="flag" scope="session"></c:remove>
    <form action="userLogin" method="post">
        用户名: <input type="text" name="uname" value=""><br>
        密码: <input type="password" name="pwd" value=""><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
