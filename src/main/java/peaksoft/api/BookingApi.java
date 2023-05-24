package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Booking;
import peaksoft.service.BookingSe;
import peaksoft.service.CustomerSe;
import peaksoft.service.HouseSe;

@Controller
@RequestMapping("/bookings/{id}")
@RequiredArgsConstructor
public class BookingApi {

    private final BookingSe bookingSe;
    private final HouseSe houseSe;
    private final CustomerSe customerSe;

    @GetMapping
    public String getAll(@PathVariable Long id, Model model) {
        model.addAttribute("booking", bookingSe.getAllBooking());
        model.addAttribute("booking", houseSe.getAllHouses(id));
        model.addAttribute("booking", customerSe.getAllCustomer(id));
        model.addAttribute(id);
        return "booking/bookings";

    }

    @GetMapping("/new")
    public String createBooking(@PathVariable Long id, Model model) {
        model.addAttribute("newBooking", new Booking());
        model.addAttribute("customers", customerSe.getAllCustomer(id));
        model.addAttribute("houses", houseSe.getAllHouses(id));
        model.addAttribute("houseId", id);
        return "booking/newBooking";

    }


    @PostMapping("/save")
    public String saveBooking(@ModelAttribute("newBooking") Booking booking, Model model) {
        try {
            bookingSe.saveBooking(booking);
            return "redirect:/bookings/{id}";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "booking/newBooking";
        }
    }

    @DeleteMapping("/{bookingId}/delete")
    public String deleteBooking(@PathVariable Long bookingId,
                                @PathVariable Long id) {
        bookingSe.deleteBookingById(bookingId);
        return "redirect:/bookings/{id}";
    }

    @GetMapping("/{bookingId}/edit")
    public String edit(@PathVariable Long bookingId,
                       @PathVariable Long id, Model model) {
        Booking bookingById = bookingSe.getBookingById(bookingId);
        model.addAttribute("houses", houseSe.getAllHouses(id));
        model.addAttribute("customers", customerSe.getAllCustomer(id));
        model.addAttribute("booking", bookingId);
        model.addAttribute(id);
        return "booking/updateBooking";
    }

    @PutMapping("/{bookingId}/update")
    public String update(@ModelAttribute("booking") Booking booking,
                         @PathVariable Long bookingId,
                         @PathVariable Long id) {
        bookingSe.updateBooking(bookingId, booking);
        return "redirect:/bookings/{id}";

    }

}
