<%@page import="icms_servlet.*;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin > Cat&eacute;gorie > &Eacute;dition</title>
        <link href="/icms-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
        <jsp:include page="tinyMCE.html" />
    </head>
    <body>
        <jsp:include page="../header.jsp" />

        <h2><a href="" class="category">&Eacute;dition de cat&eacute;gorie</a></h2>

        <div id="tinyMCE">
            <form method="post" action="/icms-war/admin/categories">
                <input type="hidden" id="action" name="action" value="<%= Config.UPDATE%>" />
                <input type="hidden" id="id" name="id" value="<c:out value="${requestScope['category'].id}" />" />

                <label for="title">Titre de la cat&eacute;gorie :</label>
                <input type="text" id="title" name="title" value="<c:out value="${requestScope['category'].title}" />">
                <br />

                <label for="permalnk">Permalink :</label>
                <input type="text" id="permalink" name="permalink" value="<c:out value="${requestScope['category'].permalink}" />"> (auto-g&eacute;n&eacute;r&eacute; par d&eacute;faut)
                <br />

                <label for="intro">Intro :</label>
                <textarea id="intro" name="intro" rows="5" cols="80"><c:out value="${requestScope['category'].intro}" /></textarea>
                <br />

                <label for="content">Text :</label>
                <textarea id="content" name="content" rows="20" cols="80"><c:out value="${requestScope['category'].content}" /></textarea>
                <input type="submit" name="save" value="Valider" />
            </form>
        </div>

        <jsp:include page="footer_admin.jsp" />
    </body>
</html>