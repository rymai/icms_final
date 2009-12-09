<%@page language="java" import="icms_ejb.*" %>
<%@page language="java" import="icms_helper.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        Page a = (Page) request.getAttribute("article");
        TranslateHelper translator = null;
        FlickrHelper flickr = new FlickrHelper(a.getTermsForSearch());
        if (request.getParameter("translate_to") != null) {
            translator = new TranslateHelper((String) request.getParameter("translate_to"));
        }
%>
<h2 class="title"><a href="/icms-war/article/<c:out value="${requestScope['article'].permalink}" escapeXml="true"/>">
        <% if (translator != null) {
            out.write(translator.translateAndGet(a.getTitle()));
        } else {%>
        <c:out value="${requestScope['article'].title}" escapeXml="false"/>
        <%}%>
    </a></h2>
<p class="meta">
    <c:out value="${requestScope['article'].publishedAt}" escapeXml="false"/>
</p>
<div class="entry">
    <% if (translator != null) {
            out.write(translator.translateAndGet(a.getIntro()));
        } else {%>
    <c:out value="${requestScope['article'].intro}" escapeXml="false"/>
    <%}%>
    <hr class="visible" />
    <% if (translator != null) {
            out.write(translator.translateAndGet(a.getContent()));
        } else {%>
    <c:out value="${requestScope['article'].content}" escapeXml="false"/>
    <%}%>

    <% if (translator == null) {%>
    <div id="flickr">
        <%= flickr.getFlickrResults()%>
    </div>
    <% }%>
</div>