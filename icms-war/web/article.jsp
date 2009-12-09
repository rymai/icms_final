<%@page language="java" import="icms_ejb.*" %>
<%@page language="java" import="icms_helper.*" %>
<%
        Page a = (Page) request.getAttribute("article");
        HtmlHelper html = new HtmlHelper();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${requestScope['article'].title}"/></title>
        <link href="/icms-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="http://ajax.googleapis.com/ajax/libs/dojo/1.3/dijit/themes/tundra/tundra.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <p id="breadcrumb">
            <%= html.generateBreadCrumb(a)%>
        </p>

        <jsp:include page="article_template.jsp" />

        <jsp:include page="footer.jsp" />
    </body>
</html>
