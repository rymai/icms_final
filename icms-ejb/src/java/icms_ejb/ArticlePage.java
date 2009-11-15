package icms_ejb;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.*;

@Entity
@Table(name = "ARTICLES")
@NamedQueries({
    @NamedQuery(name = "ArticlePage.findAll",
                query = "SELECT a FROM ArticlePage a ORDER BY a.publishedAt DESC"),
    @NamedQuery(name = "ArticlePage.findByPermalink",
                query = "SELECT a FROM ArticlePage a WHERE a.permalink = :perme")
})
public class ArticlePage extends Page {

    private static final long serialVersionUID = 1L;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "published_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @ManyToOne
    private SectionPage mySection;

    public ArticlePage() {
        super();
    }

    public ArticlePage(String title, String permalink, String intro, String content,
                       SectionPage mySection) {
        super(title, permalink, intro, content);
        setMySection(mySection);
        createdAt = GregorianCalendar.getInstance().getTime();
        publishedAt = GregorianCalendar.getInstance().getTime();
    }

    public void update(String title, String permalink, String intro, String content,
                       SectionPage mySection) {
        super.update(title, permalink, intro, content);
        setMySection(mySection);
        updatedAt = GregorianCalendar.getInstance().getTime();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticlePage)) {
            return false;
        }
        ArticlePage other = (ArticlePage) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.
                equals(
                other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ArticlePage[id=" + getId() + "]";
    }

    public SectionPage getMySection() {
        return mySection;
    }

    public void setMySection(SectionPage mySection) {
        this.mySection = mySection;
    }
}
