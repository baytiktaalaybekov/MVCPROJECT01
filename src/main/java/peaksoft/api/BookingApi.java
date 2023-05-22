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
@RequestMapping("/bookings/{agencyId}")
@RequiredArgsConstructor
public class BookingApi {

    private final BookingSe bookingSe;
    private final HouseSe houseSe;
    private final CustomerSe customerSe;

    @GetMapping
    public String getAllBooking(@PathVariable Long agencyId, Model model){
        model.addAttribute("booking",bookingSe.getAll());
        model.addAttribute(agencyId);
        return "booking/bookings";

    }

    @GetMapping("/new")
    public String createBooking(@PathVariable Long agencyId,
                                Model model){
        model.addAttribute("newBooking",new Booking());
        model.addAttribute("customers",customerSe.getAllCustomer());
        model.addAttribute("houses",houseSe.getAllHouses());
        model.addAttribute(agencyId);
        return "booking/newBooking";
    }

    @PostMapping("/save")
    public String saveBooking(@ModelAttribute("newBooking") Booking booking,
                              @RequestParam("houseId") Long houseId,
                              @RequestParam("customerId") Long customerId, @PathVariable Long agencyId){
        bookingSe.saveBooking(customerId,houseId,booking);
        return "redirect:/bookings/{agencyId}";
    }
    @DeleteMapping("{bookingId}/delete")
    public String deleteBooking(@PathVariable Long bookingId,
                                @PathVariable Long agencyId){
        bookingSe.deleteBookingById(bookingId);
        return "redirect:/bookings/{agencyId}";

    }



}
