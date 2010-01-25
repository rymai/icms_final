package icms_servlet;

import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookWebappHelper;
import com.google.code.facebookapi.FacebookXmlRestClient;
import com.google.code.facebookapi.IFacebookRestClient;
import com.google.code.facebookapi.ProfileField;
import icms_ejb.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Security {

    private static String api_key = "40a01944f542b07841734091b413f956";
    private static String secret = "a28ecb65b7306d42c173a9bd14fe17fe";
    public static final String FACEBOOK_USER_CLIENT = "facebook.user.client";

    public static boolean checkUserIsAuthenticated(HttpServletRequest request,
                                                   HttpServletResponse response,
                                                   GestionnaireUsersLocal gestionnaireUsers) throws
            ServletException,
            IOException {

        IFacebookRestClient<Document> userClient = (IFacebookRestClient<Document>) SessionsServlet.
                getSession(request).getAttribute(FACEBOOK_USER_CLIENT);

        if (userClient == null) {
            System.out.println(
                    "User session doesn't have a Facebook API client setup yet. Creating one and storing it in the user's session.");
            userClient = new FacebookXmlRestClient(api_key, secret);
            SessionsServlet.setToSession(FACEBOOK_USER_CLIENT, userClient);
        }

        System.out.println(
                "Creating a FacebookWebappHelper, which copies fb_ request param data into the userClient");
        FacebookWebappHelper<Document> facebook = new FacebookWebappHelper<Document>(request,
                                                                                     response,
                                                                                     api_key, secret,
                                                                                     userClient);

//        String nextPage = request.getRequestURI();
//        nextPage = nextPage.substring(nextPage.indexOf("/", 1) + 1); //cut out the first /, the context path and the 2nd /
        String nextPage = "http://localhost:8080/icms-war/";
        boolean redirectOccurred = facebook.requireLogin("");
        if (!facebook.isLogin()) {
            return false;
        }
//        redirectOccurred = facebook.requireFrame(nextPage);
//        if (redirectOccurred) {
//            return false;
//        }

        long facebookUserID;
        try {
            facebookUserID = userClient.users_getLoggedInUser();
        } catch (FacebookException ex) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                               "Error while fetching user's facebook ID");
            System.out.println(
                    "Error while getting cached (supplied by request params) value " +
                    "of the user's facebook ID or while fetching it from the Facebook service " +
                    "if the cached value was not present for some reason. Cached value = {}" +
                    userClient.getCacheUserId());
            return false;
        }

        ArrayList<Long> a = new ArrayList<Long>();
        a.add(facebookUserID);
        ArrayList<ProfileField> b = new ArrayList<ProfileField>();
        b.add(ProfileField.SEX);

        Document infos = null;
        try {
            infos = userClient.users_getInfo(a, b);
        } catch (FacebookException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
//        NodeList nodes = infos.getElementsByTagName("sex");
        System.out.println(infos.getChildNodes().getLength());
        System.out.println(infos.getLastChild().getNodeValue());
        System.out.println(infos.getElementsByTagName("sex").item(0).getNodeValue());


        Document prefs = null;
        try {
            prefs = userClient.users_getInfo(a, b);
        } catch (FacebookException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < prefs.getChildNodes().getLength(); i++) {
            System.out.println("\tkey " + prefs.getChildNodes().item(i).getNodeName() + " = " + prefs.
                    getChildNodes().item(i).getNodeValue());
        }

        System.out.println(facebookUserID);

        User u = SessionsServlet.getUserFromSession(gestionnaireUsers);
        if (u == null) {
            RequestDispatcher dp = request.getRequestDispatcher("/");
            request.setAttribute("flash", "Vous devez être logué pour accéder à l'admin!");
            dp.forward(request, response);
            return false;
        } else {
            request.setAttribute("current_user", u);
//            if (u.getFacebookId() != null && u.getFacebookId() != facebookUserID && facebookUserID > 0) {
//                u.setFacebookId(facebookUserID);
//                new GestionnaireUsersBean().save(u.getId());
//            }
            return true;
        }
    }
}
