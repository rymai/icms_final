package icms_ejb;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.*;

@Entity
@Table(name = "ARTICLES")
@NamedQueries({
    @NamedQuery(name = "Articles.findAll",
                query = "SELECT a FROM Articles a"),
    @NamedQuery(name = "Articles.findByPermalink",
                query = "SELECT a FROM Articles a WHERE a.permalink = :perme")
})
public class ArticlePage extends Page {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
        this.mySection = mySection;
        createdAt = GregorianCalendar.getInstance().getTime();
        publishedAt = GregorianCalendar.getInstance().getTime();
    }

    @Override
    public void update(String title, String permalink, String intro, String content) {
        setTitle(title);
        setPermalink(permalink);
        setIntro(intro);
        setContent(content);
        updatedAt = GregorianCalendar.getInstance().getTime();
    }

    @Override
    public Long getId() {
        return id;
    }

    /**
     * @return the title
     */
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

    /**
     * @return the mySection
     */
    public SectionPage getMySection() {
        return mySection;
    }

    /**
     * @param mySection the mySection to set
     */
    public void setMySection(SectionPage mySection) {
        this.mySection = mySection;
    }
}
