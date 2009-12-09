package icms_ejb;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.*;

@Entity
@Table(name = "ARTICLES")
@NamedQueries({
    @NamedQuery(name = "ArticlePage.findAll",
    query = "SELECT a FROM ArticlePage a ORDER BY a.publishedAt DESC"),
    @NamedQuery(name = "ArticlePage.findByPermalink",
    query = "SELECT a FROM ArticlePage a WHERE a.permalink = :perme"),
    @NamedQuery(name = "ArticlePage.findAllChildren",
    query = "SELECT a FROM ArticlePage a WHERE a.myParent = :parent"),
    @NamedQuery(name = "ArticlePage.findParent",
    query = "SELECT a2 FROM ArticlePage a, ArticlePage a2 WHERE a.myParent = a2 AND a= :son")
})
public class ArticlePage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    @Column(nullable = false)
    protected String title;
    @Column(unique = true)
    protected String permalink;
    protected String intro;
    @Column(length = 1000)
    protected String content;
    private static EntityManager em;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "published_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "myParent")
    @ManyToOne
    private ArticlePage myParent;

    public ArticlePage() {
    }

    public ArticlePage(String title, String permalink, String intro, String content, ArticlePage parent) {
        this.title = title;
        this.permalink = permalink;
        this.content = content;
        this.intro = intro;
        createdAt = GregorianCalendar.getInstance().getTime();
        publishedAt = GregorianCalendar.getInstance().getTime();
        updatedAt = GregorianCalendar.getInstance().getTime();
        myParent = parent;
    }

    public void update(String title, String permalink, String intro, String content, ArticlePage parent) {
        this.title = title;
        this.permalink = permalink;
        this.content = content;
        this.intro = intro;
        updatedAt = GregorianCalendar.getInstance().getTime();
        myParent = parent;

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
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(
                other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ArticlePage[id=" + getId() + "]";
    }

    public String getTermsForSearch() {
        String search = getTitle();
        boolean moreParents = false;
        ArticlePage articleParent = null;
        if (myParent != null) {
            articleParent = myParent;
            moreParents = true;
        }
        while (moreParents == true) {
            search += "," + articleParent.getTitle();
            if (articleParent.getMyParent() != null) {
                articleParent = articleParent.getMyParent();
            } else {
                moreParents = false;
            }
        }
        return search;
    }

    /**
     * @return the myParent
     */
    public ArticlePage getMyParent() {
        return myParent;
    }

    /**
     * @param myParent the myParent to set
     */
    public void setMyParent(ArticlePage myParent) {
        this.myParent = myParent;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro.equals("") ? makeIntro(content) : makeIntro(intro);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content.trim();
    }

    public String getPermalink() {
        return permalink;
    }

    /**
     * Generate intro from text parameter
     * @param text
     * @return a substring of text parameter
     */
    private String makeIntro(String text) {
        text = text.trim().replaceAll("<\\/?p>", "");
        return "<p>" + text.substring(0, Math.min(text.length(), 59)) + "</p>";
    }
}
