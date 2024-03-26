package com.etf.nbp.domains;

import com.etf.nbp.dto.LocationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Location {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private int id;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String zipCode;

    @Column
    private String state;

    @Column
    private String country;

    public Location(String address, String city, String zipCode, String country) {
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public Location(LocationDTO location) {
        this.address = location.getAddress();
        this.city = location.getCity();
        this.zipCode = location.getZipCode();
        this.country = location.getCountry();
    }
}
