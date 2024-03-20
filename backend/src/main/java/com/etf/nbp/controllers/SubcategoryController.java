package com.etf.nbp.controllers;

import com.etf.nbp.dto.SubcategoryDTO;
import com.etf.nbp.services.SubcategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/subcategories")
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    /**
     * Calls service method to get subcategories that have the provided category id
     *
     * @param id id of the category
     * @return list of {@link SubcategoryDTO}
     */
    @GetMapping("/categories/{id}")
    public List<SubcategoryDTO> getSubcategoriesByCategoryId(@PathVariable UUID id) {
        return subcategoryService.getSubcategoriesByCategoryId(id);
    }
}
