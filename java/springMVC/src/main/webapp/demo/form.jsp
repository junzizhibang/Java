<%--
  Created by IntelliJ IDEA.
  User: 脚踏实地
  Date: 2019/6/21
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form表单</title>
</head>
<body>
     <form action="${pageContext.request.contextPath}/DoFormServlet" method="post"
      onsubmit="return dosubmit()" >
         <input  type="hidden"  name="token"  value="${sessionToken}">
         用户名:
         <input type="text"  name="userName">
         <input type="submit"  value="提交"  id="submit">
     </form>
</body>
</html>
