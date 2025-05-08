package nimap.assignment.service;

import nimap.assignment.entity.Category;
import nimap.assignment.Exception.ResourceNotFoundException;
import nimap.assignment.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // ✅ Create category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // ✅ Get category by ID
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // ✅ Get all categories with pagination
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    // ✅ Update category after validating existence
    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));

        category.setCategoryName(categoryDetails.getCategoryName());
        return categoryRepository.save(category);
    }

    // ✅ Delete category after validating existence
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));

        categoryRepository.delete(category);
    }
}
