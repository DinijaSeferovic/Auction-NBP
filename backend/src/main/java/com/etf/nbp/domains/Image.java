package com.etf.nbp.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Image {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String data;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
}
