package com.etf.nbp.services;

import com.etf.nbp.domains.User;
import com.etf.nbp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Gets all users from database
     *
     * @return found users
     */
    public User findById(Integer id) {
        return userRepository.getById(id);
    }

}
