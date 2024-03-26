package com.etf.nbp.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String nameOnCard;

    @Column(nullable = false)
    private String cardNumber;

    @Column
    private Date expirationDate;

    @Column
    private int cvc;

    @OneToOne(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;
}
