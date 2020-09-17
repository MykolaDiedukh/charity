package pl.coderslab.charity.institution.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.institution.InstitutionRepository;
import pl.coderslab.charity.institution.InstitutionService;
import pl.coderslab.charity.institution.domain.Institution;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
class InstitutionServiceImpl implements InstitutionService {

    private final static String ERROR_MESSAGE = "Institution not found with id: ";
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
        return institutionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));

    }

    @Override
    public Long create(Institution institution) {
        Institution save = institutionRepository.save(institution);
        return save.getId();
    }

    @Override
    public Institution update(Institution institution, Long id) {
        Institution institutionById = institutionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
        return institutionRepository.save(institutionById);
    }

    @Override
    public void delete(Long id) {
        Institution institutionById = institutionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
        institutionRepository.delete(institutionById);
    }

}
