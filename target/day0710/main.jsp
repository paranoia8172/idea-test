<%--
  Created by IntelliJ IDEA.
  User: paranoia
  Date: 2020/7/11
  Time: 下午 4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>界面</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
    用户名：${sessionScope.user.username}<br>
    密码：${sessionScope.user.password}<br>
    邮箱：${sessionScope.user.email}<br>
    手机：${sessionScope.user.mobile}
</body>
</html>
