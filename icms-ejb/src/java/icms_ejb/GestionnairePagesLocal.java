package icms_ejb;

import java.util.List;
import javax.ejb.Local;

@Local
public interface GestionnairePagesLocal {

    public void createArticle(String title, String permalink, String intro, String content,
                              SectionPage mySection);

    public void createSection(String title, String permalink, String intro, String content,
                              CategoryPage myCategory);

    public void createCategory(String title, String permalink, String intro, String content);

    public void update(int id, String title, String permalink, String intro, String content);

    public void destroy(int id);

    public ArticlePage find(int id);

    public List<ArticlePage> all();

    public List<CategoryPage> allCategories();

    public List<SectionPage> allSections();

    public ArticlePage findArticleByPermalink(String perme);

    public SectionPage findSectionByTitle(String title);

    public icms_ejb.CategoryPage findCategoryByTitle(java.lang.String titre);

    public icms_ejb.CategoryPage findCategoryByPermalink(java.lang.String perme);

    public icms_ejb.SectionPage findSectionByPermalink(java.lang.String perme);

    public int DeleteArticle(String id);

    public int DeleteCategory(java.lang.String id);

    public int DeleteSection(java.lang.String id);

    public int UpdateArticle(java.lang.String id, java.lang.String title, java.lang.String intro, java.lang.String content, icms_ejb.SectionPage mySection);

    public int UpdateCategory(java.lang.String id, java.lang.String title, java.lang.String intro, java.lang.String content);

    public int UpdateSection(java.lang.String id, java.lang.String title, java.lang.String intro, java.lang.String content, icms_ejb.CategoryPage myCategory);
}
