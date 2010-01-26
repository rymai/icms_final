<%@page language="java" import="icms_ejb.*" %>
<%@page language="java" import="icms_helper.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        Page a = (Page) request.getAttribute("article");
        FlickrHelper flickr = new FlickrHelper(a.getTermsForSearch());
%>
<h2 class="title"><a href="/icms-war/article/<c:out value="${requestScope['article'].permalink}" escapeXml="true"/>">
        <c:out value="${requestScope['article'].title}" escapeXml="false"/>
    </a></h2>
<p class="meta">
    <c:out value="${requestScope['article'].publishedAt}" escapeXml="false"/>
</p>
<div class="entry">
    <c:out value="${requestScope['article'].intro}" escapeXml="false"/>
    <hr class="visible" />
    <c:out value="${requestScope['article'].content}" escapeXml="false"/>

    <div id="flickr">
        <%= flickr.getFlickrResults()%>
    </div>
</div>