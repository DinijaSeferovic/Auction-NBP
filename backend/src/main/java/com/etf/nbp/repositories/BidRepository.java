package com.etf.nbp.repositories;

import com.etf.nbp.domains.Bid;
import com.etf.nbp.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {

    long countByProductId(UUID productId);

    @Query(value = "SELECT DISTINCT Cast(b.user_id as varchar) FROM bid b WHERE b.product_id=:productId", nativeQuery = true)
    List<UUID> findDistinctUserByProductId(UUID productId);

    Bid findFirstByProductIdOrderByAmountDesc(UUID productId);
}
