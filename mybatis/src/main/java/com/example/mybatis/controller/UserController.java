package com.example.mybatis.controller;

import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        private List<Users> insert(){
            Users users =new Users();
            users.setName("Azzam");
            users.setSalary(50000L);

            userMapper.insert((users));

            return userMapper.findAll();

        }
        @GetMapping("/updateUsers")
        private List<Users> updateUsers()
        {
            Users users=new Users();
            users.setName("Azzam");
            users.setSalary(555L);
            userMapper.update(users);
            return userMapper.findAll();
        }
        @GetMapping("/delete")
        private List<Users> delete()
        {
            Users users=new Users();
            users.setName("Azzam");
            users.setSalary(555L);

            userMapper.delete(users);
            return userMapper.findAll();
        }

    }

