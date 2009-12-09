package icms_ejb;

import java.util.List;
import javax.ejb.Local;

@Local
public interface GestionnairePagesLocal {

 
    // Article
    public List<ArticlePage> allArticles();

    public ArticlePage findArticle(int id);

    public ArticlePage findArticleByPermalink(String perme);

    public void createArticle(String title, String permalink, String intro, String content, int parent_id);

    public boolean updateArticle(int id, String title, String permalink, String intro, String content,int parent_id);

    public void deleteArticle(int id);

    public List<ArticlePage> findAllChildren(int parent);

    public ArticlePage findParent(int son);

    public List<ArticlePage> findRoot();

}
