package com.leiyuan.service.impl;

import com.leiyuan.dao.DemandRepository;
import com.leiyuan.entity.Demand;
import com.leiyuan.service.DemandService;
import com.leiyuan.vo.DemandUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DemandServiceImpl implements DemandService {
    @Autowired
    private DemandRepository demandRepository;

    @Override
    public String save(Demand demand) {
        String time = demand.getEndTime().replaceAll("T", " ");
        //规定日期格式为 yyyy-MM-dd HH:mm
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //实例日期
        Date date = null;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //将日期转为时间戳类型封装至实体类
        demand.setEndLongTime(date.getTime());
        return demandRepository.save(demand);
    }

    @Override
    public Demand get(String demandId) {
        return demandRepository.get(demandId);
    }

    @Override
    public void takeDemand(String demandId, String setUserId) {
        Demand demand = demandRepository.get(demandId);
        if ("null".equals(setUserId)) {
            demand.setSetUserId("");
            demand.setFlag(0);
        } else {
            demand.setSetUserId(setUserId);
            demand.setFlag(1);
        }
        demandRepository.saveOrUpdate(demand);
    }

    @Override
    public List<Demand> getDemandList(int flag) {
        String Sql = "";
        //如果查询等待接单的需求则至展示未过期的需求
        if (flag == 0) {
            Sql = " and endLongTime>" + new Date().getTime();
        }
        //查询以过期需求订单
        else if (flag == 4) {
            Sql = " and endLongTime<" + new Date().getTime();
        }
        String sql = "from Demand where flag=" + flag + Sql;
        return demandRepository.queryAll(sql);
    }

    @Override
    public List<Demand> getMyDemandList(String userId, String flag) {
        String sql = "";
        if ("set".equals(flag)) {
            sql = "from Demand where setUserId='" + userId + "'";
        } else if ("get".equals(flag)) {
            sql = "from Demand where getUserId='" + userId + "'";
        }
        return demandRepository.queryAll(sql);
    }

    @Override
    public DemandUser getDemandUser(String demandId) {
        return demandRepository.getDemandUser(demandId);
    }

}
