<%@page import="icms_servlet.*;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin > Article > &Eacute;dition</title>
        <link href="/icms-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
        <jsp:include page="tinyMCE.html" />
    </head>
    <body>
        <jsp:include page="../header.jsp" />

        <h2><a href="" class="category">&Eacute;dition d'article</a></h2>

        <div id="tinyMCE">
            <form method="post" action="/icms-war/admin/articles">
                <input type="hidden" id="action" name="action" value="<%= Config.UPDATE%>" />
                <input type="hidden" id="id" name="id" value="<c:out value="${requestScope['article'].id}" />" />
                <label for="section_id">Section :</label>
                <select name="section_id" title="section_id" id="section_id">
                       <option value="0">Pas de parent</option>
                    <option value="<c:out value="${requestScope['article'].myParent.id}" escapeXml="false"/>"><c:out value="${requestScope['article'].myParent.title}" escapeXml="false"/></option>
                    <c:forEach var="u" items="${requestScope['listeArticles']}">
                        <option value="${u.id}">${u.title}</option>
                    </c:forEach>
                </select>
                <br />
                <label for="title">Titre de l'article :</label>
                <input type="text" id="title" name="title" value="<c:out value="${requestScope['article'].title}" escapeXml="false"/>">
                <br />
                <label for="permalnk">Permalink :</label>
                <input type="text" id="permalink" name="permalink" value="<c:out value="${requestScope['article'].permalink}" escapeXml="false"/>"> (auto-g&eacute;n&eacute;r&eacute; par d&eacute;faut)
                <br />
                <label for="intro">Intro :</label>
                <textarea id="intro" name="intro" rows="5" cols="80" ><c:out value="${requestScope['article'].intro}" escapeXml="false"/></textarea>
                <br />
                <label for="content">Text :</label>
                <textarea id="content" name="content" rows="20" cols="80"><c:out value="${requestScope['article'].content}" escapeXml="false"/></textarea>
                <input type="submit" name="save" value="Valider" />
            </form>
        </div>

        <jsp:include page="footer_admin.jsp" />
    </body>
</html>