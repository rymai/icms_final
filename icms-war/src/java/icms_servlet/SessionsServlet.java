package ICMSservlet;

import ICMSejb.*;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionsServlet extends HttpServlet {

  @EJB
  private GestionnaireUsersLocal gestionnaireUsers;
  
  // Not EJB
  private String page = "index";

  // Actions
  public final static int INDEX = 1;
  public final static int NEW = 2;
  public final static int CREATE = 3;
  public final static int SHOW = 4;
  public final static int EDIT = 5;
  public final static int UPDATE = 6;
  public final static int DESTROY = 7;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    switch (Integer.parseInt(request.getParameter("action"))) {
      case CREATE:
        User user = gestionnaireUsers.findUserByLoginAndPassword(request.getParameter("login"),
                                                                 request.getParameter("password"));
        if (user != null) {
          // Initialiser la session (cookies)
          List<User> listeUsers = gestionnaireUsers.all();
          request.setAttribute("listeUsers", listeUsers);
          page = "consoleAdmin";
        } else page = "admin";
        break;
    }
    
    RequestDispatcher dp = request.getRequestDispatcher(page + ".jsp");
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
