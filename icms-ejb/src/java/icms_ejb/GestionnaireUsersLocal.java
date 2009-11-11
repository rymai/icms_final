package icms_ejb;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GestionnaireUsersLocal {
    public void creerAdmin();
    public List<User> all();
    public User find(int id);
    public List<User> findAdmins();
    public User findUserByLoginAndPassword(String login, String password);
}
