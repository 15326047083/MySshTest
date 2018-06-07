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
            demand.setGetUserId("");
            demand.setFlag(0);
        } else {
            demand.setGetUserId(setUserId);
            demand.setFlag(1);
        }
        demandRepository.saveOrUpdate(demand);
    }

    @Override
    public List<Demand> getDemandList(int flag) {
        String Sql = "";
        //如果查询等待接单的需求则至展示未过期的需求
        if (flag == 0) {
            Sql = "where flag=" + flag + " and endLongTime>" + new Date().getTime();
        }
        //查询以过期需求订单
        else if (flag == 4) {
            Sql = "where endLongTime<" + new Date().getTime();
        } else {
            Sql = "where flag=" + flag;
        }
        String sql = "from Demand " + Sql;
        List<Demand> list = demandRepository.queryAll(sql);
        if (flag == 4) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setFlag(4);
            }
        }
        return list;
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

    @Override
    public List<Demand> queryByTypeId(String typeId) {
        return demandRepository.queryByTypeId(typeId);
    }

    @Override
    public void delete(String id) {
        demandRepository.delete(id);
    }

    @Override
    public void saveOrUpdate(Demand demand) {
        demandRepository.saveOrUpdate(demand);
    }

    @Override
    public long count() {
        return demandRepository.count();
    }

}
