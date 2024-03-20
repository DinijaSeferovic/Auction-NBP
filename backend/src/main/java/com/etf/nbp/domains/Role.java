package com.etf.nbp.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
