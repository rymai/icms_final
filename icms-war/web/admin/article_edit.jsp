<%@page import="icms_servlet.*;" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin > Article > Edit</title>
    <link href="/icms-war/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
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
  </head>
  <body>
    <jsp:include page="../header.jsp" />

    <jsp:include page="admin_menu.jsp" />

       <div id="tinyMCE">
      <form method="post" action="/icms-war/admin/articles">
        <input type="hidden" id="action" name="action" value="<%= Config.UPDATE%>" />
         <input type="hidden" id="idArticle" name="idArticle" value="<c:out value="${requestScope['article'].id}" />" />
          <label for="section">Section :</label>
                <select name="section" title="section" id="section">
                    <option value="<c:out value="${requestScope['article'].mySection.permalink}" escapeXml="false"/>"><c:out value="${requestScope['article'].mySection.title}" escapeXml="false"/></option>
                    <c:forEach var="u" items="${requestScope['listeSections']}">
                        <option value="${u.permalink}">${u.title}</option>
                    </c:forEach>
                </select>
                <br />
       <label for="title">Titre de l'article :</label>
        <input type="text" id="title" name="title" value="<c:out value="${requestScope['article'].title}" escapeXml="false"/>">
        <br />
        <label for="permalnk">Permalink :</label>
        <input type="text" id="permalink" name="permalink" value="<c:out value="${requestScope['article'].permalink}" escapeXml="false"/>"> (auto-g&eacute;n&eacute;r&eacute; par d&eacute;faut)
        <br />
        <label for="intro">Intro :</label>
        <textarea id="intro" name="intro" rows="5" cols="80" ><c:out value="${requestScope['article'].intro}" escapeXml="false"/></textarea>
        <br />
        <label for="content">Text :</label>
        <textarea id="content" name="content" rows="20" cols="80"><c:out value="${requestScope['article'].content}" escapeXml="false"/></textarea>
        <input type="submit" name="save" value="Valider" />
      </form>
    </div>

    <jsp:include page="../footer.jsp" />
  </body>
</html>