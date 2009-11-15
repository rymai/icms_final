<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><c:out value="${requestScope['category'].title}"/></title>
        <link href="/icms-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <div class="post">
            <h2 class="title"><a href="/icms-war/article/cat:<c:out value="${requestScope['category'].permalink}" escapeXml="true"/>"><c:out value="${requestScope['category'].title}" escapeXml="true"/></a></h2>
            <div class="entry">
                <c:out value="${requestScope['category'].intro}" escapeXml="false"/>
                <c:out value="${requestScope['category'].content}" escapeXml="false"/>
            </div>
            <div class="sections">
                Les sections :
                <br />
                <c:forEach var="u" items="${requestScope['listeSections']}">
                    <a href="/icms-war/article/sec:${u.permalink}">${u.title}</a>
                    <br />
                </c:forEach>

            </div>
        </div>

        <jsp:include page="footer.jsp" />
    </body>
</html>
