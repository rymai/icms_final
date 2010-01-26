package icms_helper;

import javax.servlet.http.*;

public class UtilHelper {

    public static boolean isAjaxRequest(HttpServletRequest request) {
        return (request.getHeader("x-requested-with") != null && request.getHeader(
                "x-requested-with").equals("XMLHttpRequest"));
    }
}
