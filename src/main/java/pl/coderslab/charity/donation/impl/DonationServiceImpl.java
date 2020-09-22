package pl.coderslab.charity.donation.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.donation.DonationRepository;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.donation.domain.Donation;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
class DonationServiceImpl implements DonationService {

    private final static String ERROR_MESSAGE = "Donation not found with id: ";
    private final DonationRepository donationRepository;

    DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }


    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public Donation findById(Long id) {
        return donationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
    }

    @Override
    public Long create(Donation donation) {
        Donation save = donationRepository.save(donation);
        return save.getId();
    }

    @Override
    public Donation update(Donation donation, Long id) {
        Donation existingDonation = donationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
        return donationRepository.save(existingDonation);
    }

    @Override
    public void delete(Long id) {
        Donation existingDonation = donationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
        donationRepository.delete(existingDonation);
    }

    @Override
    public Integer bagsQuantity() {
        return donationRepository.findSumBagsQuantity();
    }

    @Override
    public Long donationQuantity() {
        return donationRepository.count();
    }

}
