package icms_util;

import javax.servlet.http.*;

public class RequestUtil {

    public static boolean isAjaxRequest(HttpServletRequest request) {
        return (request.getHeader("x-requested-with") != null && request.getHeader(
                "x-requested-with").equals("XMLHttpRequest"));
    }
}
