<%@page import="icms_ejb.*" %>
<%@page import="icms_util.*" %>
<%@page import="icms_plugin.advertisement.*" %>
<%@page import="icms_servlet.*" %>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
        HtmlUtil HtmlUtil = new HtmlUtil();
        Advertisement ad = (Advertisement) request.getAttribute("advertisement");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin > Publicit&eacute; > &Eacute;dition</title>
        <jsp:include page="/partials/_head.jsp" />
        <jsp:include page="tinyMCE.html" />
    </head>
    <body>
        <jsp:include page="../header.jsp" />

        <h2><a href="" class="category">&Eacute;dition d'article</a></h2>

        <div id="tinyMCE">
            <form method="post" action="/icms-war/admin/advertisements">
                <input type="hidden" id="action" name="action" value="<%= Config.UPDATE%>" />
                <input type="hidden" id="id" name="id" value="<c:out value="${requestScope['advertisement'].id}" />" />

                <table>
                    <tr>
                        <td><label for="title">Titre de la publicit&eacute; :</label></td>
                        <td><input type="text" id="title" name="title" value="<c:out value="${requestScope['advertisement'].title}" escapeXml="false"/>"></td>
                    </tr>
                    <tr>
                        <td><label for="link">Lien:</label></td>
                        <td><input type="text" id="link" name="link" value="<c:out value="${requestScope['advertisement'].link}" escapeXml="false"/>"></td>
                    </tr>
                    <%
            out.write(HtmlUtil.select("service", "Service :", Advertisement.servicesForSelect(), ad.getService()));
                    %>
                    <%
            out.write(HtmlUtil.select("criteria", "Crit&egrave;re :", Advertisement.criteriasForSelect(), ad.getCriteria()));
                    %>
                    <tr>
                        <td><label for="criteria">Crit&egrave;re :</label></td>
                        <td><input type="text" id="criteria" name="criteria" value="<c:out value="${requestScope['advertisement'].criteria}" escapeXml="false"/>"></td>
                    </tr>
                    <tr>
                        <td><label for="criteria_value">Valeur :</label></td>
                        <td><input type="text" id="criteria_value" name="criteria_value" value="<c:out value="${requestScope['advertisement'].criteriaValue}" escapeXml="false"/>"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><label for="content">Text :</label>
                            <textarea id="content" name="content" rows="20" cols="80"><c:out value="${requestScope['advertisement'].content}" escapeXml="false"/></textarea></td>
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