package pl.coderslab.charity.donation;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.donation.domain.Donation;

import java.util.List;

@Service
public interface DonationService {

    List<Donation> findAll();

    Donation findById(Long id);

    Donation create(Donation donation);

    Donation update(Donation donation, Long id);

    void delete(Long id);
}
