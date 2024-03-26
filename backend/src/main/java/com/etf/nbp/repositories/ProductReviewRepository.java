package com.etf.nbp.repositories;

import com.etf.nbp.domains.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {

    ProductReview findById(int id);

    List<ProductReview> findAll();

    List<ProductReview> findByProductId(int id);
}
