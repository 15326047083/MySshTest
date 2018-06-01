package com.leiyuan.dao;

import com.leiyuan.entity.Demand;
import com.leiyuan.vo.DemandUser;

import java.util.List;

public interface DemandRepository extends CommonRepository<Demand> {
    DemandUser getDemandUser(String demandId);

    List<Demand> queryByTypeId(String typeId);
}
