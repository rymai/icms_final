<%@page import="icms_ejb.*" %>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        List<Page> articles = (List<Page>) request.getAttribute("listArticles");
        if (articles != null && !articles.isEmpty()) {
%>
<div class="articles">
    <c:forEach var="a" items="${requestScope['listArticles']}">
        <div class="page article">
            <span class="prefered_sex">${a.preferedSex}</span>
            <h2 class="title"><a href="/icms-war/article/${a.permalink}">${a.title}</a></h2>
            <p class="meta">
                Dans <strong><a href="/icms-war/article/${a.myParent.permalink}">${a.myParent.title}</a></strong>&nbsp;le&nbsp;${a.publishedAt}
            </p>
            <div class="entry">
                ${a.intro}
                <div><a href="/icms-war/article/${a.permalink}" class="links">Voir la suite...</a></div>
            </div>
        </div>
    </c:forEach>
</div>
<%}%>