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

    public void createArticle(String title, String permalink, String intro, String content,
            SectionPage mySection) {
        ArticlePage a = new ArticlePage(title, permalink, intro, content, mySection);
        em.persist(a);
        mySection.getMyArticles().add(a);
    }

    public void createSection(String title, String permalink, String intro, String content,
            CategoryPage myCategory) {
        SectionPage s = new SectionPage(title, permalink, intro, content, myCategory);
        em.persist(s);
        myCategory.getMySections().add(s);
    }

    public void createCategory(String title, String permalink, String intro, String content) {
        CategoryPage c = new CategoryPage(title, permalink, intro, content);
        em.persist(c);
    }

    public void update(int id, String title, String permalink, String intro, String content) {
        ArticlePage p = find(id);
        p.update(title, permalink, intro, content);
        em.merge(p);
    }

    public void destroy(int id) {
        ArticlePage p = find(id);
        em.remove(em.merge(p));
    }

    public ArticlePage find(int id) {
        return em.find(ArticlePage.class, id);
    }

    public List<ArticlePage> all() {
        return em.createNamedQuery("ArticlePage.findAll").getResultList();
    }

    public ArticlePage findArticleByPermalink(String perme) {
        Query queryArticlesByPermalink = em.createNamedQuery("ArticlePage.findByPermalink");
        queryArticlesByPermalink.setParameter("perm", perme);
        List<ArticlePage> articles = queryArticlesByPermalink.getResultList();
        if (articles.size() == 1) {
            return articles.get(0);
        } else {
            return null;
        }
    }

    public CategoryPage findCategoryByPermalink(String perme) {
        Query queryCategoryByPermalink = em.createNamedQuery("CategoryPage.findByPermalink");
        queryCategoryByPermalink.setParameter("perm", perme);
        List<CategoryPage> category = queryCategoryByPermalink.getResultList();
        if (category.size() == 1) {
            return category.get(0);
        } else {
            return null;
        }
    }

    public SectionPage findSectionByPermalink(String perme) {
        Query querySectionByPermalink = em.createNamedQuery("SectionPage.findByPermalink");
        querySectionByPermalink.setParameter("perm", perme);
        List<SectionPage> section = querySectionByPermalink.getResultList();
        if (section.size() == 1) {
            return section.get(0);
        } else {
            return null;
        }
    }

    public List<SectionPage> allSections() {
        Query queryAllSections = em.createNamedQuery("SectionPage.findAll");
        List<SectionPage> sections = queryAllSections.getResultList();
        return sections;
    }

    public SectionPage findSectionByTitle(String titre) {
        Query querySectionByTitle = em.createNamedQuery("SectionPage.findByTitle");
        querySectionByTitle.setParameter("titre", titre);
        List<SectionPage> sections = querySectionByTitle.getResultList();
        if (sections.size() == 1) {
            return sections.get(0);
        } else {
            return null;
        }
    }

    public CategoryPage findCategoryByTitle(String titre) {
        Query queryCategoryByTitle = em.createNamedQuery("CategoryPage.findByTitle");
        queryCategoryByTitle.setParameter("titre", titre);
        List<CategoryPage> categories = queryCategoryByTitle.getResultList();
        if (categories.size() >= 1) {
            return categories.get(0);
        } else {
            return null;
        }
    }

    public List<CategoryPage> allCategories() {
        Query queryAllCategories = em.createNamedQuery("CategoryPage.findAll");
        List<CategoryPage> categories = queryAllCategories.getResultList();
        return categories;
    }

    public int DeleteArticle(String id) {
        Query queryDeleteArticle = em.createNamedQuery("ArticlePage.delete");

        queryDeleteArticle.setParameter("id", Integer.parseInt(id));
        return queryDeleteArticle.executeUpdate();
    }

    public int DeleteCategory(String id) {
        Query queryDeleteCategory = em.createNamedQuery("CategoryPage.delete");

        queryDeleteCategory.setParameter("id", Integer.parseInt(id));
        return queryDeleteCategory.executeUpdate();
    }

    public int DeleteSection(String id) {
        Query queryDeleteSection = em.createNamedQuery("SectionPage.delete");

        queryDeleteSection.setParameter("id", Integer.parseInt(id));
        return queryDeleteSection.executeUpdate();
    }

    public int UpdateArticle(String id, String title, String intro, String content, SectionPage mySection) {
        Query queryUpdateArticle = em.createNamedQuery("ArticlePage.update");
        queryUpdateArticle.setParameter("title", title);
        queryUpdateArticle.setParameter("intro", intro);
        queryUpdateArticle.setParameter("content", content);
        queryUpdateArticle.setParameter("mySection", mySection);
        queryUpdateArticle.setParameter("id", Integer.parseInt(id));
        return queryUpdateArticle.executeUpdate();
    }

      public int UpdateCategory(String id, String title, String intro, String content) {
        Query queryUpdateCategory = em.createNamedQuery("CategoryPage.update");
        queryUpdateCategory.setParameter("title", title);
        queryUpdateCategory.setParameter("intro", intro);
        queryUpdateCategory.setParameter("content", content);
        queryUpdateCategory.setParameter("id", Integer.parseInt(id));
        return queryUpdateCategory.executeUpdate();
    }

        public int UpdateSection(String id, String title, String intro, String content, CategoryPage myCategory) {
        Query queryUpdateSection = em.createNamedQuery("SectionPage.update");
        queryUpdateSection.setParameter("title", title);
        queryUpdateSection.setParameter("intro", intro);
        queryUpdateSection.setParameter("content", content);
        queryUpdateSection.setParameter("myCategory", myCategory);
        queryUpdateSection.setParameter("id", Integer.parseInt(id));
        return queryUpdateSection.executeUpdate();
    }
}
