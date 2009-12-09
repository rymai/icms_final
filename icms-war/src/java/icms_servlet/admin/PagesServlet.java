package icms_servlet.admin;

import icms_ejb.*;
import icms_servlet.*;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

public class PagesServlet extends HttpServlet {

    @EJB
    private GestionnairePagesLocal gestionnairePages;
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
                "action")) : getServletConfig().getInitParameter("action") != null ? Integer.
                parseInt(getServletConfig().
                getInitParameter("action")) : -1;

        List<Page> listePages = gestionnairePages.allPages();

        switch (action) {
            case Config.CREATE:
                int sec = 0;
                if (Integer.parseInt(request.getParameter("section_id")) != 0) {
                    sec = gestionnairePages.find(
                            Integer.parseInt(request.getParameter("section_id"))).getId();
                }

                gestionnairePages.create(request.getParameter("title"),
                                         request.getParameter("permalink"),
                                         request.getParameter("intro"),
                                         request.getParameter("content"),
                                         sec);
                response.sendRedirect("/icms-war/articles");
                return;


            case Config.EDIT:
                Page articleEdit = gestionnairePages.find(Integer.parseInt(
                        request.getParameter("id")));
                request.setAttribute("article", articleEdit);

                listePages.remove(articleEdit);

                request.setAttribute("listePages", listePages);
                page = "admin/article_edit.jsp";
                break;

            case Config.UPDATE:
                int secUp = 0;
                if (Integer.parseInt(request.getParameter("section_id")) != 0) {
                    secUp = gestionnairePages.find(Integer.parseInt(request.getParameter(
                            "section_id"))).getId();
                }

                gestionnairePages.update(Integer.parseInt(request.getParameter("id")),
                                         request.getParameter("title"), request.getParameter(
                        "permalink"), request.getParameter("intro"), request.getParameter("content"),
                                         secUp);
                page = "admin/articles.jsp";
                break;

            case Config.DESTROY:
                gestionnairePages.delete(Integer.parseInt(request.getParameter("id")));
                break;

            default:
                page = "admin/articles.jsp"; // render
                break;
        }

        request.setAttribute("listeCategories", gestionnairePages.allRoots());
        request.setAttribute("listePages", listePages);

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
