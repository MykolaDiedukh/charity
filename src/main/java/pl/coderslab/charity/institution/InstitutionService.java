package pl.coderslab.charity.institution;

import pl.coderslab.charity.institution.domain.Insitution;

import java.util.List;

public interface InstitutionService {

    List<Insitution> findAll();

    Insitution findById(Long id);

    Insitution create(Insitution insitution);

    Insitution update(Insitution insitution, Long id);

    void delete(Long id);
}
