<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="sections">
    <br />
    <h3>Les sous-sections :</h3>
    <ul>
        <c:forEach var="u" items="${requestScope['listSections']}">
            <li><a href="/icms-war/article/${u.permalink}">${u.title}</a></li>
        </c:forEach>
    </ul>
</div>