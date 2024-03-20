package com.etf.nbp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BidDTO {

    private UUID id;

    private UUID productId;

    private UUID userId;

    private Double amount;
}
