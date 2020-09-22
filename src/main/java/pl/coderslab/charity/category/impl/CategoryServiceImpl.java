package pl.coderslab.charity.category.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.category.domain.Category;
import pl.coderslab.charity.donation.domain.Donation;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
class CategoryServiceImpl implements CategoryService {

    private final static String ERROR_MESSAGE = "Category not found with id: ";
    private final CategoryRepository categoryRepository;

    CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
    }

    @Override
    public Long create(Category category) {
        Category save = categoryRepository.save(category);
        return save.getId();
    }

    @Override
    public Category update(Category category, Long id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void delete(Long id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(ERROR_MESSAGE + id));
        categoryRepository.delete(existingCategory);
    }
}
