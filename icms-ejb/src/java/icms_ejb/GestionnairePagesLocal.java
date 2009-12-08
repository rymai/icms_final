package icms_ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GestionnairePagesLocal {

    // Article
    public List<ArticlePage> allArticles();

    public ArticlePage findArticle(int id);

    public ArticlePage findArticleByPermalink(String perme);

    public void createArticle(String title, String permalink, String intro, String content,ArrayList<ArticlePage> children, ArrayList<ArticlePage> parents);

    public boolean updateArticle(int id, String title, String permalink, String intro, String content, ArrayList<ArticlePage> children, ArrayList<ArticlePage> parents);

    public void deleteArticle(int id);
}
