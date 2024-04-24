package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.userDto;
import com.example.demo.entity.User;

public interface UserServiceInterface {
    public List<User> getAll();
    public User getById(int id);
    public User creatUser(userDto userDto);
    public User putUser(userDto userDto, int id);
    public User deletUser(int id);
}
