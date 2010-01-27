<%@page language="java" import="icms_ejb.*" %>
<%@page import="icms_helper.*;import java.util.List" %>
<%@page import="icms_servlet.*;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        HtmlUtil HtmlUtil = new HtmlUtil();
        List<Page> listPages = (List<Page>) request.getAttribute("listPages");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin > Articles</title>
        <jsp:include page="/partials/_head.jsp" />
        <jsp:include page="tinyMCE.html" />
    </head>
    <body>
        <jsp:include page="../header.jsp" />

        <h2><a href="" class="category">Articles</a></h2>
        <br />
        <div id="listPages">
            <table border="1">
                <tr>
                    <td><strong>Titre</strong></td>
                    <td><strong>Parent</strong></td>
                    <td><strong>Sexe vis&eacute;</strong></td>
                    <td><strong>Publi&eacute; le</strong></td>
                    <td><strong>Modifi&eacute; le</strong></td>
                    <td><strong>Supprimer</strong></td>
                </tr>
                <c:forEach var="u" items="${requestScope['listPages']}">
                    <tr>
                        <td><a href="/icms-war/admin/articles?action=<%=Config.EDIT%>&id=${u.id}">${u.title}</a></td>
                        <td>${u.myParent.title}</td>
                        <td>${u.preferedSex}</td>
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

                <table>
                    <%
        out.write(HtmlUtil.select("section_id", "Article parent :", Page.pagesForSelect(listPages),
                                    ""));
                    %>
                    <tr>
                        <td><label for="title">Titre :</label></td>
                        <td><input type="text" id="title" name="title"></td>
                    </tr>
                    <tr>
                        <td><label for="permalink">Permalink :</label></td>
                        <td><input type="text" id="permalink" name="permalink"> (auto-g&eacute;n&eacute;r&eacute; par d&eacute;faut)</td>
                    </tr>
                    <%
        out.write(HtmlUtil.select("prefered_sex", "Sexe vis&eacute; :", Page.
                preferedSexesForSelect(), ""));
                    %>
                    <tr>
                        <td colspan="2"><label for="intro">Intro :</label>
                            <textarea id="intro" name="intro" rows="5" cols="80"></textarea></td>
                    </tr>
                    <tr>
                        <td colspan="2"><label for="content">Texte :</label>
                            <textarea id="content" name="content" rows="20" cols="80"></textarea></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="save" value="Valider" /></td>
                    </tr>
                </table>
            </form>
        </div>

        <jsp:include page="footer_admin.jsp" />
    </body>
</html>