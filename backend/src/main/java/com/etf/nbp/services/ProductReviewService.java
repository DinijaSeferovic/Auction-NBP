package com.etf.nbp.services;

import com.etf.nbp.domains.ProductReview;
import com.etf.nbp.repositories.ProductReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewService {

    private final ProductReviewRepository productReviewRepository;

    public ProductReviewService(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }

    public List<ProductReview> findAll() {
        return productReviewRepository.findAll();
    }
}
