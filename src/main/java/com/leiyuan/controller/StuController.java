package com.leiyuan.controller;

import com.leiyuan.entity.Stu;
import com.leiyuan.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/stu")
public class StuController {
    @Autowired
    private StuService stuService;

    @RequestMapping("/toSave")
    public String toSave(){
        return "save";
    }
    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public String savaStu(Stu stu){
        stuService.saveOrUpdate(stu);
        return "";
    }
}
