package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.userDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserServices implements UserServiceInterface {
    @Autowired
    UserRepo uRepo;

    @Override
    public List<User> getAll() {
        return uRepo.findByDeleted(0);
    }

    @Override
    public User getById(int id) {
        return uRepo.findByIdAndDeleted(id, 0);
    }

    @Override
    public User creatUser(userDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        return uRepo.save(user);

    }

    @Override
    public User putUser(userDto userDto, int id) {
        User user = uRepo.findById(id).get();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        uRepo.save(user);
        return user;
    }

    @Override
    public User deletUser(int id) {

        User user = uRepo.findById(id).get();
        user.setDeleted(1);
        uRepo.save(user);
        return user;

    }
}
