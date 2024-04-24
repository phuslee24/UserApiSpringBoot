package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name", length = 255, nullable = false)
    private String userName;
    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "deleted")
    private int deleted = 0;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL) // One-to-one with Address
    @JsonManagedReference
    private UserDetail user_detail;

}