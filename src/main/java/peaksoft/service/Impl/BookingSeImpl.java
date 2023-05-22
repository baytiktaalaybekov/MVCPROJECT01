package peaksoft.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Booking;
import peaksoft.entity.Customer;
import peaksoft.entity.House;
import peaksoft.repository.BookingRe;
import peaksoft.repository.CustomerRE;
import peaksoft.repository.HouseRe;
import peaksoft.service.BookingSe;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingSeImpl implements BookingSe {

    private final BookingRe bookingRe;
    private final HouseRe houseRe;
    private final CustomerRE customerRe;


    @Override
    public void saveBooking(Long houseId, Long customerId, Booking booking) {
        House houseById = houseRe.getHouseById(houseId);
        Customer customerById = customerRe.getCustomerById(customerId);
        booking.setHouses(houseById);
        booking.setCustomers(customerById);
        bookingRe.saveBooking(booking);
    }

    @Override
    public List<Booking> getAll() {
        return bookingRe.getAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRe.getBookingById(id);
    }

    @Override
    public void updateBooking(Long id, Booking booking) {
        bookingRe.updateBooking(id,booking);
    }

    @Override
    public void deleteBookingById(Long id) {
        bookingRe.deleteBookingById(id);
    }
}
