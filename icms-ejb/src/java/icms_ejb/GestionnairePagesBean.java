package icms_ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
public class GestionnairePagesBean implements GestionnairePagesLocal {

    @PersistenceContext
    private EntityManager em;

    public List<ArticlePage> allArticles() {
        return em.createNamedQuery("ArticlePage.findAll").getResultList();
    }

    public ArticlePage findArticle(int id) {
        if (id != 0) {
            return em.find(ArticlePage.class, id);
        } else {
            return null;
        }
    }

    public ArticlePage findArticleByPermalink(String perme) {
        Query queryArticlesByPermalink = em.createNamedQuery("ArticlePage.findByPermalink");
        queryArticlesByPermalink.setParameter("perme", perme);
        List<ArticlePage> articles = queryArticlesByPermalink.getResultList();
        if (articles.size() == 1) {
            return articles.get(0);
        } else {
            return null;
        }
    }

    public List<ArticlePage> findAllChildren(int parent) {
        Query queryAllChildren = em.createNamedQuery("ArticlePage.findAllChildren");
        ArticlePage parentPage = findArticle(parent);
        queryAllChildren.setParameter("parent", parentPage);
        List<ArticlePage> articles = queryAllChildren.getResultList();
        if (articles != null) {
            return articles;
        } else {
            return null;
        }
    }

    public ArticlePage findParent(int son) {
        Query queryFindParent = em.createNamedQuery("ArticlePage.findParent");
        ArticlePage sonPage = findArticle(son);
        queryFindParent.setParameter("son", sonPage);
        List<ArticlePage> articleParent = queryFindParent.getResultList();
        if (articleParent.size() == 1) {
            return articleParent.get(0);
        } else {
            return null;
        }
    }

    public List<ArticlePage> findRoot() {
        List<ArticlePage> articlesPage = allArticles();
        List<ArticlePage> articleRoot = new ArrayList<ArticlePage>();
        for (ArticlePage a : articlesPage) {
            if (a.getMyParent() == null) {
                articleRoot.add(a);
            }
        }
        if (articleRoot != null) {
            return articleRoot;
        } else {
            return null;
        }
    }

    public void deleteArticle(int id) {
        ArticlePage a = findArticle(id);
        em.remove(em.merge(a));
    }

    public void createArticle(String title, String permalink, String intro, String content, int parent_id) {
        String perm = setPermalink(permalink, title);
        ArticlePage parent = findArticle(parent_id);
        ArticlePage a = new ArticlePage(title, perm, intro, content, parent);
        em.persist(a);
        em.flush();
    }

    /**
     * @param perm the text from which we will guess the permalink
     *        permalink is guessed from the title if perm is blank)
     */
    private String setPermalink(String perm, String title) {
        return perm.equals("") ? makePermalink(title) : makePermalink(perm);
    }

    /**
     * @param text
     * @return generated and safe permalink from text parameter
     */
    private String makePermalink(String text) {
        String perme = text.trim().toLowerCase().replaceAll("\\s+", "_").replaceAll("\\W+", "").
                replaceAll("_+", "-");
        //check si le permalink est deja utilise, dans ce cas, on ajoute un int random au permalink tant qu'il existe

        int r = 0;
        Query queryByPermalink = em.createNamedQuery("ArticlePage.findByPermalink");

        List<ArticlePage> pages;

        queryByPermalink.setParameter("perme", perme);
        pages = queryByPermalink.getResultList();

        while (pages.size() > 0) {
            r = (int) (Math.random() * 1000);
            queryByPermalink.setParameter("perme", perme + r);
            pages = queryByPermalink.getResultList();
        }

        return perme + (r == 0 ? "" : r);
    }

    public boolean updateArticle(int id, String title, String permalink, String intro, String content, int parent_id) {
        ArticlePage a = findArticle(id);
        String perm = setPermalink(permalink, title);
        ArticlePage parent = findArticle(parent_id);

        a.update(title, perm, intro, content, parent);
        try {
            em.merge(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
