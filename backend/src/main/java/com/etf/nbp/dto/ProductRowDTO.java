package com.etf.nbp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRowDTO {
    private int id;

    private String name;

    private String timeLeft;

    private long bidders;

    private long bids;

    private double price;

    private double highestBid;

    private double growthRate;

    private String imagePath;
}
