package com.example.mybatis.mapper;

import com.example.mybatis.model.Users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from users ")
    List<Users> findAll();

    @Insert("insert into users( name , salary, id)values (#{name},#{salary}, #{id})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(Users users);

    @Update("update users set salary=#{salary} where name=#{name}")
    void update(Users users);

    @Delete("delete from  users where  name =#{name}")
    void delete(Users users);

    @Select("select * from users limit #{limit}")
    Cursor<Users> findAllByLimit(@Param("limit") int limit);
}


