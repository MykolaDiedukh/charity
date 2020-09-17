package pl.coderslab.charity.donation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.donation.converter.DonationMapper;
import pl.coderslab.charity.donation.domain.DonationDTO;

import java.util.List;

@Controller
@RequestMapping("/donation")
class DonationController {

    private final DonationService donationService;

    DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping
    public List<DonationDTO> findAll() {
        return DonationMapper
                .INSTANCE
                .toDTOList(donationService.findAll());
    }

    @GetMapping("/{id}")
    public DonationDTO findById(@PathVariable Long id) {
        return DonationMapper
                .INSTANCE
                .toDTO(donationService.findById(id));
    }

    @PostMapping
    public Long create(@RequestBody DonationDTO donationDTO) {
        return donationService.create(DonationMapper
                .INSTANCE
                .fromDTO(donationDTO));
    }

    @PutMapping("/{id}")
    public DonationDTO update(@RequestBody DonationDTO donationDTO, @PathVariable Long id) {
        return DonationMapper
                .INSTANCE
                .toDTO(donationService.update(DonationMapper
                        .INSTANCE
                        .fromDTO(donationDTO), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        donationService.delete(id);
    }
}
