package com.etf.nbp.controllers;

import com.etf.nbp.dto.ImageDTO;
import com.etf.nbp.services.ImageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    /**
     * Gets images for the product that has the provided id
     *
     * @param id id of the product
     * @return list of {@link ImageDTO}
     */
    @GetMapping("/{id}")
    public List<ImageDTO> getImagesByProduct(@PathVariable int id) {
        return imageService.getImagesByProductId(id);
    }
}
