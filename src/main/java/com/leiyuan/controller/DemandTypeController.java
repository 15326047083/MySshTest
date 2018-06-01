package com.leiyuan.controller;

import com.leiyuan.entity.DemandType;
import com.leiyuan.service.DemandTypeService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/demandType")
public class DemandTypeController {
    @Autowired
    private DemandTypeService demandTypeService;

    @RequiresRoles("admin")
    @RequestMapping(value = "/saveOrUpdateDemandType")
    public String saveOrUpdateDemandType(DemandType demandType) {
        demandTypeService.saveOrUpdate(demandType);
        return "";
    }

    @RequiresRoles("admin")
    @RequestMapping("/deleteDemandType/{demandTypeId}")
    public String deleteDemandType(@PathVariable("demandTypeId") String demandTypeId) {
        demandTypeService.delete(demandTypeId);
        return "";
    }

    @RequestMapping("/queryAllDemandType")
    public String queryAllDemandType(Model model) {
        List<DemandType> demandTypeList = demandTypeService.queryAll();
        model.addAttribute("demandTypeList", demandTypeList);
        return "";
    }

    @RequiresRoles("admin")
    @RequestMapping("/getDemandTypeById/{demandTypeId}")
    public String getDemandTypeById(@PathVariable("demandTypeId") String demandTypeId, Model model) {
        DemandType demandType = demandTypeService.getById(demandTypeId);
        model.addAttribute("demandType", demandType);
        return "";
    }
}
