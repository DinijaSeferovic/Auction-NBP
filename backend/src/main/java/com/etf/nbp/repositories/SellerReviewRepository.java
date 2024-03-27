package com.etf.nbp.repositories;

import com.etf.nbp.domains.SellerReview;
import com.etf.nbp.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerReviewRepository extends JpaRepository<SellerReview, Integer> {

    SellerReview findById(int id);

    List<SellerReview> findAll();

    List<SellerReview> findBySellerId(User sellerId);

    List<SellerReview> findByBuyerId(User buyerId);
}
