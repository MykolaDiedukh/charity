package pl.coderslab.charity.institution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.institution.domain.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
