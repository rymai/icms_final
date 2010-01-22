package icms_ejb;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful
public class GestionnaireAdvertisementsBean implements GestionnaireAdvertisementsLocal {

    @PersistenceContext
    private EntityManager em;

    public void create(String title, String link, String content, String service, String criteria, String criteria_value) {
        Advertisement a = new Advertisement(title, link, content, service, criteria, criteria_value);
        em.persist(a);
        em.flush();
    }

    public boolean update(int id, String title, String link, String content, String service, String criteria,
                          String criteria_value) {
        Advertisement a = find(id);

        a.update(title, link, content, service, criteria, criteria_value);
        try {
            em.merge(a);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void destroy(int id) {
        Advertisement a = find(id);
        em.remove(em.merge(a));
    }

    public Advertisement find(int id) {
        if (id != 0) {
            return em.find(Advertisement.class, id);
        } else {
            return null;
        }
    }

    public Advertisement findByService(String service) {
        Query queryPagesByPermalink = em.createNamedQuery("Advertisement.findByService");
        queryPagesByPermalink.setParameter("service", service);
        List<Advertisement> ads = queryPagesByPermalink.getResultList();
        if (ads.size() == 1) {
            return ads.get(0);
        } else {
            return null;
        }
    }

    public List<Advertisement> allAdvertisements() {
        return em.createNamedQuery("Advertisement.findAll").getResultList();
    }

}
