<%@page import="icms_servlet.ArticlesServlet;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="/icms-war/tinymce/jscripts/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
  tinyMCE.init({
    // General options
    mode : "textareas",
    theme : "advanced",
    languages : 'fr',
    plugins : "safari,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount",

    // Theme options
    theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
    theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
    theme_advanced_toolbar_location : "top",
    theme_advanced_toolbar_align : "left",
    theme_advanced_statusbar_location : "bottom",
    theme_advanced_resizing : true

  });
</script>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin!</title>
    <link href="/icms-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
  </head>
  <body>
    <jsp:include page="header.jsp" />
    <div id="affiche">
      <h2>Liste des utilisateurs</h2>
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
    </div>

    <div id="tinyMCE">
      <form method="post" action="/icms-war/articles/create">
        <label for="title">Titre de l'article :</label>
        <input type="text" id="title" name="title">
        <br />
        <label for="permalnk">Permalink :</label>
        <input type="text" id="permalink" name="permalink"> (auto-g&eacute;n&eacute;r&eacute; par d&eacute;faut)
        <br />
        <label for="intro">Intro :</label>
        <textarea id="intro" name="intro" rows="5" cols="80"></textarea>
        <br />
        <label for="content">Text :</label>
        <textarea id="content" name="content" rows="20" cols="80"></textarea>
        <input type="submit" name="save" value="Valider" />
      </form>
    </div>

    <jsp:include page="footer.jsp" />
  </body>
</html>
