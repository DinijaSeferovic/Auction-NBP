package com.etf.nbp.repositories;

import com.etf.nbp.domains.SellerRating;
import com.etf.nbp.domains.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

    Wishlist findById(int id);

    List<Wishlist> findAll();

    List<Wishlist> findByUserId(int id);
}

