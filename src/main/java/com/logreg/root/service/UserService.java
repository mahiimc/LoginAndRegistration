package com.logreg.root.service;

import com.logreg.root.entity.*;
import com.logreg.root.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService implements IUserService{

    private UserRepository userRepository;


    @Override
    public void addUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> getUsersByCountry(String country) {
        return this.userRepository.findUserByCountry(country);
    }
}
