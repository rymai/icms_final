package icms_plugin.advertisement;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "ADVERTISEMENTS")
@NamedQueries({
    @NamedQuery(name = "Advertisement.findAll",
                query = "SELECT a FROM Advertisement a ORDER BY a.publishedAt DESC"),
    @NamedQuery(name = "Advertisement.findByService",
                query = "SELECT a FROM Advertisement a WHERE a.service = :service")
})
public class Advertisement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private String link;
    @Column(length = 1000)
    private String content;
    @Column(nullable = false)
    private String service;
    @Column(nullable = false)
    private String criteria;
    @Column(name = "CRITERIA_VALUE", nullable = false)
    private String criteriaValue;
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "PUBLISHED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedAt;
    @Column(name = "EXPIRED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredAt;

    // Ne pas supprimer, sinon erreur Toplink
    public Advertisement() {
    }

    public Integer getId() {
        return id;
    }

    public Advertisement(String title, String link, String content, String service, String criteria,
                         String criteria_value) {
        this.title = title;
        this.link = link;
        this.content = content;
        this.service = service;
        this.criteria = criteria;
        this.criteriaValue = criteria_value;
    }

    public void update(String title, String link, String content, String service, String criteria,
                       String criteria_value) {
        this.title = title;
        this.link = link;
        this.content = content;
        this.service = service;
        this.criteria = criteria;
        this.criteriaValue = criteria_value;

    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCriteriaValue(String criteria_value) {
        this.criteriaValue = criteria_value;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCriteria() {
        return criteria;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public String getLink() {
        return link;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public String getService() {
        return service;
    }

    public String getTitle() {
        return title;
    }

    public String getCriteriaValue() {
        return criteriaValue;
    }

    public static ArrayList<String[]> servicesForSelect() {
        ArrayList<String[]> services = new ArrayList<String[]>(2);
        services.add(new String[]{"facebook", "Facebook"});
        services.add(new String[]{"twitter", "Twitter"});
        services.add(new String[]{"meteo", "M&eacute;t&eacute;o"});
        return services;
    }

    public static ArrayList<String[]> criteriasForSelect() {
        ArrayList<String[]> criterias = new ArrayList<String[]>(2);
        criterias.add(new String[]{"sex", "Sexe"});
        criterias.add(new String[]{"relationship_status", "Situation"});
        criterias.add(new String[]{"conditions", "Conditions"});
        criterias.add(new String[]{"temperature", "Temp&eacute;rature"});
        return criterias;
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
        if (!(object instanceof Advertisement)) {
            return false;
        }
        Advertisement other = (Advertisement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "icms_ejb.Advertisement[id=" + id + "]";
    }
}
