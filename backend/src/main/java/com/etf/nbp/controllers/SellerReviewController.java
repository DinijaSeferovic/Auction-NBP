package com.etf.nbp.controllers;

import com.etf.nbp.services.SellerReviewService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/seller-reviews")
public class SellerReviewController {

    private final SellerReviewService sellerReviewService;

    public SellerReviewController(SellerReviewService sellerReviewService) {
        this.sellerReviewService = sellerReviewService;
    }
}
