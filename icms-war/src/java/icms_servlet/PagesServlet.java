package icms_servlet;

import icms_ejb.*;
import java.io.IOException;
import java.util.ArrayList;
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
                "action")) : getServletConfig().getInitParameter("action") != null ? Integer.parseInt(getServletConfig().
                getInitParameter("action")) : -1;

        switch (action) {
            case Config.SHOW:
                String perme = request.getPathInfo().substring(request.getPathInfo().
                        lastIndexOf("/") + 1);
                ArticlePage pageLoad = null;
                pageLoad = gestionnairePages.findArticleByPermalink(perme);

                if (pageLoad != null) {
                    List<ArticlePage> myChildren = gestionnairePages.findAllChildren((int) pageLoad.getId());
                    ArticlePage myParent = ((ArticlePage) pageLoad).getMyParent();
                    if (myChildren == null || myChildren.size() == 0) {
                        request.setAttribute("article", pageLoad);
                        page = (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equals("XMLHttpRequest")) ? "partials/_article.jsp" : "article.jsp";
                    } else if (myParent != null) {
                        request.setAttribute("article", pageLoad);
                        List<ArticlePage> sections = new ArrayList<ArticlePage>();
                        List<ArticlePage> articles = new ArrayList<ArticlePage>();
                        for (ArticlePage a : myChildren) {
                            if (gestionnairePages.findAllChildren(a.getId()) != null && gestionnairePages.findAllChildren(a.getId()).size() > 0) {
                                sections.add(a);
                            } else {
                                articles.add(a);
                            }
                        }
                        request.setAttribute("listeSections", sections);
                        request.setAttribute("listeArticles", articles);
                        page = "section.jsp";
                    } else if (myParent == null) {
                        request.setAttribute("article", pageLoad);
                        request.setAttribute("listeSections", gestionnairePages.findAllChildren(pageLoad.getId()));
                        page = "category.jsp";

//                      request.setAttribute("translate_to", request.getParameter("translate_to"));
//                        System.out.println("request.getHeader(\"x-requested-with\") : " + request.getHeader("x-requested-with"));


                    } else {

                        page = "articles"; // redirect
                    }
                }
                break;







            default:
                request.setAttribute("listeArticles", gestionnairePages.allArticles());
                page = "index.jsp"; // render
                break;
        }
        request.setAttribute("listeCategories", gestionnairePages.findRoot());

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
            throws ServletException,
            IOException {
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
            throws ServletException,
            IOException {
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
