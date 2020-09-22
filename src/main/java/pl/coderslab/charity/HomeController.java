package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.donation.domain.Donation;
import pl.coderslab.charity.institution.InstitutionService;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;

    public HomeController(InstitutionService institutionService, DonationService donationService, CategoryService categories) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categories;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institution", institutionService.findAll());
        model.addAttribute("given-bags", donationService.bagsQuantity());
        model.addAttribute("donated-gifts", donationService.donationQuantity());
        return "index";
    }

/*    @RequestMapping("/form")
    public String formAction(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("donation", new Donation());
        return "form";
    }*/

//    @RequestMapping("/form")
    @GetMapping("form")
    public String formAction(Model model){
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("institution", institutionService.findAll());
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("form")
    public String makeDonationPost(@ModelAttribute Donation donation){
        donationService.create(donation);
        return "redirect:/confirm";
    }

    @GetMapping("confirm")
    public String donationConfirm(){
        return "form-confirmation";
    }

}
