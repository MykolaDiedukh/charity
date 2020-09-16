package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.institution.InstitutionService;
import pl.coderslab.charity.institution.domain.Institution;

import java.util.List;


@Controller
//@RequiredArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;

    public HomeController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institution", institutionService.findAll());
        return "index";
    }

}
