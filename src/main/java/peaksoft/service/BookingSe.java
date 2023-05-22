package peaksoft.service;

import peaksoft.entity.Booking;

import java.util.List;

public interface BookingSe {

    void saveBooking(Long houseId,Long customerId,Booking booking);

    List<Booking> getAll();

    Booking getBookingById(Long id);

    void updateBooking(Long id, Booking booking);

    void deleteBookingById(Long id);
}
