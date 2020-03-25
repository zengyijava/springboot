package com.jk.test.mapper;

import com.jk.test.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    @Select("select * from user where name=#{name}")
    User findByName(@Param("name") String name);

    @Select("select * from user ")
    List<User> findAll();

    @Insert("insert into user(name,age) values(#{name},#{age})")
    Integer add(@Param("name") String name, @Param("age") Integer age);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Integer id);

}
