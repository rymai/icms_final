package icms_servlet;

import icms_ejb.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Security {

  public static boolean checkUserIsAuthenticated(HttpServletRequest request,
                                                 HttpServletResponse response,
                                                 GestionnaireUsersLocal gestionnaireUsers) throws
          ServletException,
                                                                                                  IOException {
    SessionsServlet.getSession(request);
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
