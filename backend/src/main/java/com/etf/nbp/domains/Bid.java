package com.etf.nbp.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bid {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private Double amount;

    @Column
    private LocalDateTime bidDateTime;

    public Bid(Product product, User user, Double amount, LocalDateTime bidDateTime) {
        this.product = product;
        this.user = user;
        this.amount = amount;
        this.bidDateTime = bidDateTime;
    }
}
