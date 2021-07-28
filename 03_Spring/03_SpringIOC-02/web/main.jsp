<%--
  Created by IntelliJ IDEA.
  User: zyp
  Date: 2020/3/3
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath %>"/>
    <title>Title</title>
</head>
<body>
    ${sessionScope.user.uname}登录成功，我是主页面
</body>
</html>
