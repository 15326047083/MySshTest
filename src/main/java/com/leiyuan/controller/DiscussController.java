package com.leiyuan.controller;

import com.leiyuan.entity.Discuss;
import com.leiyuan.entity.User;
import com.leiyuan.entity.UserRoles;
import com.leiyuan.service.DiscussService;
import com.leiyuan.service.UserRolesService;
import com.leiyuan.service.UserService;
import com.leiyuan.vo.DiscussUser;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/discuss")
public class DiscussController {
    @Autowired
    private DiscussService discussService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRolesService rolesService;

    /**
     * 新增评论
     * 需要有user角色
     *
     * @param discuss 评论详情
     * @return 重定向至该用户评论列表
     */
    @RequiresRoles("user")
    @RequestMapping(value = "/saveDiscuss", method = RequestMethod.POST)
    public String saveDiscuss(Discuss discuss) {
        discuss.setDate(new Date().toString());
        discussService.save(discuss);
        List<Long> longs = discussService.getStarListByGetUserId(discuss.getGetUserId());
        int Mean = 0;
        int sum = 0;
        for (int i = 0; i < longs.size(); i++) {
            sum = sum + Integer.parseInt(longs.get(i) + "");
        }
        Mean = sum / longs.size();
        User user = userService.get(discuss.getGetUserId());
        user.setStar(Mean);
        userService.saveOrUpdate(user);
        return "redirect:/discuss/getDiscussListByGetUserId/" + discuss.getGetUserId();
    }

    /**
     * 根据被评论用户获取该用户评论列表
     * 需要有user角色
     *
     * @param getUserId 被评论用户
     * @param model     向页面传递列表
     * @return 跳转至列表页面
     */
    @RequiresRoles("user")
    @RequestMapping("/getDiscussListByGetUserId/{getUserId}")
    public String getDiscussListByGetUserId(@PathVariable("getUserId") String getUserId, Model model) {
        User u = userService.get(getUserId);
        List<DiscussUser> discussUserList = discussService.getDiscussList(getUserId);
        List<UserRoles> rolesList = rolesService.queryByStudentNum(u.getNum());
        model.addAttribute("discussNum", discussService.countByGetUserId(getUserId));
        model.addAttribute("discussUserList", discussUserList);
        model.addAttribute("getDiscussUser", u);
        model.addAttribute("rolesList", rolesList);
        return "/user/discuss";
    }

    /**
     * 根据id删除评论
     *
     * @param discussId 评论id
     * @return 重定向至列表方法
     */
    @RequiresRoles("admin")
    @RequestMapping("/deleteDiscussById/{discussId}")
    public String deleteDiscussById(@PathVariable("discussId") String discussId) {
        discussService.deleteDiscussById(discussId);
        return "redirect:/discuss/getDiscussList";
    }

    /**
     * 获取全部评论列表
     *
     * @return 列表页面
     */
    @RequiresRoles("admin")
    @RequestMapping("/getDiscussList")
    public String getDiscussList() {
        List<DiscussUser> discussUserList = discussService.queryAllList();
        return "/user/discuss";
    }

}
