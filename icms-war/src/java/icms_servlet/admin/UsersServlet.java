package icms_servlet.admin;

import icms_servlet.*;
import icms_ejb.*;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

public class UsersServlet extends HttpServlet {

  @EJB
  private GestionnaireUsersLocal gestionnaireUsers;
  // Not EJB
  private String page;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    if (!Security.checkUserIsAuthenticated(request, response, gestionnaireUsers)) {
      return;
    }

    // Priority for the action parameter passed by the page, not by the servlet config
    int action = request.getParameter("action") != null ? Integer.parseInt(request.getParameter(
            "action")) : getServletConfig().getInitParameter("action") != null ? Integer.parseInt(getServletConfig().
            getInitParameter("action")) : -1;

    switch (action) {
      case Config.INDEX:
        List<User> listeUsers = gestionnaireUsers.all();
        request.setAttribute("listeUsers", listeUsers);
        page = "admin/users.jsp"; // render
        break;

      case Config.CREATE:
        gestionnaireUsers.create((String) request.getParameter("login"), (String) request.
                getParameter("password"), (String) request.getParameter("level"));
        // request.setAttribute("flash", "L'utilisateur a été créé!");
        // Trouver un moyen de faire passer un flash lorsqu'on redirige... ?
        response.sendRedirect("/icms-war/admin/users");
        return;

      default:
        page = "admin/users"; // redirect
        break;
    }

    RequestDispatcher dp = request.getRequestDispatcher("/" + page);
    dp.forward(request, response);
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}