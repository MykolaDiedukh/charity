package pl.coderslab.charity.institution.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.institution.InstitutionRepository;
import pl.coderslab.charity.institution.InstitutionService;
import pl.coderslab.charity.institution.domain.Institution;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution findById(Long id) {
        return institutionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Institution not found with id: " + id));

    }

    @Override
    public Long create(Institution institution) {
        Institution save = institutionRepository.save(institution);
        return save.getId();
    }

    @Override
    public Institution update(Institution institution, Long id) {
        Institution institutionById = institutionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Institution not found with id: " + id));
        return institutionRepository.save(institutionById);
    }

    @Override
    public void delete(Long id) {
        Institution institutionById = institutionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Institution not found with id: " + id));
        institutionRepository.delete(institutionById);
    }
}
