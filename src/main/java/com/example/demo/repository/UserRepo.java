package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
@Component
public interface UserRepo  extends JpaRepository<User, Integer>{
  
    User findByIdAndDeleted(int id,int deleted);
    List<User> findByDeleted(int deleted);
}
