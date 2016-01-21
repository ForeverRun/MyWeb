<%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2016/1/21
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<head>
    <title>条目编辑</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/update" method="post">
        <input type="hidden" name="id" value="${co.id}">
        客户姓名:<input type="text" name="name" value="${co.name}"><br/>

        客户性别:
        <c:if test="${co.gender =='男'}">
            <input type="radio" name="gender" value="男" checked="checked">男
            <input type="radio" name="gender" value="女" >女
        </c:if>
        <c:if test="${co.gender !='男'}">
            <input type="radio" name="gender" value="男">男
            <input type="radio" name="gender" value="女" checked="checked">女
        </c:if>
        <br/>
        客户生日:<input type="text" name="birthday" value="${co.birthday}"><br>
        客户电话:<input type="text" name="cellphone" value="${co.cellphone}"><br>
        客户邮箱:<input type="text" name="email" value="${co.email}"><br>
        客户爱好:<input type="text" name="preference" value="${co.preference}"><br>
        客户类型:<input type="text" name="type" value="${co.type}"><br>
        客户备注:<input type="text" name="description" value="${co.description}"><br>
        <input type="submit" value="修改">
    </form>
</body>
</html>
