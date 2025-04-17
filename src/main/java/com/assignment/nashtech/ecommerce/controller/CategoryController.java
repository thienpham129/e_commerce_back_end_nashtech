package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.model.Category;
import com.assignment.nashtech.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable int categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("/")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PostMapping("/saveAll")
    public List<Category> createMultipleCategories(@RequestBody List<Category> categories){
        return categoryService.saveAll(categories);
    }

    @PutMapping("/{categoryId}")
    public Category updateCategoryById(@RequestBody Category category, @PathVariable int categoryId) {
        return categoryService.updateCategoryById(categoryId, category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteById(@PathVariable int categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }
}
