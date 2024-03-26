package com.etf.nbp.repositories;

import com.etf.nbp.domains.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findByEndDateAfter(LocalDateTime date, Pageable pageable);

    Page<Product> findByPaid(boolean paid, Pageable pageable);

    long countByPaid(boolean paid);

    long countByEndDateAfter(LocalDateTime date);

    Product findTopByEndDateAfterOrderByEndDateAsc(LocalDateTime date);

    Product findById(int id);

    Page<Product> findByEndDateAfterAndCategoryId(LocalDateTime date, int id, Pageable pageable);

    long countBySubcategoryIdAndEndDateAfter(int id, LocalDateTime date);

    Page<Product> findByEndDateAfterAndNameContainingIgnoreCase(LocalDateTime date, String name, Pageable pageable);

    Page<Product> findByEndDateAfterAndCategoryIdAndNameContainingIgnoreCase(LocalDateTime date, int id, String name, Pageable pageable);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE product SET paid=:paid WHERE id=:id", nativeQuery = true)
    void updatePaidStatus(Boolean paid, int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE product SET buyer_id=:userId WHERE id=:id", nativeQuery = true)
    void updateProductBuyer(int userId, int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE product SET end_date=:newEndDate WHERE id=:itemId", nativeQuery = true)
    void updateEndDate(LocalDateTime newEndDate, int itemId);
}