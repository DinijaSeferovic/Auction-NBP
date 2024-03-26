package com.etf.nbp.controllers;

import com.etf.nbp.dto.LocationDTO;
import com.etf.nbp.services.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    /**
     * Calls service method for creating location
     * @param location {@link LocationDTO} information that needs to be saved
     * @param userId user that needs location update
     * @return {@link ResponseEntity} with added location
     */
    @PostMapping("/user/{userId}")
    public ResponseEntity<?> addLocationIfNotExist(@RequestBody LocationDTO location, @PathVariable int userId) {
        locationService.addLocationIfNotExist(location, userId);
        return ResponseEntity.ok("Successful adding");
    }
}
