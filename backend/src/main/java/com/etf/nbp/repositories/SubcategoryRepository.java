package com.etf.nbp.repositories;

import com.etf.nbp.domains.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {
    List<Subcategory> findByCategoryId(UUID id);
}