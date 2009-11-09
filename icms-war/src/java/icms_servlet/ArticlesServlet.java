package icms_servlet;



import icms_ejb.*;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

public class ArticlesServlet extends HttpServlet {

  @EJB
  private GestionnaireArticlesLocal gestionnaireArticles;
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

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

//    System.out.println("action: " + getServletConfig().getInitParameter("action"));

    int action = getServletConfig().getInitParameter("action") != null ? Integer.parseInt(getServletConfig().
            getInitParameter("action")) : -1;

    switch (action) {
      case CREATE:
        gestionnaireArticles.create((String) request.getParameter("title"), (String) request.
                getParameter("permalink"), (String) request.getParameter("intro"),
                                    (String) request.getParameter("content"));
        List<User> listeUsers = gestionnaireUsers.all();
        request.setAttribute("listeUsers", listeUsers);
        page = "index";
        break;

      case NEW:
        page = "consoleAdmin";
        break;

      case SHOW:
        String perme = request.getPathInfo().substring(request.getPathInfo().
                lastIndexOf("/")+1);
        System.out.println("perme: " + perme);
        Article article = gestionnaireArticles.findByPermalink(perme);
        if (article != null) {
          request.setAttribute("article", article);
          page = "article";
        } else {
          page = "index";
        }
        break;

      default:
        page = "index";
        break;
    }
//    System.out.println(page);
    if (page.equals("index")) {
      List<Article> listeArticles = gestionnaireArticles.all();
      request.setAttribute("listeArticles", listeArticles);
    }
    RequestDispatcher dp = request.getRequestDispatcher("/" + page + ".jsp");
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
