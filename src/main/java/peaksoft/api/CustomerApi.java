package peaksoft.api;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Customer;
import peaksoft.enums.Gender;
import peaksoft.service.CustomerSe;

@Controller
@RequestMapping("/customers/{agencyId}")
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerSe customerSe;

    @GetMapping()
    public String getAllCustomer(@PathVariable Long agencyId, Model model){
        model.addAttribute("customer",customerSe.getAllCustomer());
        model.addAttribute(agencyId);
        return "customer/customerMain";
    }

    @GetMapping("/new")
    public String createCustomer(@PathVariable Long agencyId,Model model){
        model.addAttribute("newCustomer",new Customer());
        model.addAttribute(agencyId);
        model.addAttribute("male", Gender.MALE.name());
        model.addAttribute("female", Gender.FEMALE.name());
        return "customer/newCustomer";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute ("newCustomer") Customer customer,
                               @PathVariable Long agencyId) {
        customerSe.saveCustomer(customer);
        return "redirect:/customers/" + agencyId;
    }

    @DeleteMapping("/delete/{customerId}")
    public String deleteCustomerById(@PathVariable Long agencyId,
                                     @PathVariable Long customerId){
        customerSe.deleteCustomerById(customerId);
        return "redirect:/customers/{agencyId}";
    }

    @GetMapping("/edit/{customerId}")
    public String editCustomer(@PathVariable Long agencyId,
                               @PathVariable Long customerId,Model model){
        model.addAttribute("customer",customerSe.getCustomerById(customerId));
        return "customer/updateCustomer";
    }
    @PutMapping("/update/{customerId}")
    public String updateCustomer(@PathVariable Long agencyId,
                                 @PathVariable Long customerId,
                                 @ModelAttribute ("customer") Customer customer){
        customerSe.updateCustomer(customerId,customer);
        return "redirect:/customers/{agencyId}";
    }

//    @GetMapping("assign/{customerId}")
//    public String assign(@PathVariable Long agencyId,
//                                         @PathVariable Long customerId,Model model){
//        model.addAttribute("customer",new Customer());
//        model.addAttribute("assignCustomer",customerSe.getCustomerById(customerId));
//        return "customer/assignCustomers";
//    }
//    @PostMapping("/assignCustomerToAgency/{customerId}")
//    public String assignCustomerToAgency(@PathVariable Long customerId,
//                                         @PathVariable Long agencyId,
//                                         @ModelAttribute ("assignCustomer") Customer customer) {
//        customerSe.assignCustomerToAgency(customerId, customer.getId());
//        return "redirect:/customers/{agencyId}";
//    }





}
