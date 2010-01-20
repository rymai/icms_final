package icms_ejb;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
public class GestionnairePagesBean implements GestionnairePagesLocal {

    @PersistenceContext
    private EntityManager em;

    /**
     *
     * @return all roots, sections and articles pages
     */
    public List<Page> allPages() {
        return em.createNamedQuery("Page.findAll").getResultList();
    }

    /**
     *
     * @return all roots pages
     */
    public List<Page> allRoots() {
        return em.createNamedQuery("Page.findAllRoots").getResultList();
    }

    /**
     *
     * @return all sections pages
     */
    public List<Page> allSections() {
        return em.createNamedQuery("Page.findAllSections").getResultList();
    }

    /**
     *
     * @return all articles pages
     */
    public List<Page> allArticles() {
        return em.createNamedQuery("Page.findAllArticles").getResultList();
    }

    /**
     * Find a page (root, section or article) by its id
     * @param id
     * @return
     */
    public Page find(int id) {
        if (id != 0) {
            return em.find(Page.class, id);
        } else {
            return null;
        }
    }

    /**
     * Find a page (root, section or article) by its permalink
     * @param perme
     * @return Page instance or null
     */
    public Page findByPermalink(String perme) {
        Query queryPagesByPermalink = em.createNamedQuery("Page.findByPermalink");
        queryPagesByPermalink.setParameter("perme", perme);
        List<Page> pages = queryPagesByPermalink.getResultList();
        if (pages.size() == 1) {
            return pages.get(0);
        } else {
            return null;
        }
    }

    /**
     * Find all pages that are children of the page with id parent_id
     * @param parent id of the parent page
     * @return List<Page>
     */
    public List<Page> children(int parent_id) {
        Query queryAllChildren = em.createNamedQuery("Page.findAllChildren");
        queryAllChildren.setParameter("parent_id", find(parent_id));
        List<Page> articles = queryAllChildren.getResultList();
        return articles;
    }

    /**
     * Find the parent of the page with id child_id
     * @param page
     * @return Page instance or null
     */
    public Page parent(int child_id) {
        Query queryFindParent = em.createNamedQuery("Page.findParent");
        queryFindParent.setParameter("id", find(child_id));
        List<Page> pageParente = queryFindParent.getResultList();
        if (pageParente.size() == 1) {
            return pageParente.get(0);
        } else {
            return null;
        }
    }

    public void create(String title, String permalink, String intro, String content,
                       String prefered_sex,
                       int parent_id) {
        Page a = new Page(title, setPermalink(permalink, title, -1), intro, content, prefered_sex,
                          find(parent_id));
        em.persist(a);
        em.flush();
    }

    public boolean update(int id, String title, String permalink, String intro,
                          String content, String prefered_sex, int parent_id) {
        Page a = find(id);

        a.update(title, setPermalink(permalink, title, id), intro, content, prefered_sex, find(
                parent_id));
        try {
            em.merge(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void delete(int id) {
        Page a = find(id);
        em.remove(em.merge(a));
    }

    /**
     * @param perm the text from which we will guess the permalink
     *        permalink is guessed from the title if perm is blank)
     */
    private String setPermalink(String perm, String title, int page_id) {
        return perm.equals("") ? makePermalink(title, page_id) : makePermalink(perm, page_id);
    }

    /**
     * @param text
     * @return generated and safe permalink from text parameter
     */
    private String makePermalink(String text, int page_id) {
        String perme = text.trim().toLowerCase().replaceAll("\\s+", "_").replaceAll("\\W+", "").
                replaceAll("_+", "-");
        //check si le permalink est deja utilise, dans ce cas, on ajoute un int random au permalink tant qu'il existe

        int r = 0;
        Query queryByPermalink = em.createNamedQuery("Page.findByPermalinkAndIdIsNot");
        queryByPermalink.setParameter("perme", perme);
        queryByPermalink.setParameter("id", page_id);
        List<Page> pages;

        pages = queryByPermalink.getResultList();

        while (pages.size() > 0) {
            r = (int) (Math.random() * 1000);
            queryByPermalink.setParameter("perme", perme + r);
            pages = queryByPermalink.getResultList();
        }

        return perme + (r == 0 ? "" : r);
    }
}
