package com.leiyuan.controller;

import com.leiyuan.entity.Demand;
import com.leiyuan.service.DemandService;
import com.leiyuan.vo.DemandUser;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/demand")
public class DemandController {
    @Autowired
    private DemandService demandService;

    /**
     * 跳转
     *
     * @return 跳转至新增页面
     */
    @RequestMapping("/toSaveDemand")
    public String toSaveDemand() {
        return "/demand";
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
        String demandId = demandService.save(demand);
        return "redirect:/demand/getDemandById/" + demandId;

    }

    /**
     * 根据id获取需求
     *
     * @param demandId 需求id
     * @return 需求展示页面
     */
    //@RequiresRoles("user")
    @ResponseBody
    @RequestMapping("/getDemandById/{demandId}")
    public String getDemandById(@PathVariable("demandId") String demandId, Model model) {
        //Demand demand = demandService.get(demandId);
        //model.addAttribute("demand", demand);
        DemandUser demandUser = demandService.getDemandUser(demandId);
        return demandUser.toString();
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
        return "redirect:/demand/getDemandById/" + demandId;
    }

    /**
     * 获取需求订单列表
     *
     * @param flag  订单状态 0：获取需求状态的订单 1：获取已接单列表 2：获取已完成的列表 4:过期需求订单
     * @param model 想页面传递列表信息
     * @return 跳转至列表展示页面
     */
    @RequiresRoles("user")
    @RequestMapping("/gerDemandList/{flag}")
    public String getDemandList(@PathVariable("flag") int flag, Model model) {
        List<Demand> demandList = demandService.getDemandList(flag);
        model.addAttribute("demandList", demandList);
        return "";
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
        return "";
    }

    /**
     * 根据类型id获取需求列表
     *
     * @param typeId 类型id
     * @param model  想页面传递获取需求列表
     * @return 列表展示页面
     */
    //@ResponseBody
    @RequestMapping("/queryByTypeId/{typeId}")
    public String queryByTypeId(@PathVariable("typeId") String typeId, Model model) {
        List<Demand> demandList = demandService.queryByTypeId(typeId);
        model.addAttribute("demandList", demandList);
        return demandList.toString();
    }
}
