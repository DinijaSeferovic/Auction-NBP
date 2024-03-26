package com.etf.nbp.services;

import com.etf.nbp.domains.SellerRating;
import com.etf.nbp.repositories.SellerRatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerRatingService {

    private final SellerRatingRepository sellerRatingRepository;

    public SellerRatingService(SellerRatingRepository sellerRatingRepository) {
        this.sellerRatingRepository = sellerRatingRepository;
    }

    public List<SellerRating> findAll() {
        return sellerRatingRepository.findAll();
    }

    public SellerRating findById(int id) {
        return sellerRatingRepository.findById(id);
    }
}
