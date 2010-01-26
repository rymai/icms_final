<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</div><!-- end #content -->
<div id="sidebar">
    <ul>
        <li>
            <h2>Categories</h2>
            <ul>
                <c:forEach var="c" items="${requestScope['listCategories']}">
                    <li><a href="/icms-war/article/${c.permalink}">${c.title}</a></li>
                </c:forEach>
            </ul>
        </li>
        <li>
            <h2>Publicit&eacute;s</h2>
            <c:forEach var="c" items="${requestScope['listAdvertisements']}">
                <div id="ad-${c.id}" class="advertisement">
                    <span class="advertisement_info service">${c.service}</span>
                    <span class="advertisement_info criteria">${c.criteria}</span>
                    <span class="advertisement_info criteriaValue">${c.criteriaValue}</span>
                    <a href="${c.link}">${c.title}</a><br />
                    <a href="${c.link}">${c.content}</a>
                </div>
            </c:forEach>
        </li>
    </ul>
</div>
<!-- end #sidebar -->
<div style="clear: both;">&nbsp;</div>
</div>
<!-- end #page -->
<div id="footer">
    <p>Copyright (c) 2010 ICMS.com. All rights reserved.</p>
</div>
<!-- end #footer -->

<script type="text/javascript" src="http://static.ak.connect.facebook.com/js/api_lib/v0.4/FeatureLoader.js.php/en_US"></script>
<script type="text/javascript">FB.init("40a01944f542b07841734091b413f956");</script>
<script type="text/javascript" src="/icms-war/js/jquery-1.4.min.js"></script>
<script type="text/javascript" src="/icms-war/js/fb.js"></script>
<script type="text/javascript" src="/icms-war/js/behaviours.js"></script>