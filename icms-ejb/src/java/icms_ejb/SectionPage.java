package icms_ejb;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "SECTIONS")
@NamedQueries({
    @NamedQuery(name = "SectionPage.findByTitle",
                query = "SELECT s FROM SectionPage s WHERE s.title = :titre"),
    @NamedQuery(name = "SectionPage.findAll",
                query = "SELECT s FROM SectionPage s"),
    @NamedQuery(name = "SectionPage.findByPermalink",
                query = "SELECT s FROM SectionPage s WHERE s.permalink = :perme")
})
public class SectionPage extends Page {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private CategoryPage myCategory;
    @OneToMany(mappedBy = "mySection")
    private Collection<ArticlePage> myArticles;

    public SectionPage() {
        super();
    }

    public SectionPage(String title, String permalink, String intro, String content,
                       CategoryPage myCategory) {
        super(title, permalink, intro, content);
        setMyCategory(myCategory);
        myArticles = new ArrayList<ArticlePage>();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectionPage)) {
            return false;
        }
        SectionPage other = (SectionPage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icms_ejb.SectionPage[id=" + id + "]";
    }

    public CategoryPage getMyCategory() {
        return myCategory;
    }

    public void setMyCategory(CategoryPage myCategory) {
        this.myCategory = myCategory;
    }

    public Collection<ArticlePage> getMyArticles() {
        return myArticles;
    }

    public void setMyArticles(Collection<ArticlePage> myArticles) {
        this.myArticles = myArticles;
    }

    void update(String title, String permalink, String intro, String content,
                CategoryPage myCategory) {
        super.update(title, permalink, intro, content);
        setMyCategory(myCategory);
    }
}
