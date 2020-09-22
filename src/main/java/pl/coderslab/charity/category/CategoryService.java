package pl.coderslab.charity.category;

import pl.coderslab.charity.category.domain.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Long create(Category category);

    Category update(Category category, Long id);

    void delete(Long id);

}
