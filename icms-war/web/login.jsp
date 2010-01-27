<%@page import="icms_servlet.Config;" %>

<form name="login_form" id="login_form" action="/icms-war/login" method="post">
    <input type="hidden" name="action" value="<%= Config.CREATE%>" />
    <table>
        <tr>
            <td><label for="login">Login :</label></td>
            <td><input type="text" name="login"></td>
        </tr>
        <tr>
            <td><label for="password">Mot de passe :</label></td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="S'identifier"></td>
        </tr>
    </table>
</form>
