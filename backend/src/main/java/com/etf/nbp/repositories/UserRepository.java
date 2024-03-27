package com.etf.nbp.repositories;

import com.etf.nbp.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    User findById(int id);

    Boolean existsByEmail(String email);

    @Query(value = "UPDATE users SET location_id=:locationId WHERE id=:userId", nativeQuery = true)
    void updateUserLocation(int locationId, int userId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET password=:newPassword WHERE email=:email", nativeQuery = true)
    void changePassword(String email, String newPassword);
}