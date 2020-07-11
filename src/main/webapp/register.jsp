<%--
  Created by IntelliJ IDEA.
  User: paranoia
  Date: 2020/7/10
  Time: 下午 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>

</head>
<body>
<script type="text/javascript">
    function subGet() {
            //alert();
            var username = $("#username").val();
            var password = $("#password").val();
            var email = $("#email").val();
            var mobile = $("#mobile").val();
            //console.log(username);
            $.ajax({
                type:"POST",
                url:"<%=request.getContextPath()%>/Servlet",
                data: {username:username,password:password,email:email,mobile:mobile},
                success:function (msg) {
                    if(msg == "success") {
                        alert("添加成功!");
                        //window.Location.href = "index.jsp";
                        location.href="/day0710/login.jsp";
                    }else{
                        alert("添加失败!");
                    }
                }

            })

    }
</script>

    <td>用户名：</td>
    <input type="text" id="username" name="username"><br>

    <td>密码：</td>
    <input type="text" id="password" name="password"><br>

    <td>邮箱：</td>
    <input type="text" id="email" name="email"><br>

    <td>手机：</td>
   <input type="text" id="mobile" name="mobile"><br>

    <input type="button"  value="提交" onclick="subGet()">

</body>
</html>
