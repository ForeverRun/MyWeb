<%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2016/1/21
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
    <title>用户信息展示界面</title>
    <script type="text/javascript">
        function del(id){
            var flag = window.confirm("你确定删除吗？");
            if(flag){
                location.href = "${pageContext.request.contextPath}/delById?id="+ id;
            }
        }
    </script>
</head>
<body>
    <c:if test="${empty cs}">
        无客户信息
    </c:if>
    <c:if test="${not empty cs}">
    <table border="1" align="center" width="65%">
         <tr>
             <td><input type="checkbox"></td>
             <td>客户编号</td>
             <td>客户姓名</td>
             <td>客户性别</td>
             <td>客户生日</td>
             <td>客户电话</td>
             <td>客户邮箱</td>
             <td>客户爱好</td>
             <td>客户类型</td>
             <td>客户备注</td>
             <td>操作</td>
        </tr>
        <c:forEach items="${cs}" var="co">
        <tr>
            <td><input type="checkbox"></td>
            <td>${co.id}</td>
            <td>${co.name}</td>
            <td>${co.gender}</td>
            <td>${co.birthday}</td>
            <td>${co.cellphone}</td>
            <td>${co.email}</td>
            <td>${co.preference}</td>
            <td>${co.type}</td>
            <td>${co.description}</td>
            <td><a href="${pageContext.request.contextPath}/findById?id=${co.id}">编辑</a>&nbsp;&nbsp;
                <a href="javascript:void(0)" onclick="del('${co.id}')">删除</a></td>
        </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
