package ICMSejb;

import java.util.List;
import javax.ejb.Local;

@Local
public interface GestionnaireArticlesLocal {

    public void create(String title, String permalink, String intro, String content);

    public void update(int id, String title, String permalink, String intro, String content);

    public void remove(int id);

    public Article find(int id);

    public List<Article> all();

    public Article findByPermalink(String perme);
}
