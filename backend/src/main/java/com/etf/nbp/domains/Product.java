package com.etf.nbp.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "subcategory_id", referencedColumnName = "id")
    private Subcategory subcategory;

    @Column(nullable = false)
    private String description;

    @Column
    private int sellerId;

    @Column(nullable = false)
    private double startPrice;

    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime startDate;

    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime endDate;

    @Column
    private int buyerId;

    @Column
    private boolean paid;

    @Column
    private double size;

    @Column
    private String color;
}
