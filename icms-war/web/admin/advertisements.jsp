<%@page import="icms_ejb.*" %>
<%@page import="icms_util.*" %>
<%@page import="icms_plugin.advertisement.*" %>
<%@page import="icms_servlet.*;" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        HtmlUtil HtmlUtil = new HtmlUtil();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin > Publicit&eacute;s</title>
        <jsp:include page="/partials/_head.jsp" />
        <jsp:include page="tinyMCE.html" />
    </head>
    <body>
        <jsp:include page="../header.jsp" />

        <h2><a href="" class="category">Publicit&eacute;s</a></h2>
        <br />
        <div id="listeAdvertisements">
            <table border="1">
                <tr>
                    <td><strong>Titre</strong></td>
                    <td><strong>Lien</strong></td>
                    <td><strong>Service</strong></td>
                    <td><strong>Crit&egrave;re</strong></td>
                    <td><strong>Valeur</strong></td>
                    <td><strong>Supprimer</strong></td>
                </tr>
                <c:forEach var="u" items="${requestScope['listeAdvertisements']}">
                    <tr>
                        <td><a href="/icms-war/admin/advertisements?action=<%=Config.EDIT%>&id=${u.id}">${u.title}</a></td>
                        <td>${u.link}</td>
                        <td>${u.service}</td>
                        <td>${u.criteria}</td>
                        <td>${u.criteriaValue}</td>
                        <td><a href="/icms-war/admin/advertisements?action=<%=Config.DESTROY%>&id=${u.id}"> X </a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br />

        <div id="tinyMCE">
            <h3>Nouvelle publicit&eacute;</h3>
            <form method="post" action="/icms-war/admin/advertisements">
                <input type="hidden" id="action" name="action" value="<%= Config.CREATE%>" />

                <table>
                    <tr>
                        <td><label for="title">Titre de la publicit&eacute; :</label></td>
                        <td><input type="text" id="title" name="title"></td>
                    </tr>
                    <tr>
                        <td><label for="link">Lien:</label></td>
                        <td><input type="text" id="link" name="link"></td>
                    </tr>
                    <%
            out.write(HtmlUtil.select("service", "Service :", Advertisement.servicesForSelect(), ""));
                    %>
                    <%
            out.write(HtmlUtil.select("criteria", "Crit&egrave;re :", Advertisement.criteriasForSelect(), ""));
                    %>
                    <tr>
                        <td><label for="criteria_value">Valeur :</label></td>
                        <td><input type="text" id="criteria_value" name="criteria_value"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><label for="content">Text :</label>
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