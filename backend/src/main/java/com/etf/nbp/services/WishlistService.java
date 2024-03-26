package com.etf.nbp.services;

import com.etf.nbp.domains.Wishlist;
import com.etf.nbp.repositories.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<Wishlist> findAll() {
        return wishlistRepository.findAll();
    }

    public Wishlist findById(int id) {
        return wishlistRepository.findById(id);
    }

}
