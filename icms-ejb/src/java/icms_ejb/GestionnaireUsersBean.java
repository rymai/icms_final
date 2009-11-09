package icms_ejb;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
public class GestionnaireUsersBean implements GestionnaireUsersLocal {

    @PersistenceContext
    private EntityManager em;

    public void creerAdmin() {
        em.persist(new User("admin", "admin", "admin"));
    }

    public List<User> all() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }

    public List<User> findAdmins() {
        return em.createNamedQuery("Users.findAdmins").getResultList();
    }

    public User findUserByLoginAndPassword(String login, String password) {
        Query queryUserByLoginAndPassword = em.createNamedQuery("Users.findByLoginAndPassword");
        queryUserByLoginAndPassword.setParameter("login", login);
        queryUserByLoginAndPassword.setParameter("password", password);
        List<User> users = queryUserByLoginAndPassword.getResultList();
        if (users.size() == 1) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
