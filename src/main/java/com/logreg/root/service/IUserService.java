package com.logreg.root.service;

import com.logreg.root.entity.User;

import java.util.List;

public interface IUserService {
    public void addUser(User user);
    public List<User> getAllUsers();
    public  List<User> getUsersByCountry(String country);
}
