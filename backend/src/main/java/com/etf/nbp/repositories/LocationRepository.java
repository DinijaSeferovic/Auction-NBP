package com.etf.nbp.repositories;

import com.etf.nbp.domains.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    Boolean existsByAddressAndCityAndZipCodeAndCountry(String address, String city, String zipCode, String country);
}
