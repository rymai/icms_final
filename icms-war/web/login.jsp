<%@page import="icms_servlet.Config;" %>
<form action="/icms-war/login" method="post">
  <input type="hidden" name="action" value="<%= Config.CREATE%>" />
  <label for="login">Login :</label> <input type="text" name="login"><br />
  <label for="password">Mot de passe :</label> <input type="password" name="password">
  <input type="submit" value="Log in">
</form>
