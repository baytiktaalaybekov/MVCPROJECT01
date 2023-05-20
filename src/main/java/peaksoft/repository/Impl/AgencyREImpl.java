package peaksoft.repository.Impl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRe;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class AgencyREImpl implements AgencyRe {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveAgency(Agency agency) {
        entityManager.persist(agency);
    }

    @Override
    public List<Agency> getAllAgency() {
        return entityManager.createQuery("from Agency a  ", Agency.class).getResultList();
    }



    @Override
    public Agency getAgencyById(Long id) {
        return entityManager.find(Agency.class,id);
    }

    @Override
    public void updateAgency(Long id, Agency agency) {
        Agency agency1 = entityManager.find(Agency.class, id);
        agency1.setName(agency.getName());
        agency1.setCountry(agency.getCountry());
        agency1.setPhoneNumber(agency.getPhoneNumber());
        agency1.setEmail(agency.getEmail());
        agency1.setImage_Link(agency.getImage_Link());
        entityManager.merge(agency1);
    }

    @Override
    public void deleteAgencyById(Long id) {
        entityManager.remove(entityManager.find(Agency.class,id));
    }

    @Override
    public List<Agency> search(String keyword) {
        return null;
    }
}
