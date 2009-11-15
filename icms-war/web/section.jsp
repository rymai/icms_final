<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${requestScope['section'].title}"/></title>
        <link href="/icms-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <h2>
            <a href="/icms-war/article/cat:<c:out value="${requestScope['section'].myCategory.permalink}" escapeXml="true"/>" class="category"><c:out value="${requestScope['section'].myCategory.title}" escapeXml="true"/></a>
            &rsaquo;
            <a href="/icms-war/article/sec:<c:out value="${requestScope['section'].permalink}" escapeXml="true"/>" class="section"><c:out value="${requestScope['section'].title}" escapeXml="true"/></a>
        </h2>
        <div id="description">
            <c:out value="${requestScope['section'].content}" escapeXml="false"/>
        </div>
        <jsp:include page="liste_articles.jsp" />

        <jsp:include page="footer.jsp" />
    </body>
</html>