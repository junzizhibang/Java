<%--
  Created by IntelliJ IDEA.
  User: 脚踏实地
  Date: 2019/6/21
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xss演示实例</title>
</head>
<body>
  <form  action="XssDemo" , method="post" >
      <input  type="text" name="userName">
      <input   type="submit">
  </form>
</body>
</html>
