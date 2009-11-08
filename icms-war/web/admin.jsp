<%@page import="ICMS.SessionsServlet;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="/ICMS-war/login" method="post">
          <input type="hidden" name="action" value="<%= SessionsServlet.CREATE %>" />
          Login : <input type="text" name="login">
          Password : <input type="password" name="password">
          <input type="submit" value="Se loguer">
        </form>
    </body>
</html>
