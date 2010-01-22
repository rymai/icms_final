package icms_servlet.admin;

import icms_servlet.*;
import icms_ejb.*;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

public class UsersServlet extends HttpServlet {

    @EJB
    private GestionnaireUsersLocal gestionnaireUsers;
    @EJB
    private GestionnairePagesLocal gestionnairePages;
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
            case Config.INDEX:
                page = "admin/users.jsp"; // render
                break;

            case Config.CREATE:
                gestionnaireUsers.create((String) request.getParameter("login"), (String) request.
                        getParameter("password"), (String) request.getParameter("level"));
                response.sendRedirect("/icms-war/admin/users");
                return;

                case Config.EDIT:
                request.setAttribute("user", gestionnaireUsers.find(Integer.parseInt(
                        request.getParameter("id"))));
                page = "admin/user_edit.jsp";
                break;

            case Config.UPDATE:
                gestionnaireUsers.update(Integer.parseInt(request.getParameter("id")),
                                         request.getParameter("login"),
                                         request.getParameter("password"),
                                         request.getParameter("level"));
                page = "admin/advertisements.jsp";
                break;

            case Config.DESTROY:
                gestionnaireUsers.destroy(Integer.parseInt(request.getParameter("id")));
                break;

            default:
                page = "admin/users.jsp"; // redirect
                break;
        }

        request.setAttribute("listUsers", gestionnaireUsers.all());
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
