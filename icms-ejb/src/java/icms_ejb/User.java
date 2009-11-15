package icms_ejb;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
@NamedQueries({
    @NamedQuery(name = "Users.findAll",
                query = "SELECT u FROM User u"),
    @NamedQuery(name = "Users.findByLoginAndPassword",
                query = "SELECT u FROM User u WHERE u.login = :login AND u.password = :password"),
    @NamedQuery(name = "Users.findById",
                query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findAdmins",
                query = "SELECT u FROM User u WHERE u.lvl = 'admin'")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String password;
    private String lvl;

    public User() {
    }

    public User(String login, String password, String lvl) {
        this.login = login;
        this.password = password;
        this.lvl = lvl;
    }

    public void update(String login, String password, String lvl) {
        this.login = login;
        this.password = password;
        this.lvl = lvl;
    }

    public Integer getId() {
        return id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the lvl
     */
    public String getLvl() {
        return lvl;
    }

    /**
     * @param lvl the lvl to set
     */
    public void setLvl(String lvl) {
        this.lvl = lvl;
    }
}
