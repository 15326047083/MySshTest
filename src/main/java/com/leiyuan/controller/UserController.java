package com.leiyuan.controller;

import com.leiyuan.entity.UserRoles;
import com.leiyuan.service.UserRolesService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leiyuan.entity.User;
import com.leiyuan.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRolesService userRolesService;

    /**
     * 跳转至登录界面
     *
     * @return 登录界面
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 登录方法 后续加入权限框架
     *
     * @param user 输入的用户名密码封装到实体类中
     * @return 跳转至主页或者是返回登陆界面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user , HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getNum(), user.getPassword());
        try {

            subject.login(token);
        } catch (Exception e) {
            return e.getMessage();
        }
        user=userService.getByNum(user.getNum());
        HttpSession session=request.getSession();
        session.setAttribute("userSession",user);
        return "new";
    }

    /**
     * 跳转至注册页面
     *
     * @return 用户是否注册过 1为未注册 2为已注册
     */
    @RequestMapping("/toNewUser")
    public String toNewUser() {
        return "new";
    }

    @ResponseBody
    @RequestMapping(value = "/verifyEmail", method = RequestMethod.POST)
    public String verifyEmail(User user) {
        User u = userService.getByNum(user.getNum());
        if (u != null) {
            return "1";
        } else {
            return "2";
        }

    }

    /**
     * 注册方法
     *
     * @param user 实体类信息
     * @return 跳转页面
     */
    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String newUser(User user) {
        userService.saveOrUpdate(user);
        //赋予该账号角色信息
        UserRoles userRoles = new UserRoles(user.getNum(), "user");
        userRolesService.saveOrUpdate(userRoles);
        //注册成功自动进行登陆操作
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getNum(), user.getPassword());
        try {

            subject.login(token);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "跳转至主页";
    }

    /**
     * 获取用户列表
     *
     * @param model 像页面传递获取的所有用户列表
     * @return 跳转至用户管理界面
     */
    @RequiresRoles("admin")//用户拥有admin角色时才能执行该操作
    @RequestMapping(value = "/getUserList")
    public String getUserList(Model model) {
        List<User> userList = userService.queryAll();
        model.addAttribute("userList", userList);
        return "管理员用户管理界面";
    }

    /**
     * 删除用户
     *
     * @param userId 通过链接传来的用户id
     * @return 重定向至用户管理界面
     */
    @RequiresRoles("admin")
    @RequiresPermissions("user:delete")//拥有admin角色且拥有用户的删除权限才能执行该操作
    @RequestMapping(value = "/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        userService.delete(userId);
        return "redirect:/user/getUserList";
    }

    /**
     * 根据用户id获取用户详情
     *
     * @param userId 用户id
     * @param model  向页面返回用户详细信息
     * @return 跳转至用户详情展示页面
     */
    @RequiresRoles("user")//拥有user角色的用户可访问该方法
    @RequestMapping(value = "/getUserById/{userId}")
    public String getUserById(@PathVariable("userId") String userId, Model model) {
        User user = userService.get(userId);
        model.addAttribute("getUser", user);
        return "跳转至展示用户详情页面";
    }
}