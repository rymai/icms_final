package icms_servlet.admin;

import icms_ejb.*;
import icms_servlet.*;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

public class SectionsServlet extends HttpServlet {

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

        switch (action) {
            case Config.CREATE:
                gestionnairePages.createSection(request.getParameter("title"),
                                                request.getParameter("permalink"),
                                                request.getParameter("intro"),
                                                request.getParameter("content"),
                                                Integer.parseInt(request.getParameter("category_id")));

                response.sendRedirect("/icms-war/articles");
                return;

            case Config.EDIT:
                SectionPage sectionEdit = gestionnairePages.findSection(Integer.parseInt(request.
                        getParameter("id")));
                request.setAttribute("section", sectionEdit);
                request.setAttribute("listeCategories", gestionnairePages.allCategories());
                page = "admin/section_edit.jsp";
                break;

            case Config.UPDATE:
                gestionnairePages.updateSection(Integer.parseInt(request.getParameter("id")),
                                                request.getParameter("title"), request.getParameter(
                        "permalink"), request.getParameter(
                        "intro"), request.getParameter("content"), Integer.parseInt(
                        request.getParameter("category_id")));
                page = "admin/sections.jsp";
                break;

            case Config.DESTROY:
                gestionnairePages.deleteSection(Integer.parseInt(request.getParameter("id")));
                break;

            default:
                request.setAttribute("listeCategories", gestionnairePages.allCategories());
                page = "admin/sections.jsp"; // render
                break;
        }
        request.setAttribute("listeSections", gestionnairePages.allSections());
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
