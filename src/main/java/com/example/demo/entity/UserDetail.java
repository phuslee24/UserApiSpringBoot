package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_detail")
@Getter
@Setter
public class UserDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "address")
    public String address;
    @Column(name = "phone_number")
    public String phone_number;
    @Column(name = "email")
    public String email;

    @JoinColumn(name = "user_id") // Foreign key in Address referencing User
    @OneToOne(fetch = FetchType.LAZY) // Optional, consider lazy loading for performance
    @JsonManagedReference
    @JsonIgnore
    public User user;

}
