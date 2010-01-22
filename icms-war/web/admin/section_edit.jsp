<%@page import="icms_servlet.*;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin > Section > &Eacute;dition</title>
        <link href="/icms-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
        <jsp:include page="tinyMCE.html" />
    </head>
    <body>
        <jsp:include page="../header.jsp" />

        <h2><a href="" class="category">&Eacute;dition de section</a></h2>

        <div id="tinyMCE">
            <form method="post" action="/icms-war/admin/sections">
                <input type="hidden" id="action" name="action" value="<%= Config.UPDATE%>" />
                <input type="hidden" id="id" name="id" value="<c:out value="${requestScope['section'].id}" />" />

                <label for="category_id">Cat&eacute;gorie :</label>
                <select name="category_id" id="category_id">
                    <option value="<c:out value="${requestScope['section'].myCategory.id}" />"><c:out value="${requestScope['section'].myCategory.title}" /></option>
                    <c:forEach var="u" items="${requestScope['listCategories']}">
                        <option value="${u.id}">${u.title}</option>
                    </c:forEach>
                </select>
                <br />

                <label for="title">Titre de la section :</label>
                <input type="text" id="title" name="title" value="<c:out value="${requestScope['section'].title}" />">
                <br />

                <label for="permalnk">Permalink :</label>
                <input type="text" id="permalink" name="permalink" value="<c:out value="${requestScope['section'].permalink}" />"> (auto-g&eacute;n&eacute;r&eacute; par d&eacute;faut)
                <br />

                <label for="intro">Intro :</label>
                <textarea id="intro" name="intro" rows="5" cols="80"><c:out value="${requestScope['section'].intro}" /></textarea>
                <br />

                <label for="content">Text :</label>
                <textarea id="content" name="content" rows="20" cols="80"><c:out value="${requestScope['section'].content}" /></textarea>
                <input type="submit" name="save" value="Valider" />
            </form>
        </div>

        <jsp:include page="footer_admin.jsp" />
    </body>
</html>