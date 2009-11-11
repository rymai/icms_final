package icms_servlet;

import icms_ejb.*;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionsServlet extends HttpServlet {

  @EJB
  private icms_ejb.GestionnaireArticlesLocal gestionnaireArticles;
  @EJB
  private icms_ejb.GestionnaireUsersLocal gestionnaireUsers;
  @EJB
  private icms_ejb.GestionnaireSessionsLocal gestionnaireSessions;
  
  // Not EJB
  private static HttpSession session;
  private String page = "index.jsp";

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    SessionsServlet.getSession(request);
    User u = SessionsServlet.getUserFromSession(gestionnaireUsers);
    request.setAttribute("current_user", u);

    // Priority for the action parameter passed by the page, not by the servlet config
    int action = request.getParameter("action") != null ? Integer.parseInt(request.getParameter(
            "action")) : getServletConfig().getInitParameter("action") != null ? Integer.parseInt(getServletConfig().
            getInitParameter("action")) : -1;

    switch (action) {
      case Config.CREATE:
        User user = gestionnaireUsers.findUserByLoginAndPassword(request.getParameter("login"),
                                                                 request.getParameter("password"));
        if (user != null) {
          setUserToSession(user);
          List<User> listeUsers = gestionnaireUsers.all();
          request.setAttribute("listeUsers", listeUsers);
          page = "index.jsp";
        } else {
          page = "login";
        }
        break;

      case Config.DESTROY:
        session.removeAttribute("user_id");
        if (gestionnaireSessions.destroy()) {
          page = "";
        }
        break;

      default:
        page = getUserFromSession(gestionnaireUsers) != null ? "admin" : "";
        break;
    }

    RequestDispatcher dp = request.getRequestDispatcher("/" + page);
    dp.forward(request, response);
  }

  public static HttpSession getSession(HttpServletRequest request) {
    session = request.getSession(true);
    return request.getSession(true);
  }

  public void setUserToSession(User user) {
    System.out.println("user "+user.getLogin() + " mis en session!");
    session.setAttribute("user_id", user.getId());
    System.out.println("setUserToSession, user_id : " + session.getAttribute("user_id"));
  }

  public static User getUserFromSession(GestionnaireUsersLocal gestionnaire) {
    Integer id = null;
    id = (Integer) session.getAttribute("user_id");
    if (id != null)
      return gestionnaire.find(id);
    return null;
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
