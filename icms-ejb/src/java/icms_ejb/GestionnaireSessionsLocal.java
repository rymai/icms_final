package icms_ejb;

import javax.ejb.Local;

@Local
public interface GestionnaireSessionsLocal {

  public boolean create(String login, String password);

  public boolean destroy();
}
