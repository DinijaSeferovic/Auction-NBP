package com.etf.nbp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BidDTO {

    private int id;

    private int productId;

    private int userId;

    private double amount;
}
