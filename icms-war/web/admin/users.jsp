<%@page import="icms_servlet.*;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin > Users</title>
    <link href="/icms-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
  </head>
  <body>
    <jsp:include page="../header.jsp" />

    <jsp:include page="admin_menu.jsp" />

    <h2>Utilisateurs</h2>

    <table border="1">
      <tr>
        <td><b>Login</b></td>
        <td><b>Password</b></td>
        <td><b>Level</b></td>
      </tr>

      <c:forEach var="u" items="${requestScope['listeUsers']}">
        <tr>
          <td>${u.login}</td>
          <td>${u.password}</td>
          <td>${u.lvl}</td>
        </tr>
      </c:forEach>
    </table>

    <h3>Nouvel utilisateur</h3>
    <form method="post" action="/icms-war/admin/users">
      <input type="hidden" id="action" name="action" value="<%= Config.CREATE%>" />
      <label for="login">Login :</label>
      <input type="text" id="login" name="login">
      <br />
      <label for="password">Password :</label>
      <input type="text" id="password" name="password">
      <br />
      <label for="level">Level :</label>
      <input type="text" id="level" name="level">
      <input type="submit" name="save" value="Valider" />
    </form>

    <jsp:include page="../footer.jsp" />
  </body>
</html>
