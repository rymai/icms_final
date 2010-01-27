package icms_util;

import icms_servlet.*;
import icms_controller.GestionnaireUsersLocal;
import icms_ejb.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class SecurityUtil {

    public static boolean checkUserIsAuthenticated(HttpServletRequest request,
                                                   HttpServletResponse response,
                                                   GestionnaireUsersLocal gestionnaireUsers) throws
            ServletException,
            IOException {

        User u = SessionsServlet.getUserFromSession(gestionnaireUsers);
        if (u == null) {
            RequestDispatcher dp = request.getRequestDispatcher("/");
            request.setAttribute("flash", "Vous devez être logué pour accéder à l'admin!");
            dp.forward(request, response);
            return false;
        } else {
            request.setAttribute("current_user", u);
            return true;
        }
    }
}
