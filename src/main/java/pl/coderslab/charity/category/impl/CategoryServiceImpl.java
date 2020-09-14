package pl.coderslab.charity.category.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.category.domain.Category;

import java.util.List;

@Service
class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public Category create(Category category) {
        return null;
    }

    @Override
    public Category update(Category category, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }
}
