package icms_helper;

import icms_ejb.*;

/**
 *
 * @author remy
 */
public class HtmlHelper {

    public HtmlHelper() {
    }

    public String generateBreadCrumb(Page page) {
        Page parent = page.getMyParent();
        String html = "";
        if (parent != null) {
            html += generateBreadCrumb(parent);
        }
        if (page.hasChildren()) {
            return html += "<a href=\"/icms-war/article/" + page.getPermalink() + "\" class=\"category\">" + page.
                    getTitle() + "</a>&nbsp;&rsaquo;&nbsp;";
        }
        return html;
    }
}
