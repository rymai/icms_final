package icms_ejb;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "CATEGORIES")
@NamedQueries({
    @NamedQuery(name = "CategoryPage.findByTitle",
                query = "SELECT c FROM CategoryPage c WHERE c.title = :titre"),
    @NamedQuery(name = "CategoryPage.findAll",
                query = "SELECT c FROM CategoryPage c"),
    @NamedQuery(name = "CategoryPage.findByPermalink",
                query = "SELECT c FROM CategoryPage c WHERE c.permalink = :perme"),
    @NamedQuery(name = "CategoryPage.delete",
                query = "DELETE FROM CategoryPage c WHERE c.id = :id"),
    @NamedQuery(name = "CategoryPage.update",
                query = "UPDATE CategoryPage c SET c.title = :title,c.intro = :intro, c.content = :content WHERE c.id = :id")
})
public class CategoryPage extends Page {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    @OneToMany(mappedBy = "myCategory")
    private Collection<SectionPage> mySections;

    public CategoryPage() {
        super();
    }

    CategoryPage(String title, String permalink, String intro, String content) {
        super(title, permalink, intro, content);
        mySections = new ArrayList<SectionPage>();
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
        if (!(object instanceof CategoryPage)) {
            return false;
        }
        CategoryPage other = (CategoryPage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icms_ejb.CategoryPage[id=" + id + "]";
    }

    public Collection<SectionPage> getMySections() {
        return mySections;
    }

    public void setMySections(Collection<SectionPage> mySections) {
        this.mySections = mySections;
    }

//    @Override
//    public void update(String title, String permalink, String intro, String content) {
//        setTitle(title);
//        setPermalink(permalink);
//        setIntro(intro);
//        setContent(content);
//    }
}
