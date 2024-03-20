package com.etf.nbp.controllers;

import com.etf.nbp.dto.CategoryDTO;
import com.etf.nbp.services.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Calls service method to get main categories from database
     *
     * @return list of {@link CategoryDTO}
     */
    @GetMapping("/main")
    public List<CategoryDTO> getMainCategories() {
        return categoryService.getMainCategories();
    }

    /**
     * Calls service method to get all categories from database
     *
     * @return list of {@link CategoryDTO}
     */
    @GetMapping
    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories();
    }
}
