<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${requestScope['article'].title}"/></title>
        <link href="/icms-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <h2>
            <a href="/icms-war/article/cat:<c:out value="${requestScope['article'].mySection.myCategory.permalink}" escapeXml="true"/>" class="category"><c:out value="${requestScope['article'].mySection.myCategory.title}" escapeXml="true"/></a>
            &rsaquo;
            <a href="/icms-war/article/sec:<c:out value="${requestScope['article'].mySection.permalink}" escapeXml="true"/>" class="section"><c:out value="${requestScope['article'].mySection.title}" escapeXml="true"/></a>
        </h2>
        <div class="post">
            <h2 class="title"><a href="/icms-war/article/art:<c:out value="${requestScope['article'].permalink}" escapeXml="true"/>"><c:out value="${requestScope['article'].title}" escapeXml="true"/></a></h2>
            <p class="meta">
                <c:out value="${requestScope['article'].publishedAt}" escapeXml="false"/>
                <%--Posted by <a href="#">${u.author.name}</a>--%>
            </p>
            <div class="entry">
                <c:out value="${requestScope['article'].intro}" escapeXml="false"/>
                <hr class="visible" />
                <c:out value="${requestScope['article'].content}" escapeXml="false"/>
            </div>
        </div>

        <jsp:include page="footer.jsp" />
    </body>
</html>
