package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Agency;
import peaksoft.entity.House;
import peaksoft.repository.HouseRe;
import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class HouseReImpl implements HouseRe {

    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public void saveHouse(Long agencyId, House house) {
        Agency agency = entityManager.find(Agency.class, agencyId);
        house.setAgencies(agency);
        entityManager.persist(house);
    }

    @Override
    public List<House> getAllHouses() {
        return entityManager.createQuery("select House ", House.class).getResultList();
    }

    @Override
    public List<House> getAllHouse(Long agencyId) {
        return entityManager.createQuery("from House h join Agency a where  h.agencies.id = :agencyId", House.class)
                .setParameter("agencyId",agencyId).getResultList();
    }

    @Override
    public void deleteHouse(Long id)                                 {
        entityManager.remove(entityManager.find(House.class,id));
    }

    @Override
    public void updateHouse(Long id, House house) {
        House house1 = entityManager.find(House.class, id);
        house1.setHouseType(house.getHouseType());
        house1.setAddress(house.getAddress());
        house1.setPrice(house.getPrice());
        house1.setRoom(house.getRoom());
        house1.setDescription(house.getDescription());
        house1.setIs_Booked(house.getIs_Booked());
        entityManager.merge(house1);

    }

    @Override
    public House getHouseById(Long id) {
        return entityManager.find(House.class,id);
    }
}
