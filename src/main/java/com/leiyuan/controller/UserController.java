package com.leiyuan.controller;

import com.aliyuncs.exceptions.ClientException;
import com.leiyuan.entity.DemandType;
import com.leiyuan.entity.UserRoles;
import com.leiyuan.service.*;
import com.leiyuan.util.SmsDemo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leiyuan.entity.User;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DemandService demandService;
    @Autowired
    private DemandTypeService demandTypeService;
    @Autowired
    private UserRolesService userRolesService;
    @Autowired
    private DiscussService discussService;

    /**
     * 跳转至登录界面
     *
     * @return 登录界面
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "user/login";
    }

    /**
     * 登录方法 后续加入权限框架
     *
     * @param user 输入的用户名密码封装到实体类中
     * @return 跳转至主页或者是返回登陆界面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getNum(), user.getPassword());
        try {
            subject.login(token);
        } catch (Exception e) {
            return "/user/login";
        }
        user = userService.getByNum(user.getNum());
        HttpSession session = request.getSession();
        session.setAttribute("userSession", user);
        return "redirect:/user/toIndex";
    }

    /**
     * 通过验证码进行登陆
     *
     * @param user    包含手机号
     * @param request 更新session
     * @return 重定向至主页
     */
    @RequestMapping(value = "/loginPhone", method = RequestMethod.POST)
    public String loginPhone(User user, HttpServletRequest request) {
        User u = userService.getByPhone(user.getPhone());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(u.getNum(), u.getPassword());
        try {
            subject.login(token);
        } catch (Exception e) {
            return "/user/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("userSession", u);
        return "redirect:/user/toIndex";
    }

    @RequestMapping("/logOut")
    public String logOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/user/toIndex";
    }

    /**
     * 跳转至注册页面
     *
     * @return 用户是否注册过 1为未注册 2为已注册
     */
    @RequestMapping("/toNewUser")
    public String toNewUser() {
        return "user/new";
    }

    @ResponseBody
    @RequestMapping(value = "/verifyEmail/{num}", method = RequestMethod.POST)
    public String verifyEmail(@PathVariable("num") String num) {
        User u = userService.getByNum(num);
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
    public String newUser(User user, HttpServletRequest request) {
        user.setStar(5);
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
        user = userService.getByNum(user.getNum());
        HttpSession session = request.getSession();
        session.setAttribute("userSession", user);
        return "redirect:/user/toIndex";
    }

    /**
     * 获取用户列表
     *
     * @param model 像页面传递获取的所有用户列表
     * @return 跳转至用户管理界面
     */
    @RequiresRoles("admin")//用户拥有admin角色时才能执行该操作
    @RequestMapping(value = "/getUserList/{id}")
    public String getUserList(Model model, @PathVariable("id") String id) {
        List<User> userList = userService.queryAll("from User where id<>'" + id + "'");
        model.addAttribute("userList", userList);
        return "/admin/user";
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
        User user = userService.get(userId);
        userRolesService.deleteRoles(user);
        return "redirect:/discuss/getDiscussListByGetUserId/" + userId;
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

    /**
     * 注册发送验证码
     *
     * @param phone 手机号
     */
    @ResponseBody
    @RequestMapping(value = "/sendCode/{phone}", method = RequestMethod.POST)
    public String sendCode(@PathVariable("phone") String phone, HttpServletRequest request) {
        User u = userService.getByPhone(phone);
        if (u != null) {
            return "0";
        } else {
            HttpSession session = request.getSession();
            String code = null;
            try {
                code = SmsDemo.sendSms(phone);
                session.setAttribute("code", code);
            } catch (ClientException e) {
                e.printStackTrace();
            }
            return code;
        }
    }

    /**
     * 注册发送验证码
     *
     * @param phone 手机号
     */
    @ResponseBody
    @RequestMapping(value = "/loginByPhone/{phone}", method = RequestMethod.POST)
    public String loginByPhone(@PathVariable("phone") String phone, HttpServletRequest request) {
        User u = userService.getByPhone(phone);
        if (u == null) {
            return "0";
        } else {
            String code = null;
            try {
                code = SmsDemo.sendSms(phone);
            } catch (ClientException e) {
                e.printStackTrace();
            }
            System.out.println(code);
            return code;
        }
    }

    @RequestMapping("/toIndex")
    public String toIndex(Model model, HttpServletRequest request) {
        long userNumber = userService.count();
        long demandNumber = demandService.count();
        model.addAttribute("userNumber", userNumber);
        model.addAttribute("demandNumber", demandNumber);
        model.addAttribute("demandTypeNumber", demandTypeService.count());
        model.addAttribute("discussNumber", discussService.count());
        List<DemandType> demandTypeList = demandTypeService.queryAll();
        HttpSession session = request.getSession();
        session.setAttribute("typeList", demandTypeList);
        return "index";
    }

    /**
     * 未经授权进入跳转页面
     *
     * @return 进入跳转界面
     */
    @RequestMapping("/toJump")
    public String toJump() {
        return "jump";
    }

    /**
     * 为用户添加角色
     *
     * @param roles  角色信息
     * @param userId 用户id
     * @return 用户详情界面
     */
    @RequestMapping(value = "/newUserRoles/{userId}", method = RequestMethod.POST)
    public String newUserRoles(UserRoles roles, @PathVariable("userId") String userId) {
        userRolesService.saveOrUpdate(roles);
        return "redirect:/discuss/getDiscussListByGetUserId/" + userId;
    }

    /**
     * 修改个人信息
     *
     * @param user    更改信息
     * @param request 更新session
     * @return 重定向至信息页面
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(User user, HttpServletRequest request) {
        User u = userService.get(user.getId());
        u.setName(user.getName());
        if ("".equals(user.getPassword())) {
            u.setPassword(u.getPassword());
        } else {
            u.setPassword(user.getPassword());
        }
        u.setSex(user.getSex());
        userService.saveOrUpdate(u);
        //修改成功自动进行登陆操作
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(u.getNum(), u.getPassword());
        try {
            subject.login(token);
        } catch (Exception e) {
            return e.getMessage();
        }
        HttpSession session = request.getSession();
        session.setAttribute("userSession", u);
        return "redirect:/discuss/getDiscussListByGetUserId/" + u.getId();
    }
}