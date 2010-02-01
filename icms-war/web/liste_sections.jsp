<%@page import="icms_ejb.*" %>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        List<Page> sections = (List<Page>) request.getAttribute("listSections");
        if (sections != null && !sections.isEmpty()) {
%>

<div class="sections">
    <br />
    <h3>Sections :</h3>
    <ul>
        <c:forEach var="u" items="${requestScope['listSections']}">
            <li><a href="/icms-war/article/${u.permalink}">${u.title}</a></li>
        </c:forEach>
    </ul>
</div>
<%}%>