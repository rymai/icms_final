package icms_helper;

import icms_ejb.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author remy
 */
public class HtmlHelper {

    public HtmlHelper() {
    }

    public String breadCrumb(Page page) {
        Page parent = page.getMyParent();
        String html = "";
        if (parent != null) {
            html += breadCrumb(parent);
        }
        if (page.hasChildren()) {
            return html += "<a href=\"/icms-war/article/" + page.getPermalink() + "\" class=\"category\">" + page.
                    getTitle() + "</a>&nbsp;&rsaquo;&nbsp;";
        }
        return html;
    }

    public String select(String select_name, String select_label, ArrayList<String[]> values_texts,
                         Object selected_value) {
        String html = "<tr><td><label for=\"" + select_name + "\">" + select_label + "</label></td><td><select id=\"" + select_name + "\" name=\"" + select_name + "\">";

        for (int i = 0; i < values_texts.size(); i++) {
            html += "<option value=\"" + values_texts.get(i)[0] + "\"";
            if (values_texts.get(i)[0].equals(selected_value.toString())) {
                html += " selected=\"selected\"";
            }
            html += ">" + values_texts.get(i)[1] + "</option>";
        }
        return html + "</select></td></tr>";
    }

    public String ad() {
//        FacebookRestClient client = new FacebookRestClient
        return "";

    }
}
