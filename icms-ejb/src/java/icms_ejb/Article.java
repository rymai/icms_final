package icms_ejb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ARTICLES")
@NamedQueries({
    @NamedQuery(name = "Articles.findAll",
    query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Articles.findByPermalink",
    query = "SELECT a FROM Article a WHERE a.permalink = :perme")
})
public class Article implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;
    
    private String permalink;

    private String intro;

    @Column(nullable = false)
    private String content;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "published_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    public Article() {
    }

    public Article(String title, String permalink, String intro, String content) {
        setTitle(title);
        setPermalink(permalink);
        setContent(content);
        setIntro(intro);
    }

    public void update(String title, String permalink, String intro, String text) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Long getId() {
        return id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
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

    /**
     * @param intro the intro to set
     */
    public void setIntro(String intro) {
        this.intro = intro.equals("") ? makeIntro(content) : makeIntro(intro);
    }

    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content.trim();
    }

    public String getPermalink() {
        return permalink;
    }

    /**
     * @param perm the text from which we will guess the permalink
     *        permalink is guessed from the title if perm is blank)
     */
    public void setPermalink(String perm) {
        this.permalink = perm.equals("") ? makePermalink(title) : makePermalink(perm);
    }

    /**
     * @param text
     * @return generated and safe permalink from text parameter
     */
    private String makePermalink(String text) {
        String perm = text.trim().toLowerCase().replaceAll("[\\W]+", "-");
        //check si le permalink est deja utilise, dans ce cas, on ajoute un int random au permalink tant qu'il existe
        return perm;
    }

    /**
     * Generate intro from text parameter
     * @param text
     * @return a substring of text parameter
     */
    private String makeIntro(String text) {
        text = text.trim().replaceAll("<\\/?p>", "");
        return "<p>" + text.substring(0, Math.min(text.length()-1, 29)) + "</p>";
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ICMS.Article[id=" + getId() + "]";
    }
}
