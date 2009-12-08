<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</div><!-- end #content -->
<div id="sidebar">
    <ul>
        <li>
            <h2>Categories</h2>
            <ul>
                <c:forEach var="c" items="${requestScope['listeCategories']}">
                    <li><a href="/icms-war/article/cat:${c.permalink}">${c.title}</a></li>
                </c:forEach>
            </ul>
        </li>
    </ul>
</div>
<!-- end #sidebar -->
<div style="clear: both;">&nbsp;</div>
</div>
<!-- end #page -->
<div id="footer">
    <p>Copyright (c) 2009 ICMS.com. All rights reserved.</p>
</div>
<!-- end #footer -->

<script type="text/javascript" src="/icms-war/js/dojo/dojo.js" djConfig="parseOnLoad:true"></script>
<script type="text/javascript" src="/icms-war/js/behaviours.js"></script>