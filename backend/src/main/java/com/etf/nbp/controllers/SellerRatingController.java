package com.etf.nbp.controllers;

import com.etf.nbp.services.SellerRatingService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/seller-ratings")
public class SellerRatingController {

    private final SellerRatingService sellerRatingService;

    public SellerRatingController(SellerRatingService sellerRatingService) {
        this.sellerRatingService = sellerRatingService;
    }
}
