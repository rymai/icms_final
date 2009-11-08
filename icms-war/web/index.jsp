<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Articles</title>
    <link href="/ICMS-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
  </head>
  <body>
    <jsp:include page="header.jsp" />

    <a href="/ICMS-war/articles/new">Nouvel article</a>

    <c:forEach var="u" items="${requestScope['listeArticles']}">
      <div class="post">
        <h2 class="title"><a href="/ICMS-war/article/${u.permalink}">${u.title}</a></h2>
        <p class="meta">
          ${u.publishedAt}
          <%--Posted by <a href="#">${u.author.name}</a>--%>
        </p>
        <div class="entry">
          ${u.intro}
          <div><a href="/ICMS-war/article/${u.permalink}" class="links">View Full Story</a></div>
        </div>
      </div>
    </c:forEach>
    
    <jsp:include page="footer.jsp" />
  </body>
</html>
