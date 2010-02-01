<%@page language="java" import="icms_ejb.*" %>
<%@page language="java" import="icms_helper.*" %>
<%@page language="java" import="icms_servlet.*" %>
<%@page language="java" import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        User u = (User) request.getAttribute("current_user");
        WeatherHelper meteo = new WeatherHelper((String) SessionsServlet.getFromSession("ipCity"));
        List<Page> listCategories = (List<Page>) request.getAttribute("listCategories");
        String url = (String)request.getAttribute("url");
%>

<div id="log_top_right">

    <% if (u != null) {%>
    <form name="logout_form" id="logout_form" method="post" action="/icms-war/logout">
        <input type="submit" name="logout" value="Se d&eacute;connecter (<%= u.getLogin()%>)" />
    </form>
    <% } else {%>
    <jsp:include page = "login.jsp" />
    <% }%>
</div>

<div id="user_infos"></div>

<div id="logo">    
    <h1><a href="/icms-war">ICMS </a></h1>
    <p>the first intelligent CMS!</p>
</div>
<hr />
<!-- end #logo -->
<div id="header">
    <div id="menu">
        <ul>
            <% Boolean current_item = url.indexOf("icms-war/articles") != -1; %>
            <li class="<%= current_item ? "current_page_item" : ""%>"><a href="/icms-war/articles">Accueil</a></li>
            <%
            for (Page p : listCategories) {
                        current_item = url.indexOf(p.getPermalink()) != -1;
                        out.write("<li class=\"" + (current_item ? "current_page_item" : "") + "\"><a href=\"/icms-war/article/" + p.
                                getPermalink() + "\">" + p.getTitle() + "</a></li>");
                    }%>
            <li class="<%= url.indexOf("icms-war/admin") != -1 ? "current_page_item" : "" %>"><a href="/icms-war/admin/articles">Admin</a></li>
        </ul>
    </div>
    <!-- end #menu -->
    <%--    <div id="search">
            <form method="get" action="/search">
                <fieldset>
                    <input type="text" name="s" id="search-text" size="15" />
                    <input type="submit" id="search-submit" value="GO" />
                </fieldset>
            </form>
        </div>--%>

    <!-- end #search -->
</div>
<!-- end #header -->
<!-- end #header-wrapper -->
<div id="page">
    <div id="meteo">
        <span id="conditions"><%= meteo.currentCondition()%></span>
        <span id="temperature"><%= meteo.currentTemperature()%></span>
    </div>
    <div id="content2">
        <%
        if (request.getAttribute("flash") != null) {%>
        <%= request.getAttribute("flash")%>
        <% }%>