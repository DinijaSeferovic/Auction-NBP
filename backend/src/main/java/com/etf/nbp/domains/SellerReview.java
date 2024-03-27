package com.etf.nbp.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellerReview {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer_id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller_id;

    @Column
    private String review;
}
