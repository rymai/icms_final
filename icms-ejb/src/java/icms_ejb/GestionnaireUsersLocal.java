package icms_ejb;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GestionnaireUsersLocal {

    public void creerAdmin();

    // CRUD
    public void create(String login, String password, int level);

    public void update(int id, String login, String password, int level);

    public void destroy(int id);

    // Find one
    public User find(int id);

    public User findUserByLoginAndPassword(String login, String password);

    public User findAdminByLoginAndPassword(String login, String password);

    // Find many
    public List<User> all();

    public List<User> findAdmins();
}
