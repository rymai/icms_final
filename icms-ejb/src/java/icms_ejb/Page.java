package icms_ejb;

import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
public abstract class Page implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    @Column(nullable = false)
    protected String title;
    protected String permalink;
    protected String intro;
    @Column(length=1000)
     protected String content;
    private static EntityManager em;

    public Page() {
//        Marche pas!!!!!!! :|
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("icms-ejbPU");
//        Page.em = emf.createEntityManager(); // Retrieve an application managed entity manager
    }

    public Page(String title, String permalink, String intro, String content) {
        super();
        setTitle(title);
        setPermalink(permalink);
        setContent(content);
        setIntro(intro);
    }

    public void update(String title, String permalink, String intro, String content) {
        setTitle(title);
        setPermalink(permalink);
        setContent(content);
        setIntro(intro);
    }

    public Integer getId() {
        return id;
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
        if (!(object instanceof Page)) {
            return false;
        }
        Page other = (Page) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icms_ejb.Page[id=" + id + "]";
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
        return "<p>" + text.substring(0, Math.min(text.length() - 1, 29)) + "</p>";
    }
}
