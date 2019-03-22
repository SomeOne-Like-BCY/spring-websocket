<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>错误提示</title>
</head>

<body>
<h1>
    <c:choose>
        <c:when test="${message != null }">
            ${message}<br/>
        </c:when>
        <c:otherwise>
            内部错误,请联系管理员！<br />
        </c:otherwise>
    </c:choose>
</h1><br>
</body>
</html>