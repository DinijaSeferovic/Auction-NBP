package com.etf.nbp.services;

import com.etf.nbp.dto.SubcategoryDTO;
import com.etf.nbp.repositories.SubcategoryRepository;
import com.etf.nbp.utils.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    private final MapperUtil mapper = new MapperUtil();

    public SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    /**
     * Gets all subcategories that have the provided category id
     *
     * @param categoryId id of the category
     * @return list of {@link SubcategoryDTO}
     */
    public List<SubcategoryDTO> getSubcategoriesByCategoryId(int categoryId) {
        return mapper.convertListEntityToDto(subcategoryRepository.findByCategoryId(categoryId), SubcategoryDTO.class);
    }
}