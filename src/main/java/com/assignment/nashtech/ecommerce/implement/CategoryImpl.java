package com.assignment.nashtech.ecommerce.implement;

import com.assignment.nashtech.ecommerce.exception.ResourceNotFoundException;
import com.assignment.nashtech.ecommerce.model.Category;
import com.assignment.nashtech.ecommerce.repository.CategoryRepository;
import com.assignment.nashtech.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int categoryId){
        return categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not exist with id: " + categoryId));
    }

    @Override
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategoryById(int categoryId, Category category){
        Optional<Category> categoryExisting = categoryRepository.findById(categoryId);
        if (categoryExisting.isPresent()){
            Category c = categoryExisting.get();
            c.setCategoryName(category.getCategoryName());
            c.setUpdatedAt(category.getUpdatedAt());
            return categoryRepository.save(c);
        }
        return null;
    }

    @Override
    public void deleteCategoryById(int categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
