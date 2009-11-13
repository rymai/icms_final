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

    public void createArticle(String title, String permalink, String intro, String content, SectionPage mySection) {
        ArticlePage a = new ArticlePage(title, permalink, intro, content, mySection);
        em.persist(a);
        mySection.getMyArticles().add(a);
    }

    public void createSection(String title, String permalink, String intro, String content, CategoryPage myCategory) {
        SectionPage s = new SectionPage(title, permalink, intro, content, myCategory);
        em.persist(s);
        myCategory.getMySections().add(s);
    }

    public void createCategory(String title, String permalink, String intro, String content) {
        CategoryPage c = new CategoryPage(title, permalink, intro, content);
        em.persist(c);
    }

    public void update(int id, String title, String permalink, String intro, String content) {
        Page p = find(id);
        p.update(title, permalink, intro, content);
        em.merge(p);
    }

    public void destroy(int id) {
        Page p = find(id);
        em.remove(em.merge(p));
    }

    public Page find(int id) {
        return em.find(Page.class, id);
    }

    public List<ArticlePage> all() {
        return em.createNamedQuery("ArticlePage.findAll").getResultList();
    }

    public ArticlePage findByPermalink(String perme) {
        Query queryArticlesByPermalink = em.createNamedQuery("Articles.findByPermalink");
        queryArticlesByPermalink.setParameter("perme", perme);
        List<ArticlePage> articles = queryArticlesByPermalink.getResultList();
        if (articles.size() == 1) {
            return articles.get(0);
        } else {
            return null;
        }
    }

    public List<SectionPage> allSections() {
        Query queryAllSections = em.createNamedQuery("Section.findAll");
        List<SectionPage> sections = queryAllSections.getResultList();
        return sections;
    }

    public SectionPage findByTitle(String title) {
        Query querySectionByTitle = em.createNamedQuery("Section.findByTitle");
        querySectionByTitle.setParameter("title", title);
        List<SectionPage> sections = querySectionByTitle.getResultList();
        if (sections.size() == 1) {
            return sections.get(0);
        } else {
            return null;
        }
    }
}
