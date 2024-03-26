package com.etf.nbp.dto;

import com.etf.nbp.domains.Category;
import com.etf.nbp.domains.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private int id;

    private String name;

    private Category category;

    private Subcategory subcategory;

    private String description;

    private int sellerId;

    private double startPrice;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int buyerId;

    private boolean paid;
}