package icms_ejb;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.*;

@Stateful
public class GestionnaireUsersBean implements GestionnaireUsersLocal {

    @PersistenceContext
    private EntityManager em;

    public void creerAdmin() {
        em.persist(new User("admin", "admin", "99"));
    }

    public void create(String login, String password, String level) {
        User u = new User(login, password, level);
        em.persist(u);
    }

    public void update(int id, String login, String password, String level) {
        User u = find(id);
        u.update(login, password, level);
        em.merge(u);
    }

    public void destroy(int id) {
        User u = find(id);
        em.remove(em.merge(u));
    }

        /**
     * Find all users
     * @return
     */
    public List<User> all() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }

    /**
     * Find all users with admin level (99)
     * @return
     */
    public List<User> findAdmins() {
        return em.createNamedQuery("Users.findAdmins").getResultList();
    }

    /**
     * Find a user by his id
     * @param id
     * @return
     */
    public User find(int id) {
        Query queryUserById = em.createNamedQuery("Users.findById");
        queryUserById.setParameter("id", id);
        List<User> users = queryUserById.getResultList();
        if (users.size() == 1) {
            return users.get(0);
        } else {
            return null;
        }
    }

    /**
     * Find user by his login and password
     * @param login
     * @param password
     * @return User instance or null if not found
     */
    public User findUserByLoginAndPassword(String login, String password) {
        Query queryUserByLoginAndPassword = em.createNamedQuery("Users.findByLoginAndPassword");
        queryUserByLoginAndPassword.setParameter("login", login);
        queryUserByLoginAndPassword.setParameter("password", password);

        try {
            return (User) queryUserByLoginAndPassword.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Find admin user by his login and password
     * @param login
     * @param password
     * @return User instance or null if not found
     */
    public User findAdminByLoginAndPassword(String login, String password) {
        Query queryUserByLoginAndPassword = em.createNamedQuery("Users.findByLoginAndPasswordAndLvl");
        queryUserByLoginAndPassword.setParameter("login", login);
        queryUserByLoginAndPassword.setParameter("password", password);
        queryUserByLoginAndPassword.setParameter("lvl", "99");

        try {
            return (User) queryUserByLoginAndPassword.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
