package com.etf.nbp.services;

import com.etf.nbp.dto.CategoryDTO;
import com.etf.nbp.repositories.CategoryRepository;
import com.etf.nbp.utils.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final MapperUtil mapper = new MapperUtil();

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Gets the first 9 categories from database
     *
     * @return list of {@link CategoryDTO}
     */
    public List<CategoryDTO> getMainCategories() {
        return mapper.convertListEntityToDto(categoryRepository.findTop9ByOrderByIdAsc(), CategoryDTO.class);
    }

    /**
     * Gets all the categories from database
     *
     * @return list of {@link CategoryDTO}
     */
    public List<CategoryDTO> getCategories() {
        return mapper.convertListEntityToDto(categoryRepository.findAll(), CategoryDTO.class);
    }
}