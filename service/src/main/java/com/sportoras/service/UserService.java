package com.sportoras.service;

import com.sportoras.connection.ConnectionManager;
import com.sportoras.dao.userDao.UserDao;
import com.sportoras.dao.userDao.UserDaoImpl;
import com.sportoras.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public User findById(Long userId) {
        UserDao userDao = UserDaoImpl.getInstance();
        return userDao.find(ConnectionManager.getSession(), 1L);
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
