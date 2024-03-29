package com.etf.nbp.repositories;

import com.etf.nbp.domains.SellerRating;
import com.etf.nbp.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRatingRepository extends JpaRepository<SellerRating, Integer> {

    SellerRating findById(int id);

    List<SellerRating> findAll();

    List<SellerRating> findBySellerId(User sellerId);

    List<SellerRating> findByBuyerId(User buyerId);
}
