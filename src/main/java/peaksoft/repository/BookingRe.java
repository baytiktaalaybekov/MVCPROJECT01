package peaksoft.repository;

import peaksoft.entity.Booking;

import java.util.List;

public interface BookingRe {

    void saveBooking(Booking booking);

    List<Booking> getAll();

    List<Booking> getAllHouse();

     Booking getBookingById(Long id);

    void updateBooking(Long id, Booking booking);

    void deleteBookingById(Long id);

}
