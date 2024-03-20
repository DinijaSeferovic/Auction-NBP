package com.etf.nbp.dto;

import com.etf.nbp.domains.Category;
import com.etf.nbp.domains.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private UUID id;

    private String name;

    private Category category;

    private Subcategory subcategory;

    private String description;

    private UUID sellerId;

    private Double startPrice;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private UUID buyerId;

    private Boolean paid;
}