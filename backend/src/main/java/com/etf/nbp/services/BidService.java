package com.etf.nbp.services;

import com.etf.nbp.domains.Bid;
import com.etf.nbp.repositories.BidRepository;
import org.springframework.stereotype.Service;


@Service
public class BidService {

    private final BidRepository bidRepository;

    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    /**
     * Gets the number of bids for product that has the provided id
     *
     * @param productId id of the product for which we need the bid count
     * @return bid count
     */
    public long getBidCount(int productId) {
        return bidRepository.countByProductId(productId);
    }

    /**
     * Gets the bid with the highest amount from database
     *
     * @param productId id of the product for which we search the highest bid
     * @return the highest bid
     */
    public Bid getHighestBid(int productId) {
        return bidRepository.findFirstByProductIdOrderByAmountDesc(productId);
    }

    /**
     * Saves the bid into database
     *
     * @param bid the bid we want to save
     */
    public void placeBid(Bid bid) {
        bidRepository.save(bid);
    }
}
