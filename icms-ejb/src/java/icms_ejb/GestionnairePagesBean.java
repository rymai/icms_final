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

 
    public void createArticle(String title, String permalink, String intro, String content, ArrayList<ArticlePage> children, ArrayList<ArticlePage> parents) {
    //    SectionPage mySection = findSection(mySection_id);
      ArticlePage a = new ArticlePage(title, permalink, intro, content, children, parents );
      em.persist(a);
     //   mySection.getMyArticles().add(a);
        em.flush();
    }

  
    public List<ArticlePage> allArticles() {
        return em.createNamedQuery("ArticlePage.findAll").getResultList();
    }

   
    public ArticlePage findArticle(int id) {
        return em.find(ArticlePage.class, id);
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

 

    public boolean updateArticle(int id, String title, String permalink, String intro, String content, ArrayList<ArticlePage> children, ArrayList<ArticlePage> parents) {
        ArticlePage a = findArticle(id);
     //   SectionPage mySection = findSection(mySection_id);
      a.update(title, permalink, intro, content, children, parents);
        try {
            em.merge(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
