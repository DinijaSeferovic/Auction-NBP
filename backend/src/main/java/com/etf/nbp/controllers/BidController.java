package com.etf.nbp.controllers;

import com.etf.nbp.domains.Bid;
import com.etf.nbp.dto.BidDTO;
import com.etf.nbp.services.BidService;
import com.etf.nbp.services.ProductService;
import com.etf.nbp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class BidController {

    private static final Logger logger = LoggerFactory.getLogger(BidController.class);
    private final BidService bidService;

    private final ProductService productService;

    private final UserService userService;

    public BidController(BidService bidService, ProductService productService, UserService userService) {
        this.bidService = bidService;
        this.productService = productService;
        this.userService = userService;
    }

    /**
     * Places the bid from request if possible and provides appropriate status message
     *
     * @param biddingRequest provided {@link BidDTO} request
     * @return response entity with status message
     */
    @PostMapping("/api/auth/bid")
    public ResponseEntity<?> bidOnProduct(@Valid @RequestBody BidDTO biddingRequest) {
        final Bid bid = new Bid(productService.getProductById(biddingRequest.getProductId()), userService.findById(biddingRequest.getUserId()),
                biddingRequest.getAmount(), LocalDateTime.now());
        final Bid highestBid = bidService.getHighestBid(biddingRequest.getProductId());

        if (highestBid != null && highestBid.getUser().getId().equals(biddingRequest.getUserId()) && highestBid.getAmount() < biddingRequest.getAmount()) {
            return ResponseEntity
                    .badRequest()
                    .body("You cannot outbid yourself!");
        }
        if (biddingRequest.getAmount() < bid.getProduct().getStartPrice()) {
            return ResponseEntity
                    .badRequest()
                    .body("Your bid should not be lower than the start price!");
        }
        if (highestBid != null && highestBid.getAmount() >= biddingRequest.getAmount()) {
            return ResponseEntity
                    .badRequest()
                    .body("There are higher bids than yours. You could give a second try!");
        }
        if (bid.getProduct().getEndDate().isBefore(LocalDateTime.now())) {
            return ResponseEntity
                    .badRequest()
                    .body("This auction has ended!");
        }
        bidService.placeBid(bid);
        return  ResponseEntity.ok("Congrats! You are the highest bidder!");
    }

    /**
     * Gets the highest bid for the product with provided id
     *
     * @param productId id of the product
     * @return highest bid
     */
    @GetMapping("/api/product/{productId}/bids/highest")
    public Bid getHighestBid(@PathVariable UUID productId) {
        return bidService.getHighestBid(productId);
    }

    /**
     * Gets the count of the bids that product with provided id has
     *
     * @param productId id of the product
     * @return count of the bids
     */
    @GetMapping("/api/product/{productId}/bids/count")
    public long getBidCount(@PathVariable UUID productId) {
        return bidService.getBidCount(productId);
    }
}
