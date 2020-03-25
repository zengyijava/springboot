package com.jk.test.controller;

import com.jk.test.bean.User;
import com.jk.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController=@controller+@responseBody
@Controller
public class UserController {
    @Autowired
    private UserService UserService;

    @RequestMapping("/findAll")
    public List<User> FindAll() {

        return UserService.findAll();
    }

    //访问页面
    @GetMapping("/index")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "显示的内容");

        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String Register(@RequestParam("name") String name,
                                 @RequestParam("age") Integer age) {
        Integer user = UserService.add(name, age);
        if (user > 0) {
            return "index";
        } else {
            return "register";
        }

    }
}
