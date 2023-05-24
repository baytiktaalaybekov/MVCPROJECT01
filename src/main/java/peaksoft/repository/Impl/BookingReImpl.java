package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Booking;
import peaksoft.entity.Customer;
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
        entityManager.merge(booking);
    }


    @Override
    public List<Booking> getAllBooking() {
        return entityManager.createQuery("from Booking b ",Booking.class).getResultList();
    }

    @Override
    public List<Booking> getAll(Long id) {
        return entityManager.createQuery("select b from Booking  b where b.houses.id =:id ", Booking.class).setParameter("id",id).getResultList();
    }

    @Override
    public Booking getBookingById(Long id) {
        return entityManager.find(Booking.class, id);
    }

    @Override
    public void updateBooking( Booking booking) {
//        Booking booking1 = entityManager.find(Booking.class, id);
//        booking1.setHouses(booking.getHouses());
//        booking1.setCustomers(booking.getCustomers());
        entityManager.merge(booking);
    }

    @Override
    public void deleteBookingById(Long id) {
        entityManager.remove(entityManager.find(Booking.class, id));

    }
}
