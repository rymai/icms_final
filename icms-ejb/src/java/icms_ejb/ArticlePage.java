package icms_ejb;

import java.io.Serializable;
import java.util.ArrayList;
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
public class ArticlePage implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
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
    @ManyToMany
    @Column(name = "myChildren")
    private ArrayList<ArticlePage> myChildren;
    @ManyToMany(mappedBy = "myChilds")
    @Column(name = "myParents")
    private ArrayList<ArticlePage> myParents;
    @Column(name = "title")
    private String title;
    @Column(name = "intro")
    private String intro;
    @Column(name = "content")
    private String content;
    @Column(name = "permalink")
    private String permalink;

    public ArticlePage() {
    }

    public ArticlePage(String title, String permalink, String intro, String content, ArrayList<ArticlePage> children, ArrayList<ArticlePage> parents) {
        this.title = title;
        this.permalink = permalink;
        this.content = content;
        this.intro = intro;
        createdAt = GregorianCalendar.getInstance().getTime();
        publishedAt = GregorianCalendar.getInstance().getTime();
        updatedAt = GregorianCalendar.getInstance().getTime();
        myChildren = children;
        myParents = parents;
    }

    public void update(String title, String permalink, String intro, String content,  ArrayList<ArticlePage> children, ArrayList<ArticlePage> parents) {
         this.title = title;
        this.permalink = permalink;
        this.content = content;
        this.intro = intro;
        updatedAt = GregorianCalendar.getInstance().getTime();
         setMyChildren(children);
        setMyParents(parents);
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
    //  public String getTermsForSearch() {
    //      return getTitle()+","+getMySection().getTitle()+","+getMySection().getMyCategory().getTitle();
    //  }

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
        String perme = text.trim().toLowerCase().replaceAll("\\s+", "_").replaceAll("\\W+", "").
                replaceAll("_+", "-");
        //check si le permalink est deja utilise, dans ce cas, on ajoute un int random au permalink tant qu'il existe
//        System.out.println("this.getClass() : " + this.getClass());
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("icms-ejbPU");
//        EntityManager em = emf.createEntityManager(); // Retrieve an application managed entity manager
//
//        Query queryByPermalink = em.createNamedQuery(
//                this.getClass().toString() + ".findByPermalink");
        int r = 0;
//        List<Page> pages;
//
//        queryByPermalink.setParameter("perme", perme);
//        pages = queryByPermalink.getResultList();
//
//        while (pages.size() > 0) {
//            r = (int) (Math.random() * 1000);
//            queryByPermalink.setParameter("perme", perme + r);
//            pages = queryByPermalink.getResultList();
//        }

        return perme + (r == 0 ? "" : r);
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

    /**
     * @return the myChildren
     */
    public ArrayList<ArticlePage> getMyChildren() {
        return myChildren;
    }

    /**
     * @param myChildren the myChildren to set
     */
    public void setMyChildren(ArrayList<ArticlePage> myChildren) {
        this.myChildren = myChildren;
    }

    /**
     * @return the myParents
     */
    public ArrayList<ArticlePage> getMyParents() {
        return myParents;
    }

    /**
     * @param myParents the myParents to set
     */
    public void setMyParents(ArrayList<ArticlePage> myParents) {
        this.myParents = myParents;
    }
}
