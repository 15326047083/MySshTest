package com.leiyuan.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leiyuan.entity.User;
import com.leiyuan.dao.UserRepository;
import com.leiyuan.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转至登录界面
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 登录方法 后续加入权限框架
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPassword());
        try {

            subject.login(token);
        } catch (Exception e) {
            // TODO: handle exception
            return e.getMessage();
        }
        if (subject.hasRole("user1")) {
            return "you have admin";
        }
        return "you don't have admin";
    }

    /**
     * 跳转至注册页面
     *
     * @return
     */
    @RequestMapping("/toNewUser")
    public String toNewUser() {
        return "new";
    }

    @ResponseBody
    @RequestMapping(value = "/verifyEmail", method = RequestMethod.POST)
    public String verifyEmail(User user) {

        User u = new User();
        u = userService.getByEmail(user.getEmail());
        if (u != null) {
            return "1";
        } else {
            return "2";
        }
    }

    /**
     * 注册方法
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String newUser(User user) {
        userService.saveOrUpdate(user);
        return "new";
    }
}