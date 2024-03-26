package com.etf.nbp.services;

import com.etf.nbp.domains.User;
import com.etf.nbp.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Determines if user exists in the database
     *
     * @param email provided email of the user
     * @return boolean value
     */
    public Boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    /**
     * Saves the user into database
     *
     * @param user provided user
     */
    public void createAccount(User user) {
        userRepository.save(user);
    }

    /**
     * Gets all users from database
     *
     * @return found users
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Gets user by provided id
     *
     * @param id provided id
     * @return found user
     */
    public User findById(int id) {
        return userRepository.findById(id);
    }

    /**
     * Gets user that have the provided email if exists
     *
     * @param email provided email
     * @return user if exists
     */
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Saves or updates the provided user
     *
     * @param user provided user
     * @return saved user
     */
    public User saveOrUpdate(User user) {
        return userRepository.saveAndFlush(user);
    }

    /**
     * Gets user that have the provided username
     *
     * @param email email as a username
     * @return built user
     * @throws UsernameNotFoundException  Signals that the username is not found
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
        return UserDetailsImpl.build(user);
    }

    public void updateUserLocation(int locationId, int userId) {
        userRepository.updateUserLocation(locationId, userId);
    }

    public void changePassword(String email, String password) {
        userRepository.changePassword(email, password);
    }
}
