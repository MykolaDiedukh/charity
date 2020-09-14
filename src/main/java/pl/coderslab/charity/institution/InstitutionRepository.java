package pl.coderslab.charity.institution;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.institution.domain.Insitution;

interface InstitutionRepository extends JpaRepository<Insitution, Long> {
}
