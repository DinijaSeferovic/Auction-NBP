package com.etf.nbp.services;

import com.etf.nbp.domains.Location;
import com.etf.nbp.dto.LocationDTO;
import com.etf.nbp.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final UserService userService;

    public LocationService(LocationRepository locationRepository, UserService userService) {
        this.locationRepository = locationRepository;
        this.userService = userService;
    }

    /**
     * Adds new location to the database if it does not exist and updates user location
     *
     * @param locationRequest {@link LocationDTO} information that needs to be saved
     * @param userId user that needs location update
     * @return added location
     */
    public Location addLocationIfNotExist(LocationDTO locationRequest, UUID userId) {
        final Location location = new Location(locationRequest);
        if (!locationRepository.existsByAddressAndCityAndZipCodeAndCountry(location.getAddress(), location.getCity(), location.getZipCode(), location.getCountry())) {
            final Location newLocation = locationRepository.save(location);
            userService.updateUserLocation(newLocation.getId(), userId);
            return newLocation;
        }
        return location;
    }
}
