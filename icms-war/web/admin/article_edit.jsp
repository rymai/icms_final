<%@page language="java" import="icms_ejb.*" %>
<%@page import="icms_helper.*;import java.util.List" %>
<%@page import="icms_servlet.*;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        HtmlHelper htmlHelper = new HtmlHelper();
        Page article = (Page) request.getAttribute("article");
        List<Page> listPages = (List<Page>) request.getAttribute("listPages");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin > Article > &Eacute;dition</title>
        <jsp:include page="/partials/_head.jsp" />
        <jsp:include page="tinyMCE.html" />
    </head>
    <body>
        <jsp:include page="../header.jsp" />

        <h2><a href="" class="category">&Eacute;dition d'article</a></h2>

        <div id="tinyMCE">
            <form method="post" action="/icms-war/admin/articles">
                <input type="hidden" id="action" name="action" value="<%= Config.UPDATE%>" />
                <input type="hidden" id="id" name="id" value="<c:out value="${requestScope['article'].id}" />" />

                <table>
                    <%
        out.write(htmlHelper.select("section_id", "Article parent :", Page.pagesForSelect(listPages),
                                    article.getMyParent().
                getId()));
                    %>
                    <tr>
                        <td><label for="title">Titre :</label></td>
                        <td><input type="text" id="title" name="title" value="<c:out value="${requestScope['article'].title}" escapeXml="false"/>"></td>
                    </tr>
                    <tr>
                        <td><label for="permalink">Permalink :</label></td>
                        <td><input type="text" id="permalink" name="permalink" value="<c:out value="${requestScope['article'].permalink}" escapeXml="false"/>"> (auto-g&eacute;n&eacute;r&eacute; par d&eacute;faut)</td>
                    </tr>
                    <%
        out.write(htmlHelper.select("prefered_sex", "Sexe vis&eacute; :", Page.
                preferedSexesForSelect(), article.getPreferedSex()));
                    %>
                    <tr>
                        <td colspan="2"><label for="intro">Intro :</label>
                            <textarea id="intro" name="intro" rows="5" cols="80"><c:out value="${requestScope['article'].intro}" escapeXml="false"/></textarea></td>
                    </tr>
                    <tr>
                        <td colspan="2"><label for="content">Texte :</label>
                            <textarea id="content" name="content" rows="20" cols="80"><c:out value="${requestScope['article'].content}" escapeXml="false"/></textarea></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" name="save" value="Mettre &agrave; jour" /></td>
                    </tr>
                </table>
            </form>
        </div>

        <jsp:include page="footer_admin.jsp" />
    </body>
</html>