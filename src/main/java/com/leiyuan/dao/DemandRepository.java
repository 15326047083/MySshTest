package com.leiyuan.dao;

import com.leiyuan.entity.Demand;
import com.leiyuan.vo.DemandUser;

public interface DemandRepository extends CommonRepository<Demand> {
    DemandUser getDemandUser(String demandId);
}
