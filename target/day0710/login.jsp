<%--
  Created by IntelliJ IDEA.
  User: paranoia
  Date: 2020/7/11
  Time: 下午 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
    <script type="text/javascript">
        function subGet() {
            //alert();
            var username = $("#username").val();
            var password = $("#password").val();

            $.ajax({
                type:"POST",
                url:"<%=request.getContextPath()%>/LoginServlet",
                data: {username:username,password:password},
                success:function (msg) {
                    if(msg == "success") {
                        alert("登录成功!");
                        location.href="/day0710/main.jsp";
                    }else{
                        alert("账户或密码错误!");
                    }
                }

            })

        }
    </script>

    <td>用户名：</td>
    <input type="text" id="username" name="username"><br>

    <td>密码：</td>
    <input type="text" id="password" name="password"><br>

    <input type="button"  value="提交" onclick="subGet()">
</body>
</html>
