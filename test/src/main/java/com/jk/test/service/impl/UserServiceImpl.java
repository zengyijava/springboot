package com.jk.test.service.impl;

import com.jk.test.bean.User;
import com.jk.test.mapper.UserMapper;
import com.jk.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper UserMapper;

    @Override
    public User findByName(String name) {
        return UserMapper.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return UserMapper.findAll();
    }

    @Override
    public Integer add(String name, Integer age) {
        return UserMapper.add(name, age);
    }

    @Override
    public int insertByMap(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer id) {

    }
}
