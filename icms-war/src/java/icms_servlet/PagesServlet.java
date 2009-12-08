package icms_servlet;

import icms_ejb.*;
import icms_ejb.SectionPage;
import java.io.IOException;
import java.util.Enumeration;
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

        SessionsServlet.getSession(request);
        User u = SessionsServlet.getUserFromSession(gestionnaireUsers);
        request.setAttribute("current_user", u);

        if (gestionnaireUsers.findAdmins().size() == 0) {
            gestionnaireUsers.creerAdmin();
        }

        // Priority for the action parameter passed by the page, not by the servlet config
        int action = request.getParameter("action") != null ? Integer.parseInt(request.getParameter(
                "action")) : getServletConfig().getInitParameter("action") != null ? Integer.
                parseInt(getServletConfig().
                getInitParameter("action")) : -1;

        switch (action) {
            case Config.SHOW:
                String perme = request.getPathInfo().substring(request.getPathInfo().
                        lastIndexOf("/") + 1);
                Page pageLoad = null;
                if (perme.substring(0, 4).equals("cat:")) {
                    pageLoad = gestionnairePages.findCategoryByPermalink(perme.substring(4));
                } else if (perme.substring(0, 4).equals("sec:")) {
                    pageLoad = gestionnairePages.findSectionByPermalink(perme.substring(4));
                } else if (perme.substring(0, 4).equals("art:")) {
                    pageLoad = gestionnairePages.findArticleByPermalink(perme.substring(4));
                }

                if (pageLoad != null) {
                    if (pageLoad instanceof ArticlePage) {
                        request.setAttribute("article", pageLoad);
//                      request.setAttribute("translate_to", request.getParameter("translate_to"));
//                        System.out.println("request.getHeader(\"x-requested-with\") : " + request.getHeader("x-requested-with"));
                        
                        page = (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equals("XMLHttpRequest")) ? "partials/_article.jsp" : "article.jsp";
                    } else if (pageLoad instanceof SectionPage) {
                        request.setAttribute("section", pageLoad);
                        List<ArticlePage> listeArticles = (List) ((SectionPage) pageLoad).
                                getMyArticles();
                        request.setAttribute("listeArticles", listeArticles);
                        page = "section.jsp";
                    } else if (pageLoad instanceof CategoryPage) {
                        request.setAttribute("category", pageLoad);
                        List<SectionPage> listeSections = (List) ((CategoryPage) pageLoad).
                                getMySections();
                        request.setAttribute("listeSections", listeSections);
                        page = "category.jsp";
                    }

                } else {

                    page = "articles"; // redirect
                }
                break;

            default:
                List<ArticlePage> listeArticles = gestionnairePages.allArticles();
                request.setAttribute("listeArticles", listeArticles);
                page = "index.jsp"; // render
                break;
        }
        List<CategoryPage> listeCategories = gestionnairePages.allCategories();
        request.setAttribute("listeCategories", listeCategories);

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
