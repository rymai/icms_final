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

    public void createCategory(String title, String permalink, String intro, String content) {
        CategoryPage c = new CategoryPage(title, permalink, intro, content);
        em.persist(c);
        em.flush();
    }

    public void createSection(String title, String permalink, String intro, String content,
                              int myCategory_id) {
        CategoryPage myCategory = findCategory(myCategory_id);
        SectionPage s = new SectionPage(title, permalink, intro, content, myCategory);
        em.persist(s);
        myCategory.getMySections().add(s);
        em.flush();
    }

    public void createArticle(String title, String permalink, String intro, String content,
                              int mySection_id) {
        SectionPage mySection = findSection(mySection_id);
        ArticlePage a = new ArticlePage(title, permalink, intro, content, mySection);
        em.persist(a);
        mySection.getMyArticles().add(a);
        em.flush();
    }

    public List<CategoryPage> allCategories() {
        return em.createNamedQuery("CategoryPage.findAll").getResultList();
    }

    public List<SectionPage> allSections() {
        return em.createNamedQuery("SectionPage.findAll").getResultList();
    }

    public List<ArticlePage> allArticles() {
        return em.createNamedQuery("ArticlePage.findAll").getResultList();
    }

    public CategoryPage findCategory(int id) {
        return em.find(CategoryPage.class, id);
    }

    public SectionPage findSection(int id) {
        return em.find(SectionPage.class, id);
    }

    public ArticlePage findArticle(int id) {
        return em.find(ArticlePage.class, id);
    }

    public CategoryPage findCategoryByPermalink(String perme) {
        Query queryCategoryByPermalink = em.createNamedQuery("CategoryPage.findByPermalink");
        queryCategoryByPermalink.setParameter("perme", perme);
        List<CategoryPage> category = queryCategoryByPermalink.getResultList();
        if (category.size() == 1) {
            return category.get(0);
        } else {
            return null;
        }
    }

    public SectionPage findSectionByPermalink(String perme) {
        Query querySectionByPermalink = em.createNamedQuery("SectionPage.findByPermalink");
        querySectionByPermalink.setParameter("perme", perme);
        List<SectionPage> section = querySectionByPermalink.getResultList();
        if (section.size() == 1) {
            return section.get(0);
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

    public void deleteArticle(int id) {
        ArticlePage a = findArticle(id);
        em.remove(em.merge(a));
    }

    public void deleteCategory(int id) {
        CategoryPage c = findCategory(id);
        em.remove(em.merge(c));
    }

    public void deleteSection(int id) {
        SectionPage s = findSection(id);
        em.remove(em.merge(s));
    }

    public boolean updateArticle(int id, String title, String permalink, String intro,
                                 String content,
                                 int mySection_id) {
        ArticlePage a = findArticle(id);
        SectionPage mySection = findSection(mySection_id);
        a.update(title, permalink, intro, content, mySection);
        try {
            em.merge(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateCategory(int id, String title, String permalink, String intro, String content) {
        CategoryPage c = findCategory(id);
        c.update(title, permalink, intro, content);
        try {
            em.merge(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateSection(int id, String title, String permalink, String intro, String content,
                                 int myCategory_id) {
        SectionPage s = findSection(id);
        CategoryPage myCategory = findCategory(myCategory_id);
        s.update(title, permalink, intro, content, myCategory);
        try {
            em.merge(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
