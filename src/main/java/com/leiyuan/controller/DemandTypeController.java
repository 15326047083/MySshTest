package com.leiyuan.controller;

import com.leiyuan.entity.DemandType;
import com.leiyuan.service.DemandTypeService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/demandType")
public class DemandTypeController {
    @Autowired
    private DemandTypeService demandTypeService;

    /**
     * 新增或修改类型信息
     *
     * @param demandType 类型信息
     * @return 重定向至列表
     */
    @RequiresRoles("admin")
    @RequestMapping(value = "/saveOrUpdateDemandType", method = RequestMethod.POST)
    public String saveOrUpdateDemandType(DemandType demandType) {
        demandType.setBuildTime(new Date().toString());
        demandType.setDemandNum(0);
        demandTypeService.saveOrUpdate(demandType);
        return "redirect:/demandType/queryAllDemandType";
    }

    /**
     * 删除类型信息
     *
     * @param demandTypeId 类型ID
     * @return 重定向至列表
     */
    @RequiresRoles("admin")
    @RequestMapping("/deleteDemandType/{demandTypeId}")
    public String deleteDemandType(@PathVariable("demandTypeId") String demandTypeId) {
        demandTypeService.delete(demandTypeId);
        return "redirect:/demandType/queryAllDemandType";
    }

    /**
     * 获取列表
     *
     * @param request 更新session中的值
     * @return 列表展示页面
     */
    @RequiresRoles("admin")
    @RequestMapping("/queryAllDemandType")
    public String queryAllDemandType(HttpServletRequest request) {
        List<DemandType> demandTypeList = demandTypeService.queryAll();
        HttpSession session = request.getSession();
        session.setAttribute("typeList", demandTypeList);
        return "/admin/typelist";
    }

    @RequiresRoles("admin")
    @RequestMapping("/getDemandTypeById/{demandTypeId}")
    public String getDemandTypeById(@PathVariable("demandTypeId") String demandTypeId, Model model) {
        DemandType demandType = demandTypeService.getById(demandTypeId);
        model.addAttribute("demandType", demandType);
        return "";
    }
}
