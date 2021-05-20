<%--
  Created by IntelliJ IDEA.
  User: lf
  Date: 2021/4/14
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>forward</title>
  </head>
  <body>
    request.getRequestDispatcher("/forward.jsp").forward(request, response);
  </body>
</html>
