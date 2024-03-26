package com.etf.nbp.services;

import com.etf.nbp.domains.SellerReview;
import com.etf.nbp.repositories.SellerReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerReviewService {

    private final SellerReviewRepository sellerReviewRepository;

    public SellerReviewService(SellerReviewRepository sellerReviewRepository) {
        this.sellerReviewRepository = sellerReviewRepository;
    }

    public List<SellerReview> findAll() {
        return sellerReviewRepository.findAll();
    }

    public SellerReview findById(int id) {
        return sellerReviewRepository.findById(id);
    }
}
