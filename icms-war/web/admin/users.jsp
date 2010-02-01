<%@page import="icms_servlet.*;" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

        <table class="admin_table">
            <tr>
                <th>Login</th>
                <th>Password</th>
                <th>Permission</th>
                <th>Supprimer</th>
            </tr>

            <c:forEach var="u" items="${requestScope['listUsers']}">
                <tr>
                    <td><a href="/icms-war/admin/users?action=<%=Config.EDIT%>&id=${u.id}">${u.login}</a></td>
                    <td>${u.password}</td>
                    <td class="center">${u.permission}</td>
                    <td><a href="/icms-war/admin/users?action=<%=Config.DESTROY%>&id=${u.id}" class="destroy"><span>X</span></a></td>
                </tr>
            </c:forEach>
        </table>

        <br />
        <h3>Nouvel utilisateur</h3>
        <form method="post" action="/icms-war/admin/users" class="new">
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
                    <td colspan="2"><input type="submit" name="save" value="Cr&eacute;er" /></td>
                </tr>
            </table>
        </form>

        <jsp:include page="footer_admin.jsp" />
    </body>
</html>
