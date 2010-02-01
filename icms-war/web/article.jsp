<%@page language="java" import="icms_ejb.*" %>
<%@page language="java" import="icms_util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        Page a = (Page) request.getAttribute("article");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${requestScope['article'].title}"/></title>
        <jsp:include page="partials/_head.jsp" />
        <script src="/icms-war/js/FancyZoom.js" type="text/javascript"></script>
        <script src="/icms-war/js/FancyZoomHTML.js" type="text/javascript"></script>
    </head>
    <body onload="setupZoom()">

        <jsp:include page="header.jsp" />
        <p id="breadcrumb">
            <%= HtmlUtil.breadCrumb(a).substring(0,
                                                              HtmlUtil.breadCrumb(a).length() - 20)%>
        </p>

        <jsp:include page="article_template.jsp" />

        <jsp:include page="footer.jsp" />
    </body>
</html>
