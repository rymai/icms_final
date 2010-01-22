package icms_ejb;

import java.util.List;
import javax.ejb.Local;

@Local
public interface GestionnairePagesLocal {

    // CRUD
    public void create(String title, String permalink, String intro, String content, String prefered_sex,
                              int parent_id);

    public boolean update(int id, String title, String permalink, String intro,
                                 String content, String prefered_sex, int parent_id);

    public void destroy(int id);

    // Find one
    public Page find(int id);

    public Page findByPermalink(String perme);

    public Page parent(int son);

    // Find many
    public List<Page> children(int parent);

    public List<Page> allPages();

    public List<Page> allRoots();

    public List<Page> allSections();

    public List<Page> allArticles();
}
