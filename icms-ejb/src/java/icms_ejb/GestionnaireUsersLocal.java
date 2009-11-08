package ICMSejb;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GestionnaireUsersLocal {
    public void creerAdmin();
    public List<User> all();
    public List<User> findAdmins();
    public User findUserByLoginAndPassword(String login, String password);
}
