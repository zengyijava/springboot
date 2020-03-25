package com.jk.test;

import com.jk.test.bean.User;
import com.jk.test.mapper.UserMapper;
import com.jk.test.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
class TestApplicationTests {
    @Autowired
    private UserMapper UserMapper;
    @Autowired
    private UserService UserService;

    @Test
    void TestAdd() {
        UserService.add("张三", 21);
        //UserMapper.add("张三", 21);
    }

    @Test
    void TestInsertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "jk");
        map.put("age", 28);
        UserMapper.insertByMap(map);
    }

    @Test
    void TestFindByName() {

        User user = UserMapper.findByName("sam");
        Assert.assertEquals(22, user.getAge().intValue());
    }

    @Test
    void TestfindAll() {
        List<User> list = UserMapper.findAll();
        for (User user : list) {
            System.out.println(user.getName());
        }
    }

    @Test
    void TestUpdate() {
        User user = new User();
        user.setName("sam");
        user.setAge(12);
        UserMapper.update(user);

    }

    @Test
    void TestDelete() {
        UserMapper.delete(15);

    }


}
