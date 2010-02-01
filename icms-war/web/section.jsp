<%@page import="icms_ejb.*" %>
<%@page import="icms_util.*" %>
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
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <p id="breadcrumb">
            <%= HtmlUtil.breadCrumb(a).substring(0, HtmlUtil.breadCrumb(a).length()-20)%>
        </p>
        <div id="description">
            <jsp:include page="section_template.jsp" />
        </div>

        <jsp:include page="liste_sections.jsp" />

        <jsp:include page="liste_articles.jsp" />

        <jsp:include page="footer.jsp" />
    </body>
</html>