package com.assignment.nashtech.ecommerce.service;

import com.assignment.nashtech.ecommerce.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    Category getCategoryById(int categoryId);

    Category saveCategory(Category category);

    Category updateCategoryById(int categoryId, Category category);

    void deleteCategoryById(int categoryId);
}
