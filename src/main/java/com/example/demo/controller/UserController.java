package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.userDto;
import com.example.demo.entity.User;
import com.example.demo.services.UserServices;
import com.example.demo.utils.HttpException;
import com.example.demo.utils.ResponseData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServices us;

    @GetMapping()
    public ResponseEntity<ResponseData<List<User>>> getList() {
        List<User> users = us.getAll();
        BaseController<List<User>> b = new BaseController<>();
        return b.success(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<User>> getById(@PathVariable("id") int id) {

        BaseController<User> c = new BaseController<>();
        try {

            User user = us.getById(id);
            if (user == null) {
                throw new HttpException(404, "not found in database");
            }
            return c.success(user);
        } catch (HttpException e) {
            return c.error(null, e.StatusCode, e.message);
        } catch (Exception ex) {
            return c.error(null, 500, null);
        }
    }

    @PostMapping("")
    public ResponseEntity<ResponseData<User>> postMethodName(@RequestBody userDto userDto) {

        BaseController<User> c = new BaseController<>();
        try {
            User user = us.creatUser(userDto);
            return c.success(user);
        } catch (Exception ex) {
            return c.error(null, 404, null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseData<User>> putMethodName(@PathVariable int id, @RequestBody userDto userDto) {
        BaseController<User> c = new BaseController<>();
        try {
            User user = us.putUser(userDto, id);
            return c.success(user);
        } catch (Exception ex) {
            return c.error(null, 404, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<User>> putMethodName(@PathVariable int id) {
        BaseController<User> c = new BaseController<>();
        try {
            User user = us.deletUser(id);
            if (user == null) {
                throw new HttpException(404, "not found data");
            }
            return c.success(user);
        } catch (HttpException e) {
            return c.error(null, e.getStatusCode(), e.message);
        } catch (Exception ex) {
            return c.error(null, 500, ex.getMessage());
        }
    }

}
