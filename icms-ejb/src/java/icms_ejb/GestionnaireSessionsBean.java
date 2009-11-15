package icms_ejb;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.*;

@Stateful
public class GestionnaireSessionsBean implements GestionnaireSessionsLocal {

    @PersistenceContext
    private EntityManager em;
    private static User current_user = null;

    public static User getCurrentUser() {
        return current_user;
    }

    public boolean create(String login, String password) {
        Query queryUserByLoginAndPassword = em.createNamedQuery("Users.findByLoginAndPassword");
        queryUserByLoginAndPassword.setParameter("login", login);
        queryUserByLoginAndPassword.setParameter("password", password);
        List<User> users = queryUserByLoginAndPassword.getResultList();
        if (users.size() == 1) {
            GestionnaireSessionsBean.current_user = users.get(0);
            return true;
        }
        return false;
    }

    public boolean destroy() {
        GestionnaireSessionsBean.current_user = null;
        return true;
    }
}
