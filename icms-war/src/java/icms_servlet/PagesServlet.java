package icms_servlet;

import icms_ejb.*;
import icms_util.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PagesServlet extends BaseServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.processRequest(request, response);

        if (user == null) {
            user = gestionnaireUsers.findAdminByLoginAndPassword("admin", "admin");
            if (user != null) {
                SessionsServlet.setUserToSession(user);
                response.sendRedirect("/icms-war/admin/articles");
                return;
            }
        }

        List<Page> sections = new ArrayList<Page>();
        List<Page> articles = new ArrayList<Page>();

        switch (action) {
            case Config.SHOW:
                String perme = request.getPathInfo().substring(request.getPathInfo().
                        lastIndexOf("/") + 1);
                // Page (root, section ou article)
                Page pageLoad = gestionnairePages.findByPermalink(perme);

                if (pageLoad != null) {
                    int page_id = (int) pageLoad.getId();
                    if (gestionnairePages.isArticle(page_id)) { // ARTICLE
                        // AJAX or not
                        pagePath = RequestUtil.isAjaxRequest(request) ? "partials/_article.jsp" : "article.jsp";

                    } else if (gestionnairePages.isSection(page_id)) { // SECTION
                        for (Page a : gestionnairePages.children(page_id)) {
                            if (gestionnairePages.isSection(a.getId())) {
                                sections.add(a);
                            } else {
                                articles.add(a);
                            }
                        }
                        pagePath = "section.jsp";

                    } else if (gestionnairePages.isCategory(page_id)) { // CATEGORY
                        sections = gestionnairePages.children(pageLoad.getId());
                        pagePath = "category.jsp";
                    }
                    request.setAttribute("article", pageLoad);
                } else {
                    pagePath = "error_404";
                }
                break;

            default:
                articles = gestionnairePages.allArticles();
                pagePath = "index.jsp"; // render
                break;
        }
        request.setAttribute("listCategories", gestionnairePages.allRoots());
        request.setAttribute("listSections", sections);
        request.setAttribute("listArticles", articles);
        request.setAttribute("listAdvertisements", gestionnaireAdvertisements.allAdvertisements());

        RequestDispatcher dp = request.getRequestDispatcher("/" + pagePath);

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
            throws ServletException,
                   IOException {
//        try {
        processRequest(request, response);
//        } catch (XmlRpcException ex) {
//            Logger.getLogger(PagesServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
            throws ServletException,
                   IOException {
//        try {
        processRequest(request, response);
//        } catch (XmlRpcException ex) {
//            Logger.getLogger(PagesServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
