package icms_servlet;

import icms_ejb.*;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionsServlet extends HttpServlet {

    @EJB
    private GestionnaireUsersLocal gestionnaireUsers;
    @EJB
    private GestionnaireSessionsLocal gestionnaireSessions;
    // Not EJB
    private static HttpSession session;
    private String page;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Priority for the action parameter given by the page, not by the servlet config
        int action = request.getParameter("action") != null ? Integer.parseInt(request.getParameter(
                "action")) : getServletConfig().getInitParameter("action") != null ? Integer.
                parseInt(getServletConfig().
                getInitParameter("action")) : -1;

        switch (action) {
            case Config.CREATE:
                User user = gestionnaireUsers.findAdminByLoginAndPassword(request.getParameter(
                        "login"),
                                                                          request.getParameter(
                        "password"));
                if (user != null) {
                    setUserToSession(user);
                    response.sendRedirect("/icms-war/admin/articles");
                    return;
                } else {
                    page = "";
                }
                break;

            case Config.DESTROY:
                session.removeAttribute("user_id");
                if (gestionnaireSessions.destroy()) {
                    response.sendRedirect("/icms-war/articles");
                    request.setAttribute("flash", "Vous êtes maintenant délogué!");
                    return;
                }
                break;

            default:
                page = getUserFromSession(gestionnaireUsers) != null ? "admin" : "";
                break;
        }

        RequestDispatcher dp = request.getRequestDispatcher("/" + page);
        dp.forward(request, response);
    }

    public static HttpSession getSession(HttpServletRequest request) {
        if(session == null) session = request.getSession(true);
        return session;
    }

    public static Object getFromSession(String attr) {
        return getSession(null).getAttribute(attr);
    }

    public static void setUserToSession(User user) {
        session.setAttribute("user_id", user.getId());
    }

    public static void setToSession(String var, Object o) {
        session.setAttribute(var, o);
    }

    public static User getUserFromSession(GestionnaireUsersLocal gestionnaire) {
        Integer id = null;
        id = (Integer) session.getAttribute("user_id");
        if (id != null) {
            return gestionnaire.find(id);
        }
        return null;
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
