package com.leiyuan.service;

import com.leiyuan.entity.DemandType;

import java.util.List;

public interface DemandTypeService {
    String save(DemandType demandType);

    void saveOrUpdate(DemandType demandType);

    void delete(String demandTypeId);

    List<DemandType> queryAll();

    DemandType getById(String demandTypeId);

    long count();
}
