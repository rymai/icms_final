package ICMSejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@NamedQueries({
  @NamedQuery(name = "Users.findAll",
              query = "SELECT u FROM User u"),
  @NamedQuery(name = "Users.findAdmins",
              query = "SELECT u FROM User u WHERE u.lvl = 'admin'"),
  @NamedQuery(name = "Users.findByLoginAndPassword",
              query = "SELECT u FROM User u WHERE u.login = :login AND u.password = :password")
})
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
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
