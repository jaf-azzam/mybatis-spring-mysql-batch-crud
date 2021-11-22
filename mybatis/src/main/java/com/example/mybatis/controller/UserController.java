package com.example.mybatis.controller;

import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.model.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/rest/users")
    public class UserController {

        private UserMapper userMapper;

        public UserController(UserMapper userMapper) {
            this.userMapper = userMapper;
        }
        @GetMapping("/all")
        public List<Users> getAll(){
            return userMapper.findAll();
        }

        @GetMapping("/insert")
        private List<Users> insert(@RequestBody Users users){

            userMapper.insert((users));

            return userMapper.findAll();

        }
        @GetMapping("/updateUsers")
        private List<Users> updateUsers(@RequestBody Users users)
        {

            userMapper.update(users);
            return userMapper.findAll();
        }
        @GetMapping("/delete")
        private List<Users> delete(@RequestBody Users users)
        {

            userMapper.delete(users);
            return userMapper.findAll();
        }

    }

