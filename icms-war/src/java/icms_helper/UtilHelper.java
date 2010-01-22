package icms_helper;

import java.lang.String;
import javax.servlet.http.*;

public class UtilHelper {

    @SuppressWarnings("empty-statement")
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String[][] b = {{"test","test2"}};

        return (request.getHeader("x-requested-with") != null && request.getHeader(
                "x-requested-with").equals("XMLHttpRequest"));
    }
}
