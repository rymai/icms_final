package icms_ejb;

import java.util.List;
import javax.ejb.Local;

@Local
public interface GestionnairePagesLocal {

    // Category
    public List<CategoryPage> allCategories();

    public CategoryPage findCategory(int id);

    public CategoryPage findCategoryByPermalink(String perme);

    public void createCategory(String title, String permalink, String intro, String content);

    public boolean updateCategory(int id, String title, String permalink, String intro,
                                  String content);

    public void deleteCategory(int id);

    // Section
    public List<SectionPage> allSections();

    public SectionPage findSection(int id);

    public SectionPage findSectionByPermalink(String perme);

    public void createSection(String title, String permalink, String intro, String content,
                              int myCategory_id);

    public boolean updateSection(int id, String title, String permalink, String intro,
                                 String content,
                                 int myCategory_id);

    public void deleteSection(int id);

    // Article
    public List<ArticlePage> allArticles();

    public ArticlePage findArticle(int id);

    public ArticlePage findArticleByPermalink(String perme);

    public void createArticle(String title, String permalink, String intro, String content,
                              int mySection_id);

    public boolean updateArticle(int id, String title, String permalink, String intro,
                                 String content,
                                 int mySection_id);

    public void deleteArticle(int id);
}
