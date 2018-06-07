package com.leiyuan.dao.impl;

import com.leiyuan.dao.DemandRepository;
import com.leiyuan.entity.Demand;
import com.leiyuan.vo.DemandUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DemandRepositoryImpl extends CommonRepositoryImpl<Demand> implements DemandRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public DemandUser getDemandUser(String demandId) {
        return (DemandUser) getCurrentSession()
                .createQuery("select new com.leiyuan.vo.DemandUser(d.id as demandId,d.typeId as typeId, d.setUserId " +
                        "as setUserId,t.name as typeName, u.num " +
                        "as setUserNum,u.name as setUserName,u.sex as setUserSex,u.star as setUserStar,d.weixin as " +
                        "weixin,d.qq as qq,d.info as info,d.place as place,d.bounty as bounty,d.startTime as " +
                        "startTime,d.endTime as endTime,d.flag as flag) from Demand d,User u,DemandType t where d.id " +
                        "= '" + demandId + "' and u.id=d.setUserId and t.id=d.typeId").uniqueResult();
    }

    @Override
    @Transactional
    public List<Demand> queryByTypeId(String typeId) {
        return (List<Demand>) getCurrentSession().createQuery("from Demand where typeId='" + typeId + "'").list();
    }

    @Override
    @Transactional
    public List<Demand> searchByInfo(String info) {
        return (List<Demand>) getCurrentSession().createQuery("from Demand where info like '%" + info +
                "%' or bounty like '%" + info + "%'").list();
    }
}
