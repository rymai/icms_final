package icms_ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.*;

@Entity
@Table(name = "PAGES")
@NamedQueries({
    @NamedQuery(name = "Page.findAll",
                query = "SELECT a FROM Page a ORDER BY a.publishedAt DESC"),
    @NamedQuery(name = "Page.findAllRoots",
                query = "SELECT a FROM Page a WHERE a.myParent IS NULL ORDER BY a.publishedAt DESC"),
    @NamedQuery(name = "Page.findAllSections",
                query = "SELECT a FROM Page a WHERE a.myParent IS NOT NULL AND (SELECT COUNT(a2) FROM Page a2 WHERE a2.myParent = a.id) > 0 ORDER BY a.publishedAt DESC"),
    @NamedQuery(name = "Page.findAllArticles",
                query = "SELECT a FROM Page a WHERE a.myParent IS NOT NULL AND (SELECT COUNT(a2) FROM Page a2 WHERE a2.myParent = a.id) = 0 ORDER BY a.publishedAt DESC"),
    @NamedQuery(name = "Page.findByPermalink",
                query = "SELECT a FROM Page a WHERE a.permalink = :perme"),
    @NamedQuery(name = "Page.findByPermalinkAndIdIsNot",
                query = "SELECT a FROM Page a WHERE a.permalink = :perme AND a.id <> :id"),
    @NamedQuery(name = "Page.findAllChildren",
                query = "SELECT a FROM Page a WHERE a.myParent = :parent_id"),
    @NamedQuery(name = "Page.findParent",
                query = "SELECT a FROM Page a WHERE a.id = (SELECT a2.myParent FROM Page a2 WHERE a2.id = :id)")
})
public class Page implements Serializable {

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
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "published_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "my_parent")
    @ManyToOne
    private Page myParent;

    // Ne pas supprimer ^^
    public Page() {
    }

    public Page(String title, String permalink, String intro, String content,
                Page parent) {
        setTitle(title);
        setPermalink(permalink);
        setContent(content);
        setIntro(intro);
        createdAt = GregorianCalendar.getInstance().getTime();
        publishedAt = GregorianCalendar.getInstance().getTime();
        updatedAt = GregorianCalendar.getInstance().getTime();
        myParent = parent;
    }

    public void update(String title, String permalink, String intro, String content,
                       Page parent) {
        setTitle(title);
        setPermalink(permalink);
        setContent(content);
        setIntro(intro);
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
        if (!(object instanceof Page)) {
            return false;
        }
        Page other = (Page) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.
                equals(
                other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Page[id=" + getId() + "]";
    }

    public ArrayList<String> getTermsForSearch() {
        ArrayList<String> terms = new ArrayList<String>();
        terms.add(title);
        if (myParent != null) {
            terms.addAll(myParent.getTermsForSearch());
        }

        return terms;
    }

    /**
     * @return the myParent
     */
    public Page getMyParent() {
        return myParent;
    }

    /**
     * @param myParent the myParent to set
     */
    public void setMyParent(Page myParent) {
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
        this.intro = intro;//.equals("") ? makeIntro(content) : makeIntro(intro);
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

    public void setPermalink(String perm) {
        this.permalink = perm;
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

    public boolean hasParent() {
        return myParent != null;
    }

    public boolean hasChildren() {
//        return !new GestionnairePagesBean().children(id).isEmpty();
        return true;
    }
}
