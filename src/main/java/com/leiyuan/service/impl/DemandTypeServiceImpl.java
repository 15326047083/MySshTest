package com.leiyuan.service.impl;

import com.leiyuan.dao.DemandTypeRepository;
import com.leiyuan.entity.DemandType;
import com.leiyuan.service.DemandTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandTypeServiceImpl implements DemandTypeService {
    @Autowired
    private DemandTypeRepository demandTypeRepository;

    @Override
    public String save(DemandType demandType) {
        return demandTypeRepository.save(demandType);
    }

    @Override
    public void saveOrUpdate(DemandType demandType) {
        demandTypeRepository.saveOrUpdate(demandType);
    }

    @Override
    public void delete(String demandTypeId) {
        demandTypeRepository.delete(demandTypeId);
    }

    @Override
    public List<DemandType> queryAll() {
        return demandTypeRepository.queryAll();
    }

    @Override
    public DemandType getById(String demandTypeId) {
        return demandTypeRepository.get(demandTypeId);
    }

    @Override
    public long count() {
        return demandTypeRepository.count();
    }
}
