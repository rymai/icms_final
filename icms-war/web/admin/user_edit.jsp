<%@page import="icms_servlet.*;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin > Utilisateur > &Eacute;dition</title>
        <jsp:include page="/partials/_head.jsp" />
    </head>
    <body>
        <jsp:include page="../header.jsp" />

        <h2><a href="" class="category">&Eacute;dition d'utilisateur</a></h2>

        <form method="post" action="/icms-war/admin/users">
            <input type="hidden" id="action" name="action" value="<%= Config.UPDATE%>" />
                <input type="hidden" id="id" name="id" value="<c:out value="${requestScope['user'].id}" />" />

            <table>
                <tr>
                    <td><label for="login">Login :</label></td>
                    <td><input type="text" id="login" name="login" value="<c:out value="${requestScope['user'].login}" escapeXml="false"/>"></td>
                </tr>
                <tr>
                    <td><label for="password">Password :</label></td>
                    <td><input type="text" id="password" name="password"></td>
                </tr>
                <tr>
                    <td><label for="level">Level :</label></td>
                    <td><input type="text" id="level" name="level" value="<c:out value="${requestScope['user'].lvl}" escapeXml="false"/>"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="save" value="Mettre &agrave; jour" /></td>
                </tr>
            </table>
        </form>

        <jsp:include page="footer_admin.jsp" />
    </body>
</html>
