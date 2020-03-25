package com.jk.test.service;

import com.jk.test.bean.User;


import java.util.List;
import java.util.Map;

public interface UserService {
    User findByName(String name);

    List<User> findAll();

    Integer add(String name, Integer age);

    int insertByMap(Map<String, Object> map);

    void update(User user);

    void delete(Integer id);

}
