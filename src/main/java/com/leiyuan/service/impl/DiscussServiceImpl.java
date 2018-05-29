package com.leiyuan.service.impl;

import com.leiyuan.dao.DiscussRepository;
import com.leiyuan.entity.Discuss;
import com.leiyuan.service.DiscussService;
import com.leiyuan.vo.DiscussUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService {
    @Autowired
    private DiscussRepository discussRepository;

    @Override
    public void save(Discuss discuss) {
        discussRepository.save(discuss);
    }

    @Override
    public List<DiscussUser> getDiscussList(String getUserId) {
        return discussRepository.getDiscussList(getUserId);
    }
}
