package com.leiyuan.dao.impl;

import com.leiyuan.dao.UserRepository;
import com.leiyuan.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends CommonRepositoryImpl<User> implements UserRepository {
}
