<%@ page language="java" import="icms_ejb.*" %>
<%@page import="icms_servlet.PagesServlet;" %>
<%@page import="java.util.List;" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        User u = (User) request.getAttribute("current_user");
        
%>
<div id="log_top_right">
    <% if (u != null) {%>
    <form method="post" action="/icms-war/logout">
        <input type="submit" name="logout" value="Log out <%= u.getLogin()%>" />
    </form>
    <% } else {%>
    <jsp:include page="login.jsp" />
    <% }%>
</div>

<div id="logo">
    <h1><a href="/icms-war">ICMS </a></h1>
    <p>the first intelligent CMS!</p>
</div>
<hr />
<!-- end #logo -->
<div id="header">
    <div id="menu">
        <ul>
            <% boolean admin = request.getRequestURI().indexOf("admin") != -1;%>
            <li class="<%= !admin ? "current_page_item" : ""%>"><a href="/icms-war/articles" class="first">Home</a></li>
            <c:forEach var="u" items="${requestScope['listeCategories']}">
                <li class="<%= !admin ? "current_page_item" : ""%>"><a href="/icms-war/article/cat:${u.permalink}">${u.title}</a></li>
            </c:forEach>
            <li class="<%= admin ? "current_page_item" : ""%>"><a href="/icms-war/admin/articles">Admin</a></li>

        </ul>
    </div>
    <!-- end #menu -->
    <div id="search">
        <form method="get" action="/search">
            <fieldset>
                <input type="text" name="s" id="search-text" size="15" />
                <input type="submit" id="search-submit" value="GO" />
            </fieldset>
        </form>
    </div>
    <!-- end #search -->
</div>
<!-- end #header -->
<!-- end #header-wrapper -->
<div id="page">
<div id="content2">
<%
        if (request.getAttribute("flash") != null) {%>
<%= request.getAttribute("flash")%>
<% }%>