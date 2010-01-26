package icms_servlet;

import icms_ejb.*;
import icms_helper.UtilHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import com.maxmind.geoip.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
//import org.apache.xmlrpc.XmlRpcException;

public class PagesServlet extends HttpServlet {

    @EJB
    private GestionnairePagesLocal gestionnairePages;
    @EJB
    private GestionnaireUsersLocal gestionnaireUsers;
    @EJB
    private GestionnaireAdvertisementsLocal gestionnaireAdvertisements;
    // Not EJB
    private String pagePath;
//    private String data = "C:/Users/Chouchou/icms_final/GeoLiteCity.dat";
    private String data = "/Users/remy/Documents/Development/Java/M2 Miage/icms/GeoLiteCity.dat";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        SessionsServlet.getSession(request);
        User u = SessionsServlet.getUserFromSession(gestionnaireUsers);
        request.setAttribute("current_user", u);

        if (u == null) {
            User user = gestionnaireUsers.findAdminByLoginAndPassword("admin", "admin");
            if (user != null) {
                SessionsServlet.setUserToSession(user);
                response.sendRedirect("/icms-war/admin/articles");
                return;
            }
        }

        if (gestionnaireUsers.findAdmins().size() == 0) {
            gestionnaireUsers.creerAdmin();
        }

        // Priority for the action parameter passed by the page, not by the servlet config
        int action = request.getParameter("action") != null ? Integer.parseInt(request.getParameter(
                "action")) : getServletConfig().getInitParameter("action") != null ? Integer.
                parseInt(getServletConfig().
                getInitParameter("action")) : -1;
        List<Page> sections = new ArrayList<Page>();
        List<Page> articles = new ArrayList<Page>();

        switch (action) {
            case Config.SHOW:
                String perme = request.getPathInfo().substring(request.getPathInfo().
                        lastIndexOf("/") + 1);
                // Page (root, section ou article)
                Page pageLoad = gestionnairePages.findByPermalink(perme);

                if (pageLoad != null) {
                    List<Page> myChildren = gestionnairePages.children((int) pageLoad.getId());
                    Page myParent = ((Page) pageLoad).getMyParent();

                    if (myChildren == null || myChildren.size() == 0) { // ARTICLE
                        // AJAX or not
                        pagePath = UtilHelper.isAjaxRequest(request) ? "partials/_article.jsp" : "article.jsp";

                    } else if (myParent != null) { // SECTION
                        for (Page a : myChildren) {
                            if (gestionnairePages.children(a.getId()) != null && gestionnairePages.
                                    children(a.getId()).size() > 0) {
                                sections.add(a);
                            } else {
                                articles.add(a);
                            }
                        }
                        pagePath = "section.jsp";

                    } else if (myParent == null) { // CATEGORY
                        sections = gestionnairePages.children(pageLoad.getId());
                        pagePath = "category.jsp";
//=======
//                        request.setAttribute("listeSections", sections);
//                        request.setAttribute("listePages", articles);
//                        page = "section.jsp";
//                    } else if (myParent == null) {
//                        request.setAttribute("article", pageLoad);
//                        request.setAttribute("listeSections", gestionnairePages.children(pageLoad.getId()));
//                        page = "category.jsp";
//
////                      request.setAttribute("translate_to", request.getParameter("translate_to"));
////                        System.out.println("request.getHeader(\"x-requested-with\") : " + request.getHeader("x-requested-with"));
//
//                    } else {
//                        page = "articles"; // redirect
//>>>>>>> d07f95a8c7a880dca5dc537faebd9cf814d2032b
                    }
                    request.setAttribute("article", pageLoad);
//                    else { // PAGE NOT FOUND => REDIRECT TO INDEX
//                        pagePath = "articles";
//                    }
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
        request.setAttribute("listPages", articles);
        request.setAttribute("listAdvertisements", gestionnaireAdvertisements.allAdvertisements());

        URL url = new URL(
                "http://www.afficheip.net/scripts/AfficheIP.php?taille=30&police=Times&color=000000&bg=FFFFFF");
        InputStream con = url.openStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(con));

        String ip = in.readLine().trim();
//        line = line.trim();
        if (ip.length() >= 27) {
            ip = ip.substring(ip.length() - 27, ip.length() - 12);
            ip = ip.substring(ip.indexOf(">"));
            ip = ip.substring(2);
        } else {
            ip = "no ip";
        }
        request.setAttribute("ip", ip);
        LookupService cl = new LookupService(data, LookupService.GEOIP_MEMORY_CACHE);

        request.setAttribute("ipCity", cl.getLocation(ip).city);

        request.setAttribute("ipCountry", cl.getLocation(ip).countryName);
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
