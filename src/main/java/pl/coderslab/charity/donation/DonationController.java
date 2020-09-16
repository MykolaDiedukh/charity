package pl.coderslab.charity.donation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.donation.domain.Donation;

import java.util.List;

@Controller
@RequestMapping("/donation")
class DonationController {

    private final DonationService donationService;

    DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping
    public List<Donation> findAll(){
        return donationService.findAll();
    }

    @GetMapping("/{id}")
    public Donation findById(@PathVariable Long id){
        return donationService.findById(id);
    }

    @PostMapping
    public Long create(@RequestBody Donation donation){
        return donationService.create(donation);
    }

    @PutMapping("/{id}")
    public Donation update(@RequestBody Donation donation, @PathVariable Long id){
        return donationService.update(donation, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        donationService.delete(id);
    }
}
