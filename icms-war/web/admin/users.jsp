<%@page import="icms_servlet.*;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin > Utilisateurs</title>
        <jsp:include page="/partials/_head.jsp" />
    </head>
    <body>
        <jsp:include page="../header.jsp" />

        <h2><a href="" class="category">Utilisateurs</a></h2>

        <table border="1">
            <tr>
                <td><strong>Login</strong></td>
                <td><strong>Password</strong></td>
                <td><strong>Permission</strong></td>
                <td><strong>Supprimer</strong></td>
            </tr>

            <c:forEach var="u" items="${requestScope['listUsers']}">
                <tr>
                    <td><a href="/icms-war/admin/users?action=<%=Config.EDIT%>&id=${u.id}">${u.login}</a></td>
                    <td>${u.password}</td>
                    <td>${u.permission}</td>
                    <td><a href="/icms-war/admin/users?action=<%=Config.DESTROY%>&id=${u.id}"> X </a></td>
                </tr>
            </c:forEach>
        </table>

        <br />
        <h3>Nouvel utilisateur</h3>
        <form method="post" action="/icms-war/admin/users">
            <input type="hidden" id="action" name="action" value="<%= Config.CREATE%>" />

            <table>
                <tr>
                    <td><label for="login">Login :</label></td>
                    <td><input type="text" id="login" name="login"></td>
                </tr>
                <tr>
                    <td><label for="password">Password :</label></td>
                    <td><input type="text" id="password" name="password"></td>
                </tr>
                <tr>
                    <td><label for="permission">Permission :</label></td>
                    <td><input type="text" id="permission" name="permission"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="save" value="Valider" /></td>
                </tr>
            </table>
        </form>

        <jsp:include page="footer_admin.jsp" />
    </body>
</html>
