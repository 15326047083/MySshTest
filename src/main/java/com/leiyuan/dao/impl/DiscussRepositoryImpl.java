package com.leiyuan.dao.impl;

import com.leiyuan.dao.DiscussRepository;
import com.leiyuan.entity.Discuss;
import com.leiyuan.vo.DiscussUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DiscussRepositoryImpl extends CommonRepositoryImpl<Discuss> implements DiscussRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<DiscussUser> getDiscussList(String getUserId) {
        return (List<DiscussUser>) getCurrentSession().createQuery("select new com.leiyuan.vo.DiscussUser(d.id as " +
                "discussId,d.setUserId as setUserId,u.name as setUserName,u.num as setUserNum,u.star as setUserStar,d" +
                ".getUserId as getUserId,d.info as info,d.star as star,d.date as date) from  Discuss d,User u where u" +
                ".id=d.setUserId and d.getUserId='" + getUserId + "'").list();
    }

    @Override
    @Transactional
    public List<DiscussUser> queryAllList() {
        return (List<DiscussUser>) getCurrentSession().createQuery("select new com.leiyuan.vo.DiscussUser(d.id as " +
                "discussId,d.setUserId as setUserId,u.name as setUserName,u.num as setUserNum,u.star as setUserStar,d" +
                ".getUserId as getUserId,d.info as info,d.star as star,d.date as date) from  Discuss d,User u where u" +
                ".id=d.setUserId").list();
    }

    @Override
    @Transactional
    public long countByGetUserId(String getUserId) {
        return (long) getCurrentSession().createQuery("select count(*) from Discuss where getUserId='" + getUserId +
                "'").uniqueResult();
    }

    @Override
    @Transactional
    public List<Long> getStarListByGetUserId(String getUserId) {
        return (List<Long>) getCurrentSession().createQuery("select star from Discuss where getUserId='" + getUserId +
                "'").list();
    }
}
