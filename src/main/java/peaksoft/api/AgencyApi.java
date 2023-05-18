package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.Agency;
import peaksoft.service.AgencySe;

@Controller
@RequestMapping("/agencies")
@RequiredArgsConstructor
public class AgencyApi {

    private final AgencySe agencySe;

    @GetMapping
    public String getAllAgency(Model model){
        model.addAttribute("agencies",agencySe.getAllAgency());
        return "agency/agenciess";
    }

    @GetMapping("/new")
    public String createAgency(Model model){
        model.addAttribute("newAgency",new Agency());
        return "agency/newAgency";
    }

//    @PostMapping
//    public String saveAgency(@ModelAttribute(""))

}
