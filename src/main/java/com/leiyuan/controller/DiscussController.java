package com.leiyuan.controller;

import com.leiyuan.entity.Discuss;
import com.leiyuan.service.DiscussService;
import com.leiyuan.vo.DiscussUser;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/discuss")
public class DiscussController {
    @Autowired
    private DiscussService discussService;

    @RequiresRoles("user")
    @RequestMapping(value = "/saveDiscuss", method = RequestMethod.POST)
    public String saveDiscuss(Discuss discuss) {
        discussService.save(discuss);
        return "redirect:/discuss/getDiscussListByGetUserId/" + discuss.getGetUserId();
    }

    @RequiresRoles("user")
    @RequestMapping("/getDiscussListByGetUserId/{getUserId}")
    public String getDiscussListByGetUserId(@PathVariable("getUserId") String getUserId) {
        List<DiscussUser> discussUserList = discussService.getDiscussList(getUserId);
        return discussUserList.toString();
    }
}
