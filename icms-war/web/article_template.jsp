<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="post">
    <span class="prefered_sex"><c:out value="${requestScope['article'].preferedSex}"/></span>
    <jsp:include page="partials/_article.jsp" />
</div>