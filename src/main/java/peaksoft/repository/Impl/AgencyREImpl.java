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
        return entityManager.createQuery("from Agency a", Agency.class).getResultList();
    }

    @Override
    public AgencyRe getAgencyById(Long id) {
        return null;
    }

    @Override
    public void updateAgency(Long id, Agency agency) {

    }

    @Override
    public void deleteAgencyById(Long id) {

    }
}
