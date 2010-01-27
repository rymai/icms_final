package icms_servlet.admin;

import icms_util.SecurityUtil;
import icms_plugin.advertisement.GestionnaireAdvertisementsLocal;
import icms_controller.GestionnaireUsersLocal;
import icms_ejb.*;
import icms_servlet.*;
import java.io.*;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AdvertisementServlet extends HttpServlet {
   
    @EJB
    private GestionnaireAdvertisementsLocal gestionnaireAdvertisements;
    @EJB
    private GestionnaireUsersLocal gestionnaireUsers;
    // Not EJB
    private String page;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (!SecurityUtil.checkUserIsAuthenticated(request, response, gestionnaireUsers)) {
            return;
        }

        // Priority for the action parameter passed by the page, not by the servlet config
        int action = request.getParameter("action") != null ? Integer.parseInt(request.getParameter(
                "action")) : getServletConfig().getInitParameter("action") != null ? Integer.
                parseInt(getServletConfig().
                getInitParameter("action")) : -1;

        switch (action) {
            case Config.CREATE:
                gestionnaireAdvertisements.create(request.getParameter("title"),
                                         request.getParameter("link"),
                                         request.getParameter("content"),
                                         request.getParameter("service"),
                                         request.getParameter("criteria"),
                                         request.getParameter("criteria_value"));
                response.sendRedirect("/icms-war/admin/advertisements");
                return;


            case Config.EDIT:
                request.setAttribute("advertisement", gestionnaireAdvertisements.find(Integer.parseInt(
                        request.getParameter("id"))));
                page = "admin/advertisement_edit.jsp";
                break;

            case Config.UPDATE:
                gestionnaireAdvertisements.update(Integer.parseInt(request.getParameter("id")),
                                         request.getParameter("title"),
                                         request.getParameter("link"),
                                         request.getParameter("content"),
                                         request.getParameter("service"),
                                         request.getParameter("criteria"),
                                         request.getParameter("criteria_value"));
                page = "admin/advertisements.jsp";
                break;

            case Config.DESTROY:
                gestionnaireAdvertisements.destroy(Integer.parseInt(request.getParameter("id")));
                break;

            default:
                page = "admin/advertisements.jsp"; // render
                break;
        }
        
        request.setAttribute("listeAdvertisements", gestionnaireAdvertisements.allAdvertisements());

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
