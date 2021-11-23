package com.example.mybatis.controller;

import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.model.Users;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/users")
public class UserController {

//        @Autowired
        private UserMapper userMapper;

        public UserController(UserMapper um){
            this.userMapper = um;
        }

        @GetMapping("/all")
        public List<Users> getAll(){
            return userMapper.findAll();
        }


        @GetMapping("/all/{limit}")
        @Transactional
        public void getAllUsersByStream(@PathVariable int limit){

            try(Cursor<Users> cursor = userMapper.findAllByLimit(limit)) {
                cursor.forEach(users -> {
                    System.out.println(users.getName());
                });
            }
            catch(Exception exception){
                exception.printStackTrace();
            }
    }

        @GetMapping("/insert")
        private List<Users> insert(@RequestBody Users users){

            userMapper.insert(users);

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

