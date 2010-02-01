package icms_servlet;

import icms_controller.*;
import java.io.IOException;
import icms_ejb.*;
import icms_helper.IPHelper;
import icms_plugin.advertisement.GestionnaireAdvertisementsLocal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class BaseServlet extends HttpServlet {

    @EJB
    protected GestionnairePagesLocal gestionnairePages;
    @EJB
    protected GestionnaireUsersLocal gestionnaireUsers;
    @EJB
    protected GestionnaireAdvertisementsLocal gestionnaireAdvertisements;
    // Not EJB
    protected String pagePath;
    // Priority for the action parameter passed by the page, not by the servlet config
    protected int action;
    protected User user;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        SessionsServlet.getSession(request);
        user = SessionsServlet.getUserFromSession(gestionnaireUsers);
        request.setAttribute("current_user", user);

        action = request.getParameter("action") != null ? Integer.parseInt(request.getParameter(
                "action")) : getServletConfig().getInitParameter("action") != null ? Integer.
                parseInt(getServletConfig().
                getInitParameter("action")) : -1;

        if (gestionnaireUsers.findAdmins().size() == 0) {
            gestionnaireUsers.creerAdmin();
        }

        request.setAttribute("url", request.getRequestURL().toString());

        new IPHelper();
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
