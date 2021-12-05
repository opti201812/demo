package com.example.demo.controller;

import com.example.demo.annotation.Function;
import com.example.demo.entity.Department;
import com.example.demo.entity.TestUser;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class HelloWorldController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    @Function("user")
    public @ResponseBody String say() {
        return "Hello Spring boot!";
    }

    /*
        Post need ajax access
     */
    @PostMapping(path = "/user{id}.html", consumes = "application/json", headers = "token=123")
    public String foo2(Model model, @PathVariable("id") String id) {
        model.addAttribute("username", "testname" + id);
        System.out.println("Post username: " + "testname" + id);
        return "admin/userInfo.html";
    }

    @PostMapping(path = "/saveuser", consumes = "application/json", headers = "token=123")
    public String foo3(Model model, @RequestBody @Validated TestUser user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("Missing parameter!");
        }
        model.addAttribute("username", "testname" + user.id);
        System.out.println("Post username: " + user.name);
        return "admin/userInfo.html";
    }

    /*
        Get access from Browser
     */
    @GetMapping(path = "/u*r{id}.html", produces = MediaType.APPLICATION_JSON_VALUE)
    public String foo(Model model, @PathVariable String id, @RequestParam(name="nick", required = false) String nickname, Date d) {
        System.out.println("Get username: " + "testname" + id);
        System.out.println("nickname: " + nickname);
        System.out.println("Date: " + d.toString());
        Department departmentId = Department.builder().id(1L).name("525").build();
//        userService.addUser(User.builder().name("testname" + id).department(departmentId).createTime(d).build());
        Long userId = Long.parseLong(id);
        System.out.println("User id: " + userId + " " + userService.findIdAndName(userId, nickname).toString());
        model.addAttribute("username", "User id: " + userId + " " + userService.findIdAndName(userId, nickname).toString());
        return "admin/userInfo.html";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yy-MM-dd"));
    }
}
