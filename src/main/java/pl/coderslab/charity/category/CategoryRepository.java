package pl.coderslab.charity.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.category.domain.Category;

@Repository
interface CategoryRepository extends JpaRepository<Category, Long> {
}
