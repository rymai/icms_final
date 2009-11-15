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

    public CategoryPage findCategoryByTitle(String titre);

    public CategoryPage findCategoryByPermalink(String perme);

    public SectionPage findSectionByPermalink(String perme);
}
