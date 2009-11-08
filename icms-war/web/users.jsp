<%-- 
    Document   : users
    Created on : 31 oct. 2009, 14:48:45
    Author     : Chouchou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <c:forEach var="u" items="${requestScope['ListeUsers']}">
            <tr><td>${u.login}</td><td>${u.password}</td><td>${u.lvl}</td></tr>
       </c:forEach>
       </table>
    </body>
</html>
