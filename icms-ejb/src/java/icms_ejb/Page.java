/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package icms_ejb;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Chouchou
 */
@MappedSuperclass
public abstract class Page implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    protected String title;
    protected String permalink;
    protected String intro;
    @Column(nullable = false)
    protected String content;


    public Page(){}

    public Page(String title, String permalink, String intro, String content) {
        setTitle(title);
        setPermalink(permalink);
        setContent(content);
        setIntro(intro);
    }

    public abstract void update(String title, String permalink, String intro, String content);

    public Long getId() {
        return id;
    }

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

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
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
        String perm = text.trim().toLowerCase().replaceAll("\\s+", "_").replaceAll("\\W+", "").
                replaceAll("_+", "-");
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
        return "<p>" + text.substring(0, Math.min(text.length() - 1, 29)) + "</p>";
    }
}
