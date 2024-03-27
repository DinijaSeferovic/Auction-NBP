package com.etf.nbp.domains;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellerRating {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyerId;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User sellerId;

    @Column
    private String rating;
}
