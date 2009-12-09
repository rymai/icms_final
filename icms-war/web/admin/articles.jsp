<%@page import="icms_servlet.*;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin > Articles</title>
    <link href="/icms-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
    <jsp:include page="tinyMCE.html" />
  </head>
  <body>
    <jsp:include page="../header.jsp" />

    <h2><a href="" class="category">Articles</a></h2>
    <br />
    <div id="listeArticles">
        <table border="1">
            <tr>
                <td>Titre</td>
               <td>Parent</td>
                <td>Publi&eacute; le</td>
                <td>Modifi&eacute; le</td>
                <td>Supprimer</td>
            </tr>
                <c:forEach var="u" items="${requestScope['listeArticles']}">
                    <tr>
                        <td><a href="/icms-war/admin/articles?action=<%=Config.EDIT%>&id=${u.id}">${u.title}</a></td>
                        <td>${u.myParent.title}</td>
                        <td>${u.publishedAt}</td>
                        <td>${u.updatedAt}</td>
                        <td><a href="/icms-war/admin/articles?action=<%=Config.DESTROY%>&id=${u.id}"> X </a></td>
                    </tr>
            </c:forEach>
        </table>
    </div>
    <br />

    <div id="tinyMCE">
      <h3>Nouvel article</h3>
      <form method="post" action="/icms-war/admin/articles">
        <input type="hidden" id="action" name="action" value="<%= Config.CREATE%>" />
         <label for="section_id">Article parent :</label>
                <select name="section_id" title="section_id" id="section_id">
                    <option value="0">Pas de parent</option>
                    <c:forEach var="u" items="${requestScope['listeArticles']}">
                        <option value="${u.id}">${u.title} (${u.myParent.title})</option>
                    </c:forEach>
                </select>
                <br />
       <label for="title">Titre de l'article :</label>
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