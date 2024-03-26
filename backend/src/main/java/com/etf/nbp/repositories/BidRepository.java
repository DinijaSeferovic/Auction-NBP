package com.etf.nbp.repositories;

import com.etf.nbp.domains.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {

    long countByProductId(int productId);

    @Query(value = "SELECT DISTINCT Cast(b.user_id as varchar) FROM bid b WHERE b.product_id=:productId", nativeQuery = true)
    List<Integer> findDistinctUserByProductId(int productId);

    Bid findFirstByProductIdOrderByAmountDesc(int productId);
}
