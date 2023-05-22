package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Booking;
import peaksoft.repository.BookingRe;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class BookingReImpl implements BookingRe {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveBooking(Booking booking) {
        entityManager.persist(booking);
    }


    @Override
    public List<Booking> getAllHouse() {
        return entityManager.createQuery("from Booking b ",Booking.class).getResultList();
    }

    @Override
    public List<Booking> getAll() {
        return entityManager.createQuery("select b from Booking b order by b.id desc ", Booking.class).getResultList();
    }

    @Override
    public Booking getBookingById(Long id) {
        return entityManager.find(Booking.class, id);
    }

    @Override
    public void updateBooking(Long id, Booking booking) {
        Booking booking1 = entityManager.find(Booking.class, id);
        booking1.setHouses(booking.getHouses());
        booking1.setCustomers(booking.getCustomers());
        entityManager.merge(booking1);
    }

    @Override
    public void deleteBookingById(Long id) {
        entityManager.remove(entityManager.find(Booking.class, id));

    }
}
