/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icms_ejb;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Chouchou
 */
@Entity
@Table(name = "SECTIONS")
@NamedQueries({
 @NamedQuery(name = "Section.findByTitle",
    query = "SELECT s FROM Sections s WHERE s.title = :title"),
     @NamedQuery(name = "Section.findAll",
      query = "SELECT s FROM Sections s")
})
public class SectionPage extends Page {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
      @ManyToOne
    private CategoryPage myCategory;

    @OneToMany(mappedBy = "mySection")
      private Collection<ArticlePage> myArticles;

    public SectionPage() {
    }

    public SectionPage(String title, String permalink, String intro, String content, CategoryPage myCategory) {
       super(title, permalink, intro, content);
       this.myCategory = myCategory;
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

    /**
     * @return the myCategory
     */
    public CategoryPage getMyCategory() {
        return myCategory;
    }

    /**
     * @param myCategory the myCategory to set
     */
    public void setMyCategory(CategoryPage myCategory) {
        this.myCategory = myCategory;
    }

    /**
     * @return the myArticles
     */
    public Collection<ArticlePage> getMyArticles() {
        return myArticles;
    }

    /**
     * @param myArticles the myArticles to set
     */
    public void setMyArticles(Collection<ArticlePage> myArticles) {
        this.myArticles = myArticles;
    }

    @Override
    public void update(String title, String permalink, String intro, String content) {
    setTitle(title);
        setPermalink(permalink);
        setIntro(intro);
        setContent(content);
    }

}
