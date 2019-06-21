<%--
  Created by IntelliJ IDEA.
  User: 脚踏实地
  Date: 2019/6/21
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form 表单</title>
    <script type="text/javascript">
        var  flag=false;//false表示提交,true 就是一件提交
        function dosubmit() {
            //获取表单提交按钮
            var btnSubmit=document.getElementById("submit");
            //将表单提交按钮设置为不可用,这样就可以避免用户再次点击提交按钮
            btnSubmit.disabled="disabled";
            //返回true让表单正常提交
            return  true;
        }
    </script>
</head>
<body>
<from  action="DoFormServlet"  method="post"  onsubmit="return dosubmit()" >
    <input type="hidden"  name="parameterToken"  value="${sessionToken}">
    用户名:
    <input type="text" name="userName">
    <input type="submit" name="submit" id="submit" value="提交">

</from>
</body>
</html>
