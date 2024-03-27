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
public class Image {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String data;

    @Column(nullable = false)
    private String imagePath;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
}
