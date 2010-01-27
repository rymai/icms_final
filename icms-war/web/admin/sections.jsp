<%@page import="icms_servlet.*;" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin > Sections</title>
        <link href="/icms-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
        <jsp:include page="tinyMCE.html" />
    </head>
    <body>
        <jsp:include page="../header.jsp" />

        <h2><a href="" class="category">Sections</a></h2>
        <br />
        <div id="listSections">
            <table border="1">
                <tr>
                    <td>Titre</td>
                    <td>Cat&eacute;gorie</td>
                    <td>Supprimer</td>
                </tr>
                <c:forEach var="u" items="${requestScope['listSections']}">
                    <tr>
                        <td><a href="/icms-war/admin/sections?action=<%=Config.EDIT%>&id=${u.id}">${u.title}</a></td>
                        <td>${u.myCategory.title}</td>
                        <td><a href="/icms-war/admin/sections?action=<%=Config.DESTROY%>&id=${u.id}">X</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br />

        <div id="tinyMCE">
            <h3>Nouvelle section</h3>
            <form method="post" action="/icms-war/admin/sections">
                <input type="hidden" id="action" name="action" value="<%= Config.CREATE%>" />

                <label for="category_id">Cat&eacute;gorie :</label>
                <select name="category_id" id="category_id">
                    <c:forEach var="u" items="${requestScope['listCategories']}">
                        <option value="${u.id}">${u.title}</option>
                    </c:forEach>
                </select>
                <br />
                <label for="title">Titre de la section :</label>
                <input type="text" id="title" name="title">
                <br />
                <label for="permalnk">Permalink :</label>
                <input type="text" id="permalink" name="permalink"> (auto-g&eacute;n&eacute;r&eacute; par d&eacute;faut)
                <br />
                <label for="intro">Intro :</label>
                <textarea id="intro" name="intro" rows="5" cols="80"></textarea>
                <br />
                <label for="content">Text :</label>
                <textarea id="content" name="content" rows="20" cols="80"></textarea>
                <input type="submit" name="save" value="Valider" />
            </form>
        </div>

        <jsp:include page="footer_admin.jsp" />
    </body>
</html>