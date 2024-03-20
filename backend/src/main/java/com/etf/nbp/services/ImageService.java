package com.etf.nbp.services;

import com.etf.nbp.dto.ImageDTO;
import com.etf.nbp.repositories.ImageRepository;
import com.etf.nbp.utils.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    private final MapperUtil mapper = new MapperUtil();

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    /**
     * Gets images for the product with provided id from database
     *
     * @param id id of the product
     * @return list of {@link ImageDTO}
     */
    public List<ImageDTO> getImagesByProductId(UUID id) {
        return mapper.convertListEntityToDto(imageRepository.findByProductId(id), ImageDTO.class);
    }
}