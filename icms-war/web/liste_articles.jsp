<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="posts">
    <h3>Les articles :</h3>
    <c:forEach var="a" items="${requestScope['listePages']}">
        <div class="post">
            <h2 class="title"><a href="/icms-war/article/${a.permalink}">${a.title}</a></h2>
            <p class="meta">
                Dans <strong>${a.myParent.title}</strong>&nbsp;&agrave;&nbsp;${a.publishedAt}
                <%--Posted by <a href="#">${u.author.name}</a>--%>
            </p>
            <div class="entry">
                ${a.intro}
                <div><a href="/icms-war/article/${a.permalink}" class="links">View Full Story</a></div>
            </div>
        </div>
    </c:forEach>
</div>