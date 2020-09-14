package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.donation.domain.Donation;

interface DonationRepository extends JpaRepository<Donation, Long> {
}
