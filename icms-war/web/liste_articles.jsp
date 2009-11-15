<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="posts">
    <c:forEach var="u" items="${requestScope['listeArticles']}">
        <div class="post">
            <h2 class="title"><a href="/icms-war/article/art:${u.permalink}">${u.title}</a></h2>
            <p class="meta">
                ${u.publishedAt}
                <%--Posted by <a href="#">${u.author.name}</a>--%>
            </p>
            <div class="entry">
                ${u.intro}
                <div><a href="/icms-war/article/art:${u.permalink}" class="links">View Full Story</a></div>
            </div>
        </div>
    </c:forEach>
</div>