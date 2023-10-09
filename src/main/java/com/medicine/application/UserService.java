package com.medicine.application;

import com.medicine.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean existsByUserEmail(String email) {
        Optional<User> userAccount = userRepository.findByEmail(email);
        return userAccount.isPresent();
    }
    public boolean isLoginEmailMatchPassword(String loginEmail,String loginPassword){
        Optional<User> userAccount = userRepository.findByEmail(loginEmail);
        if (userAccount.orElse(null) != null) {
            return userAccount.get().getPassword().equals(loginPassword);
        }
        return false;
    }

    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }
}