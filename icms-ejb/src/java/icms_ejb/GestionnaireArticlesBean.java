package icms_ejb;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
public class GestionnaireArticlesBean implements GestionnaireArticlesLocal {

  @PersistenceContext
  private EntityManager em;

  public void create(String title, String permalink, String intro, String content) {
    Article a = new Article(title, permalink, intro, content);
    em.persist(a);
  }

  public void update(int id, String title, String permalink, String intro, String content) {
    Article a = find(id);
    a.update(title, permalink, intro, content);
    em.merge(a);
  }

  public void destroy(int id) {
    Article a = find(id);
    em.remove(em.merge(a));
  }

  public Article find(int id) {
    return em.find(Article.class, id);
  }

  public List<Article> all() {
    return em.createNamedQuery("Articles.findAll").getResultList();
  }

  public Article findByPermalink(String perme) {
    Query queryArticlesByPermalink = em.createNamedQuery("Articles.findByPermalink");
    queryArticlesByPermalink.setParameter("perme", perme);
    List<Article> articles = queryArticlesByPermalink.getResultList();
    if (articles.size() == 1) {
      return articles.get(0);
    } else {
      return null;
    }
  }
}
