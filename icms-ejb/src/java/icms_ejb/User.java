package icms_ejb;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
@NamedQueries({
    @NamedQuery(name = "Users.findAll",
                query = "SELECT u FROM User u"),
    @NamedQuery(name = "Users.findByLoginAndPassword",
                query = "SELECT u FROM User u WHERE u.login = :login AND u.password = :password"),
    @NamedQuery(name = "Users.findByLoginAndPasswordAndLvl",
                query = "SELECT u FROM User u WHERE u.login = :login AND u.password = :password AND u.lvl = :lvl"),
    @NamedQuery(name = "Users.findById",
                query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findAdmins",
                query = "SELECT u FROM User u WHERE u.lvl = 99")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String password;
    private String lvl;
    @Column(name = "FACEBOOK_ID", unique = true)
    private String facebookId;

    // Ne pas supprimer, sinon erreur Toplink
    public User() {
    }

    public User(String login, String password, String lvl) {
        this.login = login;
        setPassword(password);
        this.lvl = lvl;
    }

    public void update(String login, String password, String lvl) {
        this.login = login;
        if(!password.equals("")) setPassword(password);
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
        this.password = encryptPassword(password);
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

    /**
     * Encrypt the password with SHA1 algorithm
     * @param password
     * @return encrypted (with sha1) password
     */
    public static String encryptPassword(String password) {
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            byte[] passwordByte = password.getBytes();
            sha1.update(passwordByte, 0, passwordByte.length);
            byte[] encodedPassword = sha1.digest();
            String encodedPasswordInString = toHexString(encodedPassword);
            return encodedPasswordInString;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public static String toHexString(byte[] buf) {
        char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
                          'F'};
        StringBuffer strBuf = new StringBuffer(buf.length * 2);
        for (int i = 0;
             i < buf.length;
             i++) {
            strBuf.append(hexChar[(buf[i] & 0xf0) >>> 4]); // fill left with zero bits
            strBuf.append(':');
            strBuf.append(hexChar[buf[i] & 0x0f]);
        }
        return strBuf.toString();
    }
}
