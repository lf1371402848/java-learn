<%--
  Created by IntelliJ IDEA.
  User: zyp
  Date: 2020/3/10
  Time: 15:33
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
    <%--引入js文件--%>
    <script type="text/javascript" src="js/j.js"></script>
</head>
<body>
    访问静态资源
</body>
</html>
