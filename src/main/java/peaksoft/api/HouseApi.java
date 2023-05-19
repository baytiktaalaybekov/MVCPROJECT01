package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.House;
import peaksoft.service.HouseSe;

@Controller
@RequestMapping("{agencyId}/houses")
@RequiredArgsConstructor
public class HouseApi {

    private final HouseSe houseSe;

    @GetMapping()
    public String getAllHouse (@PathVariable Long agencyId, Model model){
        model.addAttribute("house",houseSe.getAllHouse(agencyId));
        return "house/houses";
    }
    @GetMapping("/new")
    public String createHouse(Model model, @PathVariable("id") Long agencyId){
        model.addAttribute("newHouse", new House());
        model.addAttribute("agencyId", agencyId);
        return "house/newHouse";
    }





}
