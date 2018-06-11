package com.leiyuan.controller;

import com.leiyuan.entity.Demand;
import com.leiyuan.entity.DemandType;
import com.leiyuan.entity.User;
import com.leiyuan.service.DemandService;
import com.leiyuan.service.DemandTypeService;
import com.leiyuan.service.DiscussService;
import com.leiyuan.service.UserService;
import com.leiyuan.vo.DemandUser;
import com.leiyuan.vo.DiscussUser;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/demand")
public class DemandController {
    @Autowired
    private DemandService demandService;

    @Autowired
    private UserService userService;

    @Autowired
    private DiscussService discussService;

    @Autowired
    private DemandTypeService demandTypeService;

    /**
     * 跳转
     *
     * @return 跳转至新增页面
     */
    @RequiresRoles("user")
    @RequestMapping("/toSaveDemand")
    public String toSaveDemand() {
        return "/demand/new";
    }

    /**
     * 发布需求方法
     *
     * @param demand 需求详情
     * @return 重定向至根据id获取需求详情
     */
    @RequiresRoles("user")
    @RequestMapping(value = "/saveDemand", method = RequestMethod.POST)
    public String saveDemand(Demand demand) {
        demand.setStartTime(new Date().toString());
        String demandId = demandService.save(demand);
        return "redirect:/demand/getDemandById/" + demandId;

    }

    /**
     * 根据id获取需求
     *
     * @param demandId 需求id
     * @return 需求展示页面
     */
    @RequiresRoles("user")
    @RequestMapping("/getDemandById/{demandId}")
    public String getDemandById(@PathVariable("demandId") String demandId, Model model) {
        //Demand demand = demandService.get(demandId);
        //model.addAttribute("demand", demand);
        DemandUser demandUser = demandService.getDemandUser(demandId);
        model.addAttribute("d", demandUser);
        return "/demand/demand";
    }

    /**
     * 服务商接单（放弃订单）方法
     *
     * @param demandId  需求订单id
     * @param setUserId 服务商id 如果setUserId为null 则为放弃订单
     * @return 重定向至需求详情方法
     */
    @RequiresRoles("user")
    @RequestMapping("/takeDemand/{demandId}/{setUserId}")
    public String takeDemand(@PathVariable("demandId") String demandId, @PathVariable("setUserId") String setUserId) {
        demandService.takeDemand(demandId, setUserId);
        if ("null".equals(setUserId)) {
            return "redirect:/demand/gerDemandList/0";
        }
        return "redirect:/demand/getDemandById/" + demandId;
    }

    /**
     * 获取需求订单列表
     *
     * @param flag  订单状态 0：获取需求状态的订单 1：获取已接单列表 2：获取已完成的列表 4:过期需求订单
     * @param model 想页面传递列表信息
     * @return 跳转至列表展示页面
     */
    @RequestMapping("/gerDemandList/{flag}")
    public String getDemandList(@PathVariable("flag") int flag, Model model) {
        List<Demand> demandList = demandService.getDemandList(flag);
        model.addAttribute("demandList", demandList);
        String title;
        if (flag == 0) {
            title = "全部需求列表";
        } else if (flag == 2) {
            title = "完成案例";
        } else if (flag == 1) {
            title = "进行中需求列表";
        } else {
            title = "过期需求列表";
        }
        model.addAttribute("title", title);
        return "/demand/list";
    }

    /**
     * 获取与我有关的需求列表
     *
     * @param userId 当前登陆用户的id
     * @param flag   set：我发布的需求信息 get：我接受的需求订单
     * @param model  向页面传递获取的列表
     * @return 列表展示页面
     */
    @RequiresRoles("user")
    @RequestMapping("/getMyDemandList/{userId}/{flag}")
    public String getMyDemandList(@PathVariable("userId") String userId, @PathVariable("flag") String flag, Model
            model) {
        List<Demand> list = demandService.getMyDemandList(userId, flag);
        String title;
        if ("get".equals(flag)) {
            title = "我接受的需求订单";
        } else {
            title = "我发布的需求订单";
        }
        model.addAttribute("demandList", list);
        model.addAttribute("title", title);
        return "/demand/list";
    }

    /**
     * 根据类型id获取需求列表
     *
     * @param typeId 类型id
     * @param model  想页面传递获取需求列表
     * @return 列表展示页面
     */
    @RequestMapping("/queryByTypeId/{typeId}")
    public String queryByTypeId(@PathVariable("typeId") String typeId, Model model) {
        DemandType demandType = demandTypeService.getById(typeId);
        List<Demand> demandList = demandService.queryByTypeId(typeId);
        model.addAttribute("demandList", demandList);
        model.addAttribute("title", demandType.getName() + "类别下的订单");
        return "/demand/list";
    }

    /**
     * 删除服务需求
     *
     * @param id     订单id
     * @param userId 当前用户id
     * @return 重定向至我发布的订单
     */
    @RequiresRoles("user")
    @RequestMapping("/delete/{userId}/{id}")
    public String delete(@PathVariable("id") String id, @PathVariable("userId") String userId) {
        demandService.delete(id);
        return "redirect:/demand/getMyDemandList/" + userId + "/set";
    }

    /**
     * 需求商确认订单已完成
     *
     * @param id     订单ID
     * @param userId 当前用户ID
     * @return 跳转至服务商评论页面
     */
    @RequiresRoles("user")
    @RequestMapping("/finishDemand/{id}/{userId}")
    public String finishDemand(@PathVariable("id") String id, @PathVariable("userId") String userId, Model model) {

        Demand demand = demandService.get(id);
        if (demand.getFlag() != 2)
            model.addAttribute("flag", 1);
        demand.setFlag(2);
        demandService.saveOrUpdate(demand);
        User u = userService.get(demand.getGetUserId());
        List<DiscussUser> discussUserList = discussService.getDiscussList(demand.getGetUserId());
        model.addAttribute("discussNum", discussService.countByGetUserId(demand.getGetUserId()));
        model.addAttribute("discussUserList", discussUserList);
        model.addAttribute("getDiscussUser", u);
        return "/user/discuss";
    }

    /**
     * 模糊查询
     *
     * @param info  查询内容
     * @param model 传递结果集
     * @return 展示页面
     */
    @RequestMapping("/searchByInfo")
    public String searchByInfo(@RequestParam("info") String info, Model model) {
        List<Demand> demandList = demandService.searchByInfo(info);
        String title = "搜索结果";
        model.addAttribute("title", title);
        model.addAttribute("demandList", demandList);
        return "/demand/list";
    }

    /**
     * 需求管理
     *
     * @param model 传递结果集
     * @return 结果展示
     */
    @RequiresRoles("admin")
    @RequestMapping("/adminGetAllList")
    public String adminGetAllList(Model model) {
        List<Demand> demandList = demandService.queryAll();
        model.addAttribute("demandList", demandList);
        return "/admin/demandlist";
    }

    /**
     * 需求删除
     *
     * @param id 需求ID
     * @return 重定向至需求管理
     */
    @RequiresRoles("admin")
    @RequestMapping(value = "/adminDelete/{id}")
    public String adminDelete(@PathVariable("id") String id) {
        demandService.delete(id);
        return "redirect:/demand/adminGetAllList";
    }

    @RequiresRoles("admin")
    @RequestMapping("/adminGet/{demandId}")
    public String adminGet(@PathVariable("demandId") String demandId, Model model) {
        DemandUser demandUser = demandService.getDemandUser(demandId);
        model.addAttribute("d", demandUser);
        return "/admin/demand";
    }
}
