<%@page language="java" import="icms_ejb.*" %>
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

        <h2>
            <a href="/icms-war/article/cat:<c:out value="${requestScope['article'].mySection.myCategory.permalink}" escapeXml="true"/>" class="category"><c:out value="${requestScope['article'].mySection.myCategory.title}" escapeXml="true"/></a>
            &rsaquo;
            <a href="/icms-war/article/sec:<c:out value="${requestScope['article'].mySection.permalink}" escapeXml="true"/>" class="section"><c:out value="${requestScope['article'].mySection.title}" escapeXml="true"/></a>
        </h2>
        
        <div class="post">
            <jsp:include page="partials/_article.jsp" />
        </div>

        <form id="translate" action="/icms-war/article/art:<c:out value="${requestScope['article'].permalink}" escapeXml="true"/>">
            <select id="translate_to" name="translate_to">
                <option value="en">English</option>
                <option value="es">Spanish</option>
                <option value="it">Italian</option>
            </select>
            <input type="submit" value="Translate now!" />
        </form>

        <div class="spinner" id="translate_spinner"></div>
        <div id="translation" class="post translation">
        </div>

        <jsp:include page="footer.jsp" />
    </body>
</html>
