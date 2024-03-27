package com.etf.nbp.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bid {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private double amount;

    @Column
    private LocalDateTime bidDateTime;

    public Bid(Product product, User user, double amount, LocalDateTime bidDateTime) {
        this.product = product;
        this.user = user;
        this.amount = amount;
        this.bidDateTime = bidDateTime;
    }
}
