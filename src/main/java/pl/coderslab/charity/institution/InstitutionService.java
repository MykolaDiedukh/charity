package pl.coderslab.charity.institution;

import pl.coderslab.charity.institution.domain.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionService {

    List<Institution> findAll();

    Institution findById(Long id);

    Long create(Institution institution);

    Institution update(Institution institution, Long id);

    void delete(Long id);
}
