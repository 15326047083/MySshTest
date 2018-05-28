package com.leiyuan.service;

import com.leiyuan.entity.Demand;
import com.leiyuan.vo.DemandUser;

import java.util.List;

public interface DemandService {
    String save(Demand demand);

    Demand get(String demandId);

    void takeDemand(String demandId, String setUserId);

    List<Demand> getDemandList(int flag);

    List<Demand> getMyDemandList(String userId, String flag);

    DemandUser getDemandUser(String demandId);
}
