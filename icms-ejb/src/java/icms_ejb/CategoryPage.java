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
                query = "SELECT c FROM CategoryPage c")
})
public class CategoryPage extends Page {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "myCategory")
    private Collection<SectionPage> mySections;

    public CategoryPage() {
    }

    CategoryPage(String title, String permalink, String intro, String content) {
        super(title, permalink, intro, content);
        mySections = new ArrayList<SectionPage>();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    /**
     * @return the mySections
     */
    public Collection<SectionPage> getMySections() {
        return mySections;
    }

    /**
     * @param mySections the mySections to set
     */
    public void setMySections(Collection<SectionPage> mySections) {
        this.mySections = mySections;
    }

    @Override
    public void update(String title, String permalink, String intro, String content) {
        setTitle(title);
        setPermalink(permalink);
        setIntro(intro);
        setContent(content);
    }
}
